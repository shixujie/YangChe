<%@page import="net.sf.json.JSONObject"%>
<%@page import="com.fengyangapp.service.impl.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/**
 * InterFaceName_020--cancel_bid_user--用户取消发布的任务
 */
	String bid_id = request.getParameter("bid_id");//任务编号
	Object [] objects = new Object[]{bid_id};
	CustServiceImpl cancel_bid_user = new CustServiceImpl();
	JSONObject json = cancel_bid_user.cancel_bid_user(objects);
	out.println(json);
%>

