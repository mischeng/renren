package io.renren.modules.user.service.impl;


import io.renren.modules.goods.entity.GoodsEntity_i;
import io.renren.modules.user.dao.UserDao;
import io.renren.modules.user.entity.UserEntity;
import io.renren.modules.user.entity.UserEntity1;
import io.renren.modules.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.goods.dao.GoodsDao;
import io.renren.modules.goods.entity.GoodsEntity;
import io.renren.modules.goods.service.GoodsService;

import java.util.Map;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        String username=(String)params.get("userName");
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                new QueryWrapper<UserEntity>()
                        .like(StringUtils.isNotBlank(username), "user_name", username)
        );

        return new PageUtils(page);
    }
    @Override
    public List<UserEntity1> getAll(){
        return baseMapper.getAll();
    }

}
