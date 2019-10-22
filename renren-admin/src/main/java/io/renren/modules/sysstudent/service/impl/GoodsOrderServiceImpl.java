package io.renren.modules.sysstudent.service.impl;

import io.renren.common.utils.R;
import io.renren.modules.sysstudent.entity.saleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sysstudent.dao.GoodsOrderDao;
import io.renren.modules.sysstudent.entity.GoodsOrderEntity;
import io.renren.modules.sysstudent.service.GoodsOrderService;
import org.springframework.web.bind.annotation.RequestParam;


@Service("goodsOrderService")
public class GoodsOrderServiceImpl extends ServiceImpl<GoodsOrderDao, GoodsOrderEntity> implements GoodsOrderService {

    @Autowired
    private GoodsOrderService goodsOrderService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsOrderEntity> page = this.page(
                new Query<GoodsOrderEntity>().getPage(params),
                new QueryWrapper<GoodsOrderEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<GoodsOrderEntity> findAllorderId(){
        return baseMapper.findAllorderId();
    }

}
