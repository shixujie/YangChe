<%@page import="com.fengyangapp.service.impl.*"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	将救援信息和用户信息发送到服务器
	 */
	
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/json;charset=utf-8");
	
	Object o0 = request.getParameter("user_id");//用户ID
	Object o1 = request.getParameter("longitude");//经度
	Object o2 = request.getParameter("latitude");//维度
	Object o3 = request.getParameter("car_id");//车ID
	Object o4 = request.getParameter("rescue_type");//救援类型
	
	Object [] objects = new Object[]{o0,o1,o2,o3,o4};
	CustServiceImpl call_rescue = new CustServiceImpl();
	
	JSONObject json = call_rescue.call_rescue(objects);
	out.println(json);
%>