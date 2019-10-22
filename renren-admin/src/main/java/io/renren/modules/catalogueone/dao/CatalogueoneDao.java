package io.renren.modules.catalogueone.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.catalogueone.entity.CatalogueoneEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CatalogueoneDao extends BaseMapper<CatalogueoneEntity> {
    void delete_by_catalogueone_id(int id);
    void update_by_catalogueone_id(CatalogueoneEntity catalogueoneEntity);
}
