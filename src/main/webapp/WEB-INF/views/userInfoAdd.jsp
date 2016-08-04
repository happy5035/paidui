<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
    
</head>
<body>   
        <div style="padding:10px 20px 20px 10px">
        <div class="ftitle">用户信息</div>
        <form id="userInfoForm" name="userInfoForm" method="post" >
            <table cellpadding="2">
                <tr   >
                    <td>用户名称:</td>
                    <td >
                    	 <input  name="name" id="useridOfinfo"
   							 data-options="required:true">
					</td>
				</tr>
				
				<tr>
                    <td>用户密码:</td>
                    <td><input class="easyui-validatebox textbox" type="text" name="pwd"></input></td>
                </tr>
				<tr>
                    <td>用户年龄:</td>
                    <td><input class="easyui-validatebox textbox" type="text" name="age"></input></td>
                </tr>
                <tr>
                    <td>用户地址:</td>
                    <td><input class="easyui-validatebox textbox" type="text" name="address"></input></td>
                </tr>
                
           
        </form>
        
        </div>
   
</body>
</html>
