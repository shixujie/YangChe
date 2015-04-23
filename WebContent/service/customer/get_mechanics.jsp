<%@page import="com.fengyangapp.service.impl.*"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *获取附近技工的信息(初始打开软件时)
	 */
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/json;charset=utf-8");

	Object o0 = request.getParameter("latitude");//维度
	Object o1 = request.getParameter("longitude");//经度
	Object [] object = new Object[]{o0,o1};
	CustServiceImpl get_mechanics = new CustServiceImpl();
	JSONObject json = new JSONObject();
	json = get_mechanics.get_mechanics(object);
	out.println(json);
%>