package io.renren.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;

import io.renren.common.utils.PageUtils;
import io.renren.modules.user.entity.UserEntity;
import io.renren.modules.user.entity.UserEntity1;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author xx
 * @email xx
 * @date 2019-07-17 15:40:39
 */
public interface UserService extends IService<UserEntity> {
    PageUtils queryPage(Map<String, Object> params);
    public List<UserEntity1> getAll();
}

