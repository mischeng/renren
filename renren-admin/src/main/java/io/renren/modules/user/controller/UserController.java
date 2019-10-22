package io.renren.modules.user.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import io.renren.common.utils.ExportExcelUtil;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.user.entity.UserEntity;
import io.renren.modules.user.entity.UserEntity1;
import io.renren.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import io.hz.modules.mis.entity.UserEntity;
//import io.hz.modules.mis.service.UserService;
//import io.hz.common.base.PageUtils;
//import io.hz.common.base.R;



/**
 * 
 *
 * @author xx
 * @email xx
 * @date 2019-07-17 15:40:39
 */
@RestController
@RequestMapping("mis/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 列表
     */

    //导出用户列表
    @RequestMapping("/exportexce2")
    public void c3(HttpServletRequest request, HttpServletResponse response){
        //查询要导出的数据
        //   ExportEntity
        //    private String title;
        //    private Integer nums;
        //    private Integer price;
        //    private String cname;

        // select a.title,a.nums,a.price,b.title as cname from mis_product a,mis_catalogue b WHERE a.cid=b.id
        //"产品名称", "库存", "价格","目录"

        List<UserEntity1> list=userService.getAll();

        //定义列
        String[] columnNames = { "number", "用户ID", "用户名","用户密码","密保问题","密保答案","电话","相片路径" };

        //定义表名称
        String fileName = "用户清单";

        //导出
        ExportExcelUtil<UserEntity1> util = new ExportExcelUtil<UserEntity1>();
        util.exportExcel(fileName, fileName, columnNames, list, response, ExportExcelUtil.EXCEL_FILE_2003);


    }

    //查看用户列表
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        System.out.println("Fdf");
        PageUtils page = userService.queryPage(params);

        System.out.println(params+"Fdf11");
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    //按number查看用户列表
    @RequestMapping("/info/{number}")
    public R info(@PathVariable("number") Integer number){
        UserEntity user = userService.getById(number);

        return R.ok().put("user", user);
    }

    /**
     * 保存
     */

    //添加用户列表
    @RequestMapping("/save")
    public R save(@RequestBody UserEntity user){
        userService.save(user);

        return R.ok();
    }

    /**
     * 修改
     */
    //修改用户
    @RequestMapping("/update")
    public R update(@RequestBody UserEntity user){

        userService.updateById(user);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */

    //删除用户
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] numbers){
        userService.removeByIds(Arrays.asList(numbers));

        return R.ok();
    }

}
