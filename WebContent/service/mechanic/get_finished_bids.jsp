<%@page import="com.fengyangapp.service.impl.*"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *get_finished_bids-已完成订单---027
	 */
	String merchanic_id = request.getParameter("mc_id");//任务编号
	Object [] objects = new Object[]{merchanic_id};
	MechServiceImpl get_finished_bids = new MechServiceImpl();
	
	JSONObject json = get_finished_bids.get_finished_bids(objects);
	out.println(json);
%>
