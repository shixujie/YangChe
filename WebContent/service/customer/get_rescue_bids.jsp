<%@page import="com.fengyangapp.service.impl.CustServiceImpl"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="com.fengyangapp.service.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *
	 */
	String task_id = request.getParameter("task_id");//任务编号
	Object [] objects = new Object[]{task_id};
	CustServiceImpl get_rescue_bids = new CustServiceImpl();
	JSONObject json = get_rescue_bids.get_rescue_bids(objects);
	out.println(json);
%>
