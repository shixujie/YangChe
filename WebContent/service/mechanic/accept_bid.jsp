<%@page import="com.fengyangapp.service.impl.*"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *InterFaceName_016 ----accept_bid--技工是否确定为用户服务
	 */
	String bid_id = request.getParameter("bid_id");//技工的抢单号
	String is_accept = request.getParameter("is_accept");//技工是否接受任务
	Object [] objects = new Object[]{bid_id,is_accept};
	MechServiceImpl accept_bid = new MechServiceImpl();
	JSONObject json = accept_bid.accept_bid(objects);
	out.println(json);
%>
