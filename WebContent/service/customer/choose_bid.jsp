<%@page import="net.sf.json.JSONObject"%>
<%@page import="com.fengyangapp.service.impl.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *InterFaceName_014--用户选择技工--choose_bid
	 */
	String bid_id = request.getParameter("bid_id");//任务编号
	Object[] objects = new Object[] { bid_id };
	CustServiceImpl choose_bid = new CustServiceImpl();
	JSONObject json = choose_bid.choose_bid(objects);
	out.println(json);
%>
