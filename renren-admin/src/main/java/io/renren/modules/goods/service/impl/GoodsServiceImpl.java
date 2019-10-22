package io.renren.modules.goods.service.impl;

import io.renren.modules.goods.entity.GoodsEntity_i;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.goods.dao.GoodsDao;
import io.renren.modules.goods.entity.GoodsEntity;
import io.renren.modules.goods.service.GoodsService;


@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, GoodsEntity> implements GoodsService {

    @Autowired
    private GoodsService goodsService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsEntity> page = this.page(
                new Query<GoodsEntity>().getPage(params),
                new QueryWrapper<GoodsEntity>()
        );

        return new PageUtils(page);
    }
    @Override
    public List<GoodsEntity_i> getAll(){
        return  baseMapper.getAll();
    }
    @Override
    public List<GoodsEntity>get_by_goodsname(String goodsname,int menuid){
        System.out.println(goodsname);
        return baseMapper.get_by_goodsname(goodsname,menuid);
    }
    @Override
    public List<GoodsEntity> get_by_parentid(int parentid){
        return  baseMapper.get_by_parentid(parentid);
    }

}
