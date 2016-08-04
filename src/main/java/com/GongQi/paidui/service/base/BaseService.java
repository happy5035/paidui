package com.GongQi.paidui.service.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.GongQi.paidui.common.Page;




public interface BaseService<T> {
	
	public int deleteByPrimaryKey(Serializable id);
	
	public int insert(T record);
	
	public int insertSelective(T record);
	
	public T selectByPrimaryKey(Serializable id);
	
	public List<T> selectAll();
	
	public List<T> selectAll(String sort, String order);
	
	public int updateByPrimaryKeySelective(T record);
	
	public int updateByPrimaryKey(T record);
	
	public List<T> findByParams(Map<String, Object> params);
	
	public List<T> findByParams(Map<String, Object> params, String sort, String order);
	
	public int findByParamsCount(Map<String, Object> params);
				
	public Map<String, Object> pagedByParams(Map<String, Object> params, int page, int rows);
	
	public Map<String, Object> pagedByParams(Map<String, Object> params, int page, int rows, String sort, String order);
	
	public Map<String, Object> pagedByParams(Page page);
	
	public int findByKeyCount(String key, String value);
	
	public int findByKeyCount(String ckey, Object cvalue, String pkey, Object pvalue);
	
	public List<T> findByKey(Serializable key, Serializable value);
	
	public List<T> findByKey(String ckey, String cvalue, String pkey, String pvalue);
	
}
