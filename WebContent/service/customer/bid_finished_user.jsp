<%@page import="com.fengyangapp.service.impl.*"%>
<%@page import="net.sf.json.JSONObject"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *
	 */
	String bid_id = request.getParameter("bid_id");//抢单编号
	String is_finished = request.getParameter("is_finished");//抢单编号
	Object [] objects = new Object[]{bid_id,is_finished};
	CustServiceImpl bid_finished_user = new CustServiceImpl();
	JSONObject json = bid_finished_user.bid_finished_user(objects);
	out.println(json);
%>
