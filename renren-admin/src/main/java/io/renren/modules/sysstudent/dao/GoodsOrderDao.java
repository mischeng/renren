package io.renren.modules.sysstudent.dao;

import io.renren.modules.sysstudent.entity.GoodsOrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-07-10 15:20:08
 */
@Mapper
public interface GoodsOrderDao extends BaseMapper<GoodsOrderEntity> {
    public List<GoodsOrderEntity> findAllorderId();
}
