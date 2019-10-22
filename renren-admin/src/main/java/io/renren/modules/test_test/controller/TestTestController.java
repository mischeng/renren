package io.renren.modules.test_test.controller;

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

import io.renren.modules.test_test.entity.TestTestEntity;
import io.renren.modules.test_test.service.TestTestService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-07-22 20:19:31
 */
@RestController
@RequestMapping("test_test/testtest")
public class TestTestController {
    @Autowired
    private TestTestService testTestService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("test_test:testtest:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = testTestService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("test_test:testtest:info")
    public R info(@PathVariable("id") Integer id){
        TestTestEntity testTest = testTestService.getById(id);

        return R.ok().put("testTest", testTest);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("test_test:testtest:save")
    public R save(@RequestBody TestTestEntity testTest){
        testTestService.save(testTest);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("test_test:testtest:update")
    public R update(@RequestBody TestTestEntity testTest){
        ValidatorUtils.validateEntity(testTest);
        testTestService.updateById(testTest);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("test_test:testtest:delete")
    public R delete(@RequestBody Integer[] ids){
        testTestService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
