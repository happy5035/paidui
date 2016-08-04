<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>停车后台管理系统</title>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/main.css" />">
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/easyui/themes/metro/easyui.css" />">
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/easyui/themes/icon.css" />">
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/font-awesome-4.2.0/css/font-awesome.min.css" />">
		<script type="text/javascript" src="<c:url value="/static/easyui/jquery.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/static/easyui/jquery.easyui.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/static/easyui/locale/easyui-lang-zh_CN.js" />"></script>
		<script type="text/javascript" src="<c:url value="/static/js/main.js" />"></script>
		<script type="text/javascript" src="<c:url value="/static/js/validateboxRules.js" />"></script>
		<script type="text/javascript">
			//获取验证码    
			function changeValidateCode(obj) {
				var timenow = new Date().getTime();
				document.getElementById("imgObj").src = "VerifyCode?d="
						+ timenow;
			}
		</script>
</head>
<body>
   
    <form action="login" method="post" id="loginForm">
    <div  style="algin:center;margin-top:10%">
        <div style="margin-bottom:10px">
            <input name="username" class="easyui-textbox" style="width:300px;height:40px;padding:12px" data-options="prompt:'用户名',iconCls:'icon-man',iconWidth:38">
        </div>
        <div style="margin-bottom:10px">
            <input name="password" class="easyui-textbox" type="password" style="width:300px;height:40px;padding:12px" data-options="prompt:'密码',iconCls:'icon-lock',iconWidth:38">
        </div>
        <div style="margin-bottom:10px;">
            <input name="validateCode" class="easyui-textbox"  style="width:170px;height:40px;" data-options="prompt:'验证码'">
            <img id="imgObj" style="height:40px;"  title="点击我,换一个！" src="VerifyCode" onclick="changeValidateCode()"/>
        </div>
        <div>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:300px;" onclick="submitForm('#loginForm')">
                <span style="font-size:14px;">登录</span>
            </a>
        </div>
        <div style="color:red">
           ${message }
        </div>
    </div>
    </form>
</body>
</html>

