package io.renren.modules.cataloguetwo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.cataloguetwo.entity.CataloguetwoEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CataloguetwoDao extends BaseMapper<CataloguetwoEntity> {
    void delete_by_cataloguetwo_id(int id);
    void update_by_cataloguetwo_id(CataloguetwoEntity cataloguetwoEntity);
}
