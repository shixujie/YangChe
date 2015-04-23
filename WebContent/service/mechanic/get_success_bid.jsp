<%@page import="com.fengyangapp.service.impl.*"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *get_success_bid-获取可抢的任务列表---015
	 */
	String merchanic_id = request.getParameter("mc_id");//任务编号
	Object [] objects = new Object[]{merchanic_id};
	MechServiceImpl get_success_bid = new MechServiceImpl();
	
	JSONObject json = get_success_bid.get_success_bid(objects);
	out.println(json);
%>

