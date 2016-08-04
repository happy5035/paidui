<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title>用户列表</title>
	    	<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/main.css" />">
			<link rel="stylesheet" type="text/css" href="<c:url value="/static/easyui/themes/default/easyui.css" />">
			<link rel="stylesheet" type="text/css" href="<c:url value="/static/easyui/themes/icon.css" />">
			<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/font-awesome-4.2.0/css/font-awesome.min.css" />">
			<script type="text/javascript" src="<c:url value="/static/easyui/jquery.min.js" />"></script>
			<script type="text/javascript" src="<c:url value="/static/easyui/jquery.easyui.min.js" />"></script>
			<script type="text/javascript" src="<c:url value="/static/easyui/locale/easyui-lang-zh_CN.js" />"></script>
			<script type="text/javascript" src="<c:url value="/static/js/main.js" />"></script>
			<script type="text/javascript" src="<c:url value="/static/js/validateboxRules.js" />"></script>
		
	</head>
<body>
	<div style="padding-top:15px; padding-left:5px; padding-right:15px;">			 
		<div id="userSd" class="easyui-panel" title="查询条件" style="height:100px;padding:10px; margin-bottom:10px;" data-options="collapsible:true">
		     <form action="" id="userShForm">            
		                    用户名：<input  name="name" id="nameOfShForm">
		                    年龄：<input name="age" id="ageOfShForm">
		       	地址：<input name="address" id="addressOfShFrom" class="easyui-textbox">                 
	            <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchLoad('userDg','userShForm')">查询</a>
	         </form> 
		</div>  
     	<div id="userTb" style="margin-bottom:5px">
            <a href="#" class="easyui-linkbutton" iconCls="fa fa-plus fa-lg" plain="true" onclick="newuser()">添加</a>
            <a href="#" class="easyui-linkbutton" iconCls="fa fa-pencil-square-o fa-lg" plain="true" onclick="edituser()">修改</a>
            <a href="#" class="easyui-linkbutton" iconCls="fa fa-trash-o fa-lg" plain="true" onclick="destroyuser()">删除</a>
            <a href="#" class="easyui-linkbutton" iconCls="fa fa-crosshairs fa-lg" plain="true" onclick="viewuser()">查看</a>
        </div>      
        <table id="userDg"   title="用户列表"   url="list" method="post" 	    		
	    		rownumbers="true" fitColumns="true" singleSelect="true" toolbar="#userTb"
	    		sortName="id" sortOrder="asc"  
	    		pagination="true" pageSize="20" pageList="[10,20,50,100]" striped="true">
	        <thead>
	            <tr>	            	
	            	<th field="id" hidden="true">ID</th>
	                <th field="name" sortable="true" width="100">用户名</th>
	                <th field="pwd" sortable="true" width="100">密码</th>
	                <th field="age" sortable="true" width="100">年龄</th>
	                <th field='address' sortable="true" width="100">地址</th>
	            </tr>
	        </thead>
	    </table>
	    <div id="userDlg" class="easyui-dialog" style="width:400px;height:500px;padding:10px 20px"
            closed="true" collapsible="true" minimizable="true" maximizable="true" resizable ="true"
             buttons="#userDlg-buttons" >
         </div>
	    <div id="userDlg-buttons">
	        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveuser()" style="width:90px" id="userSave">保存</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#userDlg').dialog('close')" style="width:90px">取消</a>
	    </div>
	</div>   
	<script type="text/javascript">	
			function userSexFmt(value, row, index){
				if (value == 0){  
	                 return '女';  
	             } else {  
	                 return '男';  
	             }
			}
			function userStateFmt(value, row, index){
				if (value == 0){  
	                 return '<div class="div-state-off">禁用</div>';  
	             } else {  
	                 return '<div class="div-state-on">可用</div>';  
	             }
			}
			
			$('#parkinglotidOfShForm').combobox({    
	            url:'parkinglot/parkinglots',    
	            valueField:'parkinglotid',    
	            textField:'parkinglotname' ,
	            onSelect: function (record) {
	            	var url='parkinglot/slice/list?parkinglotid=' + record.parkinglotid;
	            	$('#parkinglotsliceidOfShForm').combobox('clear');
	                $('#parkinglotsliceidOfShForm').combobox('reload', url);
	            }
	        });
	        $('#parkinglotsliceidOfShForm').combobox({
                valueField: 'parkinglotsliceid',
                textField: 'slicename'
            });
			
			//dg在初始化时加入查询条件
			$('#userDg').datagrid({
				queryParams: dgParams('userShForm')
			});		

			var userOptUrl;
			//添加
		    function newuser(){
		    	$('#userSave').show();	       	       
		    	newHrefObj('userDlg','<c:url value="/user/info?opt=add" />','添加用户','userInfoForm');
		        userOptUrl = "insert";
		    }
		    function edituser(){
		    	$('#userSave').show();
		    	var userDgRow =getSelectRow('userDg');
		    	if(userDgRow){
		    		openHrefLoadDlg('userDlg','<c:url value="/user/info?opt=edit" />','编辑用户','userInfoForm',userDgRow);
		    	}		    	
		    	userOptUrl = "update"
		    }
		    
		    function viewuser(){
		    	$('#userSave').hide();
		    	var userDgRow =getSelectRow('userDg');
		    	if(userDgRow){
		    		openHrefLoadDlg('userDlg','<c:url value="/user/info?opt=edit" />','编辑用户','userInfoForm',userDgRow);
		    	}
		    }
		    
		    function saveuser(){
		    	saveObj('userDg', 'userDlg', 'userInfoForm', userOptUrl);
		    }
		    
		    function destroyuser() {
		    	destroyObj('userDg',getSelectRow('userDg').id+'/delete');			
			}
			
	</script> 
</body>
</html>
