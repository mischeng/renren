package io.renren.modules.goods.controller;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.List;

import io.renren.common.utils.ExportExcelUtil;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.goods.entity.GoodsEntity_i;
import io.renren.modules.sys.entity.SysMenuEntity;
import io.renren.modules.sys.service.SysMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.goods.entity.GoodsEntity;
import io.renren.modules.goods.service.GoodsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-07-12 09:52:28
 */
@RestController
@RequestMapping("goods/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SysMenuService sysMenuService;

    private   int parent_id=0;
    private  int menuid=0;
    /**
     * 列表
     */
//查看商品列表
    @RequestMapping("/list")
    @RequiresPermissions("goods:goods:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsService.queryPage(params);
        List<GoodsEntity>goodsEntity=null;
        if (params.get("goodsName")!=null){
            if(params.get("goodsName").toString()!=""){
            String goodsname="%"+params.get("goodsName").toString()+"%";
            goodsEntity=goodsService.get_by_goodsname(goodsname,menuid);}
        }else {
            goodsEntity= goodsService.get_by_parentid(menuid);

        }
        page.setList(goodsEntity);
        return R.ok().put("page", page);
    }
    //打印商品
    @RequestMapping("/exportexcel")
    public void exportexcel(HttpServletRequest request,HttpServletResponse response){
        List<GoodsEntity_i>goodsEntities=goodsService.getAll();
        String[] columnNames={"商品名","商品描述","商品价格","数量","商品状态"
                ,"图片","发布时间"};
        String filename="商品发布清单";
        ExportExcelUtil<GoodsEntity_i> util=new ExportExcelUtil<GoodsEntity_i>();
        util.exportExcel(filename,filename,columnNames,goodsEntities,response,ExportExcelUtil.EXCEL_FILE_2003);
    }

    /**
     * 信息
     */
    //查找商品
    @RequestMapping("/info/{number}")
    @RequiresPermissions("goods:goods:info")
    public R info(@PathVariable("number") Integer number){

        GoodsEntity goodsEntity = goodsService.getById(number);
//        List<GoodsEntity>goodsEntity=goodsService.get_by_parentid(parent_id);
//        System.out.println(goodsEntity);
//        System.out.println(parent_id+"kkkkkkkkk");
        return R.ok().put("goods", goodsEntity);
    }
    //获取商品父级id
@RequestMapping("/get_parent_id")
public void get_parent_id(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        String url=request.getParameter("url");
        parent_id=Integer.parseInt(request.getParameter("parent_id"));
        menuid=Integer.parseInt(request.getParameter("menuid"));
        System.out.println(url);
        resp.sendRedirect("/renren-admin/index.html#"+url);
}
    /**
     * 保存
     */
//添加商品
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @RequiresPermissions("goods:goods:save")
    public String save(@RequestParam("image") MultipartFile[] files,HttpServletRequest request,HttpServletResponse response) throws ParseException, IOException, ServletException {
       GoodsEntity goods=new GoodsEntity();
       goods.setTextarea(request.getParameter("textarea"));
       goods.setGoodsName(request.getParameter("goods_name"));
      goods.setAmount(Integer.parseInt(request.getParameter("amount")));
      goods.setPrice(Float.parseFloat(request.getParameter("price")));

        String name= null;
        for(int i = 0;i<files.length;i++){
            System.out.println("fileName---------->" + files[i].getOriginalFilename());

            if(!files[i].isEmpty()){
                int pre = (int) System.currentTimeMillis();
                try {
                    name =new Date().getTime()+request.getParameter("goods_name") +files[i].getOriginalFilename();
                    //拿到输出流，同时重命名上传的文件
                    FileOutputStream os = new FileOutputStream("C://Users//adminstrator//Desktop//shixun//renrenio-renren-security-master//renren-security//renren-admin//src//main//resources//statics//image//" + name);
                    //拿到上传文件的输入流
                    FileInputStream in = (FileInputStream) files[i].getInputStream();

                    //以写字节的方式写文件
                    int b = 0;
                    while((b=in.read()) != -1){
                        os.write(b);
                    }
                    os.flush();
                    os.close();
                    in.close();
                    int finaltime = (int) System.currentTimeMillis();
                    System.out.println(finaltime - pre);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("上传出错");
                }
            }
        }
        SysMenuEntity sysMenuEntity=sysMenuService.getById(parent_id);

        goods.setCataloguetwoId(menuid);

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        goods.setGoodsId(uuid);
        goods.setImage("http://127.0.0.1:8080/renren-admin/statics/image/"+name);
        goods.setStatus(1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time=df.format(new Date());
        Date time1=df.parse(time);
        String url="modules/goods/goods.html";
        goods.setTime(time1);
        goodsService.save(goods);
     return "添加成功";

    }

    /**
     * 修改
     */
    //修改商品
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @RequiresPermissions("goods:goods:update")
    public R update(@RequestBody GoodsEntity goods){
        ValidatorUtils.validateEntity(goods);
        goodsService.updateById(goods);
        
        return R.ok();
    }

    /**
     * 删除
     */
    //删除商品
    @RequestMapping("/delete")
    @RequiresPermissions("goods:goods:delete")
    public R delete(@RequestBody Integer[] numbers){
        goodsService.removeByIds(Arrays.asList(numbers));
        return R.ok();
    }

}
