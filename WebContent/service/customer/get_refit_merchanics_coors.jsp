<%@page import="com.fengyangapp.cust.dao.imql.GetRefitMerchanicsCoorsDaoImpl"%>
<%@page import="com.fengyangapp.service.impl.*"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *003 用户获取附近的车改技工位置及姓名--get_refit_merchanics_coors
	 */
	/*
	 *	String sign = request.getParameter("sign");//扩大或者缩小范围的标志
	 */
	String task_id = request.getParameter("task_id");//任务编号
	Object[] objects = new Object[] { task_id };
	GetRefitMerchanicsCoorsDaoImpl get_refit_merchanics_coors = new GetRefitMerchanicsCoorsDaoImpl();
	JSONObject json = get_refit_merchanics_coors
	.get_refit_merchanics_coors(objects);
	out.println(json);
%>
