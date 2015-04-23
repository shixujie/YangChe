<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0023)http://demo.shopxx.net/ -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>风扬科技</title>
<meta name="author" content="风扬科技" />
<meta name="copyright" content="风扬科技" />
<meta name="keywords" content="风扬科技" />
<meta name="description" content="风扬科技" />
<link
	href="${pageContext.servletContext.contextPath }/fymall/css/appindex1.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath }/fymall/script/show.js"></script>
</head>
<body>
	<div class="div">
		<div class="div001">
			<a>customerAction_call_refit</a> <br /> <br />
			<form id="formid" method='post' action="customerAction_call_refit">
				用户ID：<input type="text" name="user_id" id="user_id" /> <br /> <br />
				经度：<input type="text" name="longitude" id="longitude" /> <br /> <br />
				纬度：<input type="text" name="latitude" id="latitude" /><br /> <br />
				<input type="submit" />
			</form>
		</div>
		<div class="div001">
			<a>customerAction_call_rescus</a> <br /> <br />
			<form id="formid" method='post' action="customerAction_call_rescus">
				用户ID：<input type="text" name="user_id" id="user_id" /> <br /> <br />
				经度：<input type="text" name="longitude" id="longitude" /> <br /> <br />
				纬度：<input type="text" name="latitude" id="latitude" /><br /> <br />
				<input type="submit" />
			</form>
		</div>
	</div>
	<div class="div">
		<div class="div001">
			<a>customerAction_get_refit_merchanics_coors</a> <br /> <br />
			<form id="formid" method='post'
				action="customerAction_get_refit_merchanics_coors">
				用户ID：<input type="text" name="user_id" id="user_id" /> <br /> <br />
				经度：<input type="text" name="longitude" id="longitude" /> <br /> <br />
				纬度：<input type="text" name="latitude" id="latitude" /><br /> <br />
				<input type="submit" />
			</form>
		</div>
		<div class="div001">
			<b><a>customerAction_get_rescus_merchanics_coors</a> </b><br /> <br />
			<form id="formid" method='post'
				action="customerAction_get_refit_merchanics_coors">
				用户ID：<input type="text" name="user_id" id="user_id" /> <br /> <br />
				经度：<input type="text" name="longitude" id="longitude" /> <br /> <br />
				纬度：<input type="text" name="latitude" id="latitude" /><br /> <br />
				<input type="submit" />
			</form>
		</div>
	</div>
</body>