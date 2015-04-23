<%@page import="net.sf.json.JSONObject"%>
<%@page import="com.fengyangapp.service.impl.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/**
 * InterFaceName_022--cancel_task_user--用户取消呼叫
 */
	String task_id = request.getParameter("task_id");//任务编号
	Object [] objects = new Object[]{task_id};
	CustServiceImpl cancel_task_user = new CustServiceImpl();
	JSONObject json = cancel_task_user.cancel_task_user(objects);
	out.println(json);
%>
