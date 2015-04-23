<%@page import="com.fengyangapp.service.impl.*"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *006-在用户提交订单后，用户可查看是否有车改技工抢单--is_available_merchanics_refit
	 */

	String task_id = request.getParameter("task_id");//任务编号
	Object[] objects = new Object[] { task_id };
	CustServiceImpl is_available_merchanics_refit = new CustServiceImpl();
	JSONObject json = is_available_merchanics_refit
	.is_available_merchanics_refit(objects);
	out.println(json);
%>
