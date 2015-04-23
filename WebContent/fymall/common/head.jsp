<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页头</title>
<link
	href="${pageContext.servletContext.contextPath }/fymall/css/slider1.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.servletContext.contextPath }/fymall/css/common1.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="${pageContext.servletContext.contextPath }/index.jsp">
					<img
					src="${pageContext.servletContext.contextPath }/fymall/img/logo1.gif"
					alt="Zpark商城" />
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img
					src="${pageContext.servletContext.contextPath }/fymall/img/header.jpg"
					width="320" height="50" alt="正品保障" title="正品保障" />
			</div>
		</div>
		<div class="span10 last">
			<div class="topNav clearfix">
				<ul>
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"><a
						href="custLoginUrl?url=login">登录</a>|</li>
					<li id="headerRegister" class="headerRegister"
						style="display: list-item;"><a
						href="custRegisterUrl?url=register">注册</a>|
					</li>
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"><a
						href="custInfoUrl?url=homePage"><font
							color="red"> 
						</font></a> <a href="exitLogin">[注销]</a></li>
					<!-- <li id="headerUsername" class="headerUsername"></li>
				<li id="headerLogout" class="headerLogout">
					<a href="">[退出]</a>|
				</li> -->
					<li><a href="">风扬养车</a>|</li>
					<li><a href="">会员中心</a>|</li>
					<li><a href="">关于我们</a></li>
				</ul>
			</div>
			<div class="cart">
				<a href="shoppingcart_gotocart.action" id="cartNum">购物车</a>
			</div>
			<div class="phone">
				客服热线:<strong>101-8888888</strong>
			</div>
		</div>
	</div>
</body>
</html>