package io.renren.modules.cataloguetwo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.catalogueone.service.CatalogueoneService;
import io.renren.modules.cataloguetwo.dao.CataloguetwoDao;
import io.renren.modules.cataloguetwo.entity.CataloguetwoEntity;
import io.renren.modules.cataloguetwo.service.CataloguetwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cataloguetwoService")
public class CataloguetwoControllerImpI extends ServiceImpl<CataloguetwoDao, CataloguetwoEntity> implements CataloguetwoService {
    @Autowired
    private CataloguetwoService cataloguetwoService;
    @Override
   public void delete_by_cataloguetwo_id(int id){
        baseMapper.delete_by_cataloguetwo_id(id);
    }
    @Override
    public void update_by_cataloguetwo_id(CataloguetwoEntity cataloguetwoEntity)
    {
        baseMapper.update_by_cataloguetwo_id(cataloguetwoEntity);
    }
}
