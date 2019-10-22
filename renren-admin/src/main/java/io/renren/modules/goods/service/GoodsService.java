package io.renren.modules.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.goods.entity.GoodsEntity;
import io.renren.modules.goods.entity.GoodsEntity_i;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-07-12 09:52:28
 */
public interface GoodsService extends IService<GoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    public List<GoodsEntity> get_by_parentid(int parnetid);
    public List<GoodsEntity> get_by_goodsname(String goodsname,int menuid);
    public List<GoodsEntity_i> getAll();
}

