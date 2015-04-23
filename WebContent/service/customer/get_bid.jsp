<%@page import="net.sf.json.JSONObject"%>
<%@page import="com.fengyangapp.service.impl.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *InterFaceName_013-- 获取抢单技工的详细详细--get_bid
	 */
	String bid_id = request.getParameter("bid_id");//任务编号
	Object [] objects = new Object[]{bid_id};
	CustServiceImpl get_bid = new CustServiceImpl();
	JSONObject json = get_bid.get_bid(objects);
	out.println(json);
%>

