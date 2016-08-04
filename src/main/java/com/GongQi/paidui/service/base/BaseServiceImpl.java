package com.GongQi.paidui.service.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.GongQi.paidui.common.Page;
import com.GongQi.paidui.dao.base.BaseMapper;



public class BaseServiceImpl<T> implements BaseService<T> {
	
	@Autowired
	BaseMapper<T> baseMapper;

	
	public static int DEFAULT_PAGESIZE = 20;
	
	public int deleteByPrimaryKey(Serializable id) {
		return baseMapper.deleteByPrimaryKey(id);
	}
	
	public int insert(T record) {
		return baseMapper.insert(record);
	}
	
	public int insertSelective(T record) {
		return baseMapper.insertSelective(record);
	}
	
	public T selectByPrimaryKey(Serializable id) {
		return baseMapper.selectByPrimaryKey(id);
	}
	
	public List<T> selectAll() {
		return baseMapper.selectAll(null);
	}
	
	public List<T> selectAll(String sort, String order) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sortName", sort);
		params.put("sortOrder", order);
		return baseMapper.selectAll(params);
	}
	
	public int updateByPrimaryKeySelective(T record) {
		return baseMapper.updateByPrimaryKeySelective(record);
	}
	
	public int updateByPrimaryKey(T record) {
		return baseMapper.updateByPrimaryKey(record);
	}
	
	public List<T> findByParams(Map<String, Object> params) {
		return baseMapper.findByParams(params);
	}
	
	public List<T> findByParams(Map<String, Object> params, String sort, String order) {
		params.put("sortName", sort);
		params.put("sortOrder", order);
		return baseMapper.findByParams(params);
	}
	
	public int findByParamsCount(Map<String, Object> params) {
		return baseMapper.findByParamsCount(params);
	}
				
	public Map<String, Object> pagedByParams(Map<String, Object> params, int page, int rows) {
		 //当前页  
        int intPage = page == 0 ? 1 : page;  
        //每页显示条数  
        int pageSize = rows == 0 ? DEFAULT_PAGESIZE : rows;  
        //每页的开始记录  
        int startNum = (intPage-1)*pageSize;
        params.put("pageSize", pageSize);
	    params.put("startNum", startNum);
		List<T> data = baseMapper.findByParams(params);
		int total = baseMapper.findByParamsCount(params);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("total", total);
		resultMap.put("rows", data);
		return resultMap;
	}
	
	public Map<String, Object> pagedByParams(Map<String, Object> params, int page, int rows, String sort, String order) {
		//当前页  
	    int intPage = page == 0 ? 1 : page;  
	    //每页显示条数  
	    int pageSize = rows == 0 ? DEFAULT_PAGESIZE : rows;  
        //每页的开始记录  
        int startNum = (intPage-1)*pageSize;
		 params.put("pageSize", pageSize);
		 params.put("startNum", startNum);
		 params.put("sortName", sort);
		 params.put("sortOrder", order);
		 List<T> data = baseMapper.findByParams(params);
		 int total = baseMapper.findByParamsCount(params);
		 Map<String, Object> resultMap = new HashMap<String, Object>();
		 resultMap.put("total", total);
		 resultMap.put("rows", data);
		return resultMap;
	}
	
	public Map<String, Object> pagedByParams(Page page) {
		//当前页  
		int intPage = page.getPage() == 0 ? 1 : page.getPage();  
		//每页显示条数  
		int pageSize = page.getRows() == 0 ? DEFAULT_PAGESIZE : page.getRows();  
		//每页的开始记录  
		int startNum = (intPage-1)*pageSize;
		Map<String, Object> params = page.getParams();
		if (null == params ) {
			params = new HashMap<String, Object>();
		}
		 params.put("pageSize", pageSize);
		 params.put("startNum", startNum);
		 params.put("sortName",page.getSort());
		 params.put("sortOrder",  page.getOrder());
		 List<T> data = baseMapper.findByParams(params);
		 int total = baseMapper.findByParamsCount(params);
		 Map<String, Object> resultMap = new HashMap<String, Object>();
		 resultMap.put("total", total);
		 resultMap.put("rows", data);
		return resultMap;
	}
	
	public int findByKeyCount(String key, String value) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ckey", key);
		params.put("cvalue", value);
		return baseMapper.findByKeyCount(params);
	}
	
	public int findByKeyCount(String ckey, Object cvalue, String pkey, Object pvalue) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ckey", ckey);
		params.put("cvalue", cvalue);
		if(pkey != null && pkey != "" && pvalue != null && pvalue != ""){
			params.put("pkey", pkey);
			params.put("pvalue", pvalue);
		}		
		return baseMapper.findByKeyCount(params);
	}	
	
	
	
	public List<T> findByKey(Serializable key, Serializable value) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ckey", key);
		params.put("cvalue", value);
		return baseMapper.findByKey(params);
	}
	
	public List<T> findByKey(String ckey, String cvalue, String pkey, String pvalue) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ckey", ckey);
		params.put("cvalue", cvalue);
		if(pkey != null && pkey != "" && pvalue != null && pvalue != ""){
			params.put("pkey", pkey);
			params.put("pvalue", pvalue);
		}		
		return baseMapper.findByKey(params);
	}
	
	
	
}
