package io.renren.modules.goods.dao;

import io.renren.modules.goods.entity.GoodsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.goods.entity.GoodsEntity_i;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-07-12 09:52:28
 */
@Mapper
public interface GoodsDao extends BaseMapper<GoodsEntity> {
    List<GoodsEntity> get_by_parentid(int parentid);
    List<GoodsEntity> get_by_goodsname(@Param("goodsname") String goodsname, @Param("menuid") int menuid);
    List<GoodsEntity_i> getAll();
}
