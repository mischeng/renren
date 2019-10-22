package io.renren.modules.cataloguetwo.controller;

import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.cataloguetwo.entity.CataloguetwoEntity;
import io.renren.modules.cataloguetwo.service.CataloguetwoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/Cataloguetwo/Cataloguetwo")
@ResponseBody
public class CataloguetwoController {
    @Autowired
    private CataloguetwoService cataloguetwoService;

    /**
     * 列表
     */
//    @RequestMapping("/list")
//    @RequiresPermissions("Catalogueone:Catalogueone:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = catalogueoneService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


    /**
     * 信息
     */
    //二级商品目录列表
    @RequestMapping("/info/{number}")
    @RequiresPermissions("cataloguetwo:cataloguetwo:info")
    public R info(@PathVariable("number") Integer number){
        CataloguetwoEntity goods = cataloguetwoService.getById(number);

        return R.ok().put("goods", goods);
    }

    /**
     * 保存
     */
    //添加二级商品目录
    @RequestMapping("/save")
    @RequiresPermissions("cataloguetwo:cataloguetwo:save")
    public R save(@RequestBody CataloguetwoEntity goods){
        cataloguetwoService.save(goods);

        return R.ok();
    }

    /**
     * 修改
     */
    //修改二级商品目录
    @RequestMapping("/update")
    @RequiresPermissions("cataloguetwo:cataloguetwo:update")
    public R update(@RequestBody CataloguetwoEntity goods){
        ValidatorUtils.validateEntity(goods);
        cataloguetwoService.updateById(goods);

        return R.ok();
    }

    /**
     * 删除
     */

    //删除二级商品目录
    @RequestMapping("/delete")
    @RequiresPermissions("cataloguetwo:cataloguetwo:delete")
    public R delete(@RequestBody Integer[] numbers){
        cataloguetwoService.removeByIds(Arrays.asList(numbers));

        return R.ok();
    }

}
