<%@page import="com.fengyangapp.service.impl.*"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *获取可抢的任务列表---005
	 */
	String merchanic_id = request.getParameter("mc_id");//任务编号
	Object [] objects = new Object[]{merchanic_id};
	MechServiceImpl get_available_tasks = new MechServiceImpl();
	JSONObject json = get_available_tasks .get_available_tasks(objects);
	out.println(json);
%>

