package io.renren.modules.test_test.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.test_test.dao.TestTestDao;
import io.renren.modules.test_test.entity.TestTestEntity;
import io.renren.modules.test_test.service.TestTestService;


@Service("testTestService")
public class TestTestServiceImpl extends ServiceImpl<TestTestDao, TestTestEntity> implements TestTestService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TestTestEntity> page = this.page(
                new Query<TestTestEntity>().getPage(params),
                new QueryWrapper<TestTestEntity>()
        );

        return new PageUtils(page);
    }

}
