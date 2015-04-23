<%@page import="com.fengyangapp.service.impl.*"%>
<%@page import="net.sf.json.JSONObject"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/**
 * InterFaceName_019--submit_comment--用户评价
 */
	String bid_id = request.getParameter("bid_id");//抢单编号
	String star = request.getParameter("star");//评论星级
	String comment = request.getParameter("comment");//评论星级
	
	Object [] objects = new Object[]{bid_id,star,comment};
	CustServiceImpl submit_comment = new CustServiceImpl();
	JSONObject json = submit_comment.submit_comment(objects);
	out.println(json);
%>
