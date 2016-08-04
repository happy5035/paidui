package com.GongQi.paidui.dao.system;

import java.util.List;
import java.util.Map;

import com.GongQi.paidui.dao.base.BaseMapper;
import com.GongQi.paidui.dao.base.MyBatisRepository;
import com.GongQi.paidui.entity.Role;



@MyBatisRepository
public interface RoleMapper extends BaseMapper<Role> {
   public List<Role> findByAccount(Map<String, Object> params);
}