package com.GongQi.paidui.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.GongQi.paidui.common.Page;
import com.GongQi.paidui.common.ResultCode;
import com.GongQi.paidui.entity.User;
import com.GongQi.paidui.service.UserService;
import com.GongQi.paidui.util.Identities;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired 
	UserService userService;
	
	@RequestMapping("/login")
	public String login(){
		System.out.println("test");
		return "login";
	}
	
	@RequestMapping("/")
	public String list(){
		return "userList";
	}
	@RequestMapping(value = "/info")
	public String info(String opt,Model model) {
		model.addAttribute("opt", opt);
		if ("add".equals(opt)) {
			return "/userInfoAdd";
		}
		return "userInfo";
	}
	@RequestMapping(value = "/insert")
	@ResponseBody
	public Map<String, Object> insert(User user) {
		
		user.setId(Identities.uuid());
		userService.insertSelective(user);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", ResultCode.SUCCESS);
		result.put("resultMsg", "添加用户成功！");
		return result;
	}
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(Page page){
		Map<String, Object> paramMap = page.getParams();
		if (paramMap != null) {
			page.getParams().get("user");
		}
		return userService.pagedByParams(page);
	}
	@RequestMapping(value = "/{usrid}/delete")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("usrid") String usrid) {
		Map<String, Object> result = new HashMap<String, Object>();
		int row = userService.deleteByPrimaryKey(usrid);
		if (row == 1) {
			result.put("result", ResultCode.SUCCESS);
			result.put("resultMsg", "删除用户成功！");
		} else {
			result.put("result", ResultCode.FAILURE);
			result.put("resultMsg", "该用户已不存在！");
		}
		return result;
	}
	@RequestMapping(value = "/{usrid}/edit")
	@ResponseBody
	public Map<String, Object> edit(@PathVariable("usrid") String usrid) {
		Map<String, Object> result = new HashMap<String, Object>();
		int row = userService.deleteByPrimaryKey(usrid);
		if (row == 1) {
			result.put("result", ResultCode.SUCCESS);
			result.put("resultMsg", "删除用户成功！");
		} else {
			result.put("result", ResultCode.FAILURE);
			result.put("resultMsg", "该用户已不存在！");
		}
		return result;
	}
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(User user){
		Map<String, Object> result = new HashMap<String, Object>();
		if (userService.updateByPrimaryKeySelective(user) ==1) {
			result.put("result", ResultCode.SUCCESS);
			result.put("resultMsg", "修改用户成功！");
		} else {
			result.put("result", ResultCode.FAILURE);
			result.put("resultMsg", "修改用户失败！");
		}
		return result;
	}
}
