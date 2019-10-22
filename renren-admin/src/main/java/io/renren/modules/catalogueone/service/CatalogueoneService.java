package io.renren.modules.catalogueone.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.catalogueone.entity.CatalogueoneEntity;

public interface CatalogueoneService extends IService<CatalogueoneEntity> {
    void delete_by_catalogueone_id(int id);
    void update_by_catalogueone_id(CatalogueoneEntity catalogueoneEntity);
}
