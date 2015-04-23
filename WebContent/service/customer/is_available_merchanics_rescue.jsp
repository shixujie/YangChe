<%@page import="com.fengyangapp.cust.dao.imql.IsAvailableMerchanicsRescueDaoImpl"%>
<%@page import="com.fengyangapp.service.impl.*"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 *007-在用户提交订单后，用户可查看是否有车改技工抢单--is_available_merchanics_rescue
	 */

	String task_id = request.getParameter("task_id");//任务编号
	Object[] objects = new Object[] { task_id };
	IsAvailableMerchanicsRescueDaoImpl is_available_merchanics_rescue = new IsAvailableMerchanicsRescueDaoImpl();
	JSONObject json = is_available_merchanics_rescue
	.is_available_merchanics_rescue(objects);
	out.println(json);
%>
