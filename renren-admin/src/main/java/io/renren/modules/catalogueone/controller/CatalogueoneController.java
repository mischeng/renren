package io.renren.modules.catalogueone.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.catalogueone.entity.CatalogueoneEntity;
import io.renren.modules.catalogueone.service.CatalogueoneService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/Catalogueone/Catalogueone")
public class CatalogueoneController {
    @Autowired
private CatalogueoneService catalogueoneService;

    /**
     * 列表
     */


    /**
     * 信息
     */

    //一级商品目录查看
    @RequestMapping("/info/{number}")
    @RequiresPermissions("goods:goods:info")
    public R info(@PathVariable("number") Integer number){
        CatalogueoneEntity goods = catalogueoneService.getById(number);

        return R.ok().put("goods", goods);
    }

    /**
     * 保存
     */
    //添加一级商品目录
    @RequestMapping("/save")
    @RequiresPermissions("catalogueone:catalogueone:save")
    public R save(@RequestBody CatalogueoneEntity catalogueoneEntity){
        catalogueoneService.save(catalogueoneEntity);

        return R.ok();
    }

    /**
     * 修改
     */
    //修改一级商品目录
    @RequestMapping("/update")
    @RequiresPermissions("catalogueone:catalogueone:update")
    public R update(@RequestBody CatalogueoneEntity catalogueoneEntity){
        ValidatorUtils.validateEntity(catalogueoneEntity);
        catalogueoneService.updateById(catalogueoneEntity);

        return R.ok();
    }

    /**
     * 删除
     */
    //删除一级商品目录
    @RequestMapping("/delete")
    @RequiresPermissions("catalogueone:catalogueone:delete")
    public R delete(@RequestBody Integer[] numbers){
        catalogueoneService.removeByIds(Arrays.asList(numbers));

        return R.ok();
    }

}
