package io.renren.modules.sysstudent.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sysstudent.entity.OrderIEntity;
import io.renren.modules.sysstudent.service.OrderIService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-07-23 10:34:01
 */
@RestController
@RequestMapping("sysstudent/orderi")
public class OrderIController {
    @Autowired
    private OrderIService orderIService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sysstudent:orderi:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderIService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{numble}")
    @RequiresPermissions("sysstudent:orderi:info")
    public R info(@PathVariable("numble") Integer numble){
        OrderIEntity orderI = orderIService.getById(numble);

        return R.ok().put("orderI", orderI);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sysstudent:orderi:save")
    public R save(@RequestBody OrderIEntity orderI){
        orderIService.save(orderI);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sysstudent:orderi:update")
    public R update(@RequestBody OrderIEntity orderI){
        ValidatorUtils.validateEntity(orderI);
        orderIService.updateById(orderI);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sysstudent:orderi:delete")
    public R delete(@RequestBody Integer[] numbles){
        orderIService.removeByIds(Arrays.asList(numbles));

        return R.ok();
    }

}
