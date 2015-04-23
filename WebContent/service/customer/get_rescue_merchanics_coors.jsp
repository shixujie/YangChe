<%@page import="com.fengyangapp.service.impl.*"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *004 用户获取附近的救援技工位置及姓名--get_refit_merchanics_coors
	 */
	/*
	 *	String sign = request.getParameter("sign");//扩大或者缩小范围的标志
	 */
	String task_id = request.getParameter("task_id");//任务编号
	Object[] objects = new Object[] { task_id };
	CustServiceImpl get_rescue_merchanics_coors = new CustServiceImpl();
	JSONObject json = get_rescue_merchanics_coors
	.get_rescue_merchanics_coors(objects);
	out.println(json);
%>
