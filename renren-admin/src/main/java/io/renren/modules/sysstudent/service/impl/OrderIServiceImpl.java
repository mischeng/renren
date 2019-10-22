package io.renren.modules.sysstudent.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sysstudent.dao.OrderIDao;
import io.renren.modules.sysstudent.entity.OrderIEntity;
import io.renren.modules.sysstudent.service.OrderIService;


@Service("orderIService")
public class OrderIServiceImpl extends ServiceImpl<OrderIDao, OrderIEntity> implements OrderIService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderIEntity> page = this.page(
                new Query<OrderIEntity>().getPage(params),
                new QueryWrapper<OrderIEntity>()
        );

        return new PageUtils(page);
    }

}
