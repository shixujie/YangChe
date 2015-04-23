<%@page import="com.fengyangapp.service.impl.*"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *  InterFaceName_029-- get_car_model--包括 车系的ID，车的品牌，车的系列名称，车的图片
	 */
	String merchanic_id = request.getParameter("mc_id");//任务编号
	Object [] objects = new Object[]{merchanic_id};
	MechServiceImpl get_car_model = new MechServiceImpl();
	JSONObject json = get_car_model.get_car_model();
	out.println(json);
%>

