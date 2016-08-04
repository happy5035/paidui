package com.GongQi.paidui.dao;

import com.GongQi.paidui.dao.base.BaseMapper;
import com.GongQi.paidui.dao.base.MyBatisRepository;
import com.GongQi.paidui.entity.User;
@MyBatisRepository
public interface UserMapper extends BaseMapper<User>{
    int deleteByPrimaryKey(Object id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}