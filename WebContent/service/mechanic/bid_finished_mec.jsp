<%@page import="com.fengyangapp.service.impl.*"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *InterFaceName_017--bid_finished_mec--在线下服务完成后，技工申请服务完成。
	 */
	String bid_id = request.getParameter("bid_id");//任务编号
	Object [] objects = new Object[]{bid_id};
	MechServiceImpl bid_finished_mec = new MechServiceImpl();
	JSONObject json = bid_finished_mec.bid_finished_mec(objects);
	out.println(json);
%>

