package io.renren.modules.catalogueone.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.catalogueone.dao.CatalogueoneDao;
import io.renren.modules.catalogueone.entity.CatalogueoneEntity;
import io.renren.modules.catalogueone.service.CatalogueoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("catalogueoneService")
public class CatalogueoneControllerImpI extends ServiceImpl<CatalogueoneDao, CatalogueoneEntity> implements CatalogueoneService {
    @Autowired
    private CatalogueoneService catalogueoneService;
    @Override
    public  void delete_by_catalogueone_id(int id){
       baseMapper.delete_by_catalogueone_id(id);

    }
    @Override
    public void update_by_catalogueone_id(CatalogueoneEntity catalogueoneEntity){
        baseMapper.update_by_catalogueone_id(catalogueoneEntity);
    }
}
