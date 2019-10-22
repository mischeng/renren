package io.renren.modules.sysstudent.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.sysstudent.entity.saleEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.sysstudent.entity.GoodsOrderEntity;
import io.renren.modules.sysstudent.service.GoodsOrderService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-07-10 15:20:08
 */
@RestController
@RequestMapping("sysstudent/goodsorder")
public class GoodsOrderController {
    @Autowired
    private GoodsOrderService goodsOrderService;


@GetMapping("/findorderId")
public List<GoodsOrderEntity> getOrderId(){

    return goodsOrderService.findAllorderId();

}


@RequestMapping("/infoMoney/{orderId}")
public R infoMoney(@PathVariable("orderId") String orderId){

        return R.ok().put("Money", goodsOrderService.getById(orderId).getMoney());
        }

@RequestMapping("/infoAmount/{orderId}")
    public R infoAmount(@PathVariable("orderId") String orderId){

    return R.ok().put("Amount",goodsOrderService.getById(orderId).getAmount());
}



    /*
    *
     * 列表
     */
  /*  @RequestMapping("/list")
    @RequiresPermissions("sysstudent:goodsorder:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsOrderService.queryPage(params);


        return R.ok().put("page", page);
    }


*//*    *
     * 信息
     *//*
    *//*@RequestMapping("/info/{orderId}")
    @RequiresPermissions("sysstudent:goodsorder:info")
    public R info(@PathVariable("orderId") String orderId){
        GoodsOrderEntity goodsOrder = goodsOrderService.getById(orderId);

        return R.ok().put("goodsOrder", goodsOrder);
    }*//*

//    *
//     * 保存

    @RequestMapping("/save")
    @RequiresPermissions("sysstudent:goodsorder:save")
    public R save(@RequestBody GoodsOrderEntity goodsOrder){
        goodsOrderService.save(goodsOrder);

        return R.ok();
    }

   *//* *
     * 修改
     *//*
    @RequestMapping("/update")
    @RequiresPermissions("sysstudent:goodsorder:update")
    public R update(@RequestBody GoodsOrderEntity goodsOrder){
        ValidatorUtils.validateEntity(goodsOrder);
        goodsOrderService.updateById(goodsOrder);
        
        return R.ok();
    }

   *//* *
     * 删除*//*

    @RequestMapping("/delete")
    @RequiresPermissions("sysstudent:goodsorder:delete")
    public R delete(@RequestBody String[] orderIds){
        goodsOrderService.removeByIds(Arrays.asList(orderIds));

        return R.ok();
    }*/

}
