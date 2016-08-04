package com.GongQi.paidui.dao.system;

import java.util.List;
import java.util.Map;

import com.GongQi.paidui.dao.base.BaseMapper;
import com.GongQi.paidui.dao.base.MyBatisRepository;
import com.GongQi.paidui.entity.Permissions;



@MyBatisRepository
public interface PermissionsMapper extends BaseMapper<Permissions> {
	public List<Permissions> findByRole(Map<String, Object> params);
}