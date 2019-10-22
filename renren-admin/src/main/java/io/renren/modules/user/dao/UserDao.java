package io.renren.modules.user.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.user.entity.UserEntity;
import io.renren.modules.user.entity.UserEntity1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author xx
 * @email xx
 * @date 2019-07-17 15:40:39
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
	public List<UserEntity1>getAll();
}
