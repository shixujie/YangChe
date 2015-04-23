<%@page import="com.fengyangapp.entity.Task"%>
<%@page import="com.fengyangapp.service.impl.CustServiceImpl"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 将改车信息和用户信息发送到服务器
	 */
	 request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");

		Object user_id = request.getParameter("user_id");//用户ID
		Object latitude = request.getParameter("latitude");//维度
		Object longitude = request.getParameter("longitude");//经度
		Object car_id = request.getParameter("car_id");//车ID

		Task task = new Task();
		task.setUser_id(user_id);
		task.setLatitude(latitude);
		task.setLongitude(longitude);
		task.setCar_id(car_id);
		CustServiceImpl call_Refit = new CustServiceImpl();
		JSONObject json = new JSONObject();
		json = call_Refit.call_refit(task);
		out.println(json);
	 
%>