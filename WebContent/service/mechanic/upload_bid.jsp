<%@page import="com.fengyangapp.service.impl.*"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 * 提交出价
	 */
	String merchanic_id = request.getParameter("mc_id");//技工编号
	String task_id = request.getParameter("task_id");//任务编号
	String price = request.getParameter("price");//技工出价
	Object[] objects = new Object[] { merchanic_id, task_id, price };
	MechServiceImpl upload_bid = new MechServiceImpl();

	JSONObject json = upload_bid.upload_bid(objects);
	out.println(json);
%>

