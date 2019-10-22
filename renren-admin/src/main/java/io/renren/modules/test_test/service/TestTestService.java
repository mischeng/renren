package io.renren.modules.test_test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.test_test.entity.TestTestEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-07-22 20:19:31
 */
public interface TestTestService extends IService<TestTestEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

