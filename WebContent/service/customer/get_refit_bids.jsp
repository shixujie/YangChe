<%@page import="net.sf.json.JSONObject"%>
<%@page import="com.fengyangapp.service.impl.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *011--用户获取车改技工抢单表
	 */
	String task_id = request.getParameter("task_id");//任务编号
	Object [] objects = new Object[]{task_id};
	CustServiceImpl get_refit_bids = new CustServiceImpl();
	JSONObject json = get_refit_bids.get_refit_bids(objects);
	out.println(json);
%>

<%
%>
