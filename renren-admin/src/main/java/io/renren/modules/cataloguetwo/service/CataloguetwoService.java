package io.renren.modules.cataloguetwo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.catalogueone.entity.CatalogueoneEntity;
import io.renren.modules.cataloguetwo.entity.CataloguetwoEntity;

public interface CataloguetwoService extends IService<CataloguetwoEntity> {
    void delete_by_cataloguetwo_id(int id);
    void update_by_cataloguetwo_id(CataloguetwoEntity cataloguetwoEntity);
}
