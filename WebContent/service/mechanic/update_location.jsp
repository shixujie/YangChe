<%@page import="com.fengyangapp.service.impl.MechServiceImpl"%>
<%@page import="com.fengyangapp.entity.Task"%>
<%@page import="com.fengyangapp.service.impl.CustServiceImpl"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *
	 */
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/json;charset=utf-8");

	Object mc_Id = request.getParameter("mc_id");//技工ID
	Object latitude = request.getParameter("latitude");//维度
	Object longitude = request.getParameter("longitude");//经度
	Object [] objects = new Object[]{mc_Id,latitude,longitude};
	MechServiceImpl update_location = new MechServiceImpl();
	JSONObject json = update_location.update_location(objects);
	out.println(json);
%>