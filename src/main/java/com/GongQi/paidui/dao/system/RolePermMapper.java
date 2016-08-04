package com.GongQi.paidui.dao.system;

import java.util.List;
import java.util.Map;

import com.GongQi.paidui.dao.base.BaseMapper;
import com.GongQi.paidui.dao.base.MyBatisRepository;
import com.GongQi.paidui.entity.RolePerm;



@MyBatisRepository
public interface RolePermMapper extends BaseMapper<RolePerm> {
    public int deleteByKey(Map<String, Object> params);
    public int insertMultiple(List<RolePerm> rolepermList);
}