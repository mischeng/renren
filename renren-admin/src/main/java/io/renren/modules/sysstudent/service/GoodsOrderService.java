package io.renren.modules.sysstudent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sysstudent.entity.GoodsOrderEntity;
import io.renren.modules.sysstudent.entity.saleEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-07-10 15:20:08
 */
public interface GoodsOrderService extends IService<GoodsOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
    public List<GoodsOrderEntity> findAllorderId();
}

