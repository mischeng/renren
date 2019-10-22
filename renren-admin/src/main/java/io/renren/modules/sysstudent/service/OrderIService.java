package io.renren.modules.sysstudent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sysstudent.entity.OrderIEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-07-23 10:34:01
 */
public interface OrderIService extends IService<OrderIEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

