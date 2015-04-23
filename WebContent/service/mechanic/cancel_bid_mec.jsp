<%@page import="net.sf.json.JSONObject"%>
<%@page import="com.fengyangapp.service.impl.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/**
 * InterFaceName_021--cancel_bid_mec--技工取消发布的任务
 */
	String bid_id = request.getParameter("bid_id");//任务编号
	Object [] objects = new Object[]{bid_id};
	MechServiceImpl cancel_bid_mec = new MechServiceImpl();
	JSONObject json = cancel_bid_mec.cancel_bid_mec(objects);
	out.println(json);
%>

