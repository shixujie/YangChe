<%@page import="com.fengyangapp.service.impl.*"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *  28 get_merchanic_info-基本信息获取（当技工类型为车改技工时没有救援类型）
	 */
	String merchanic_id = request.getParameter("mc_id");//任务编号
	Object [] objects = new Object[]{merchanic_id};
	MechServiceImpl get_merchanic_info = new MechServiceImpl();
	JSONObject json = get_merchanic_info.get_merchanic_info(objects);
	out.println(json);
%>

