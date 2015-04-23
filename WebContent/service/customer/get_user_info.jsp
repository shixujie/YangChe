<%@page import="com.fengyangapp.entity.Task"%>
<%@page import="com.fengyangapp.service.impl.CustServiceImpl"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/**
	 * InterFaceName_025--get_user_info--获取用户的信息
	 */
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/json;charset=utf-8");
	Object user_id = request.getParameter("user_id");//用户ID
	Object[] objects = new Object[] { user_id };
	CustServiceImpl get_user_info = new CustServiceImpl();
	JSONObject json = get_user_info.get_user_info(objects);
	out.println(json);
%>