<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单</title>
</head>
<body>
<div class="container header">

		<div class="span24">
			<ul class="mainNav">
				<li><a href="${pageContext.servletContext.contextPath }/index.jsp">首页</a>|</li>
				<li><a href="">微型车</a>|</li>
				<li><a href="">小型车</a>|</li>
				<li><a href="">紧凑型车</a>|</li>
				<li><a href="">中型车</a>|</li>
				<li><a href="">中大型车</a>|</li>
				<li><a href="">豪华车</a>|</li>
				<li><a href="">suv</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="tagWrap">
				<ul class="tag">
					<li class="icon"
						style="background: url(${pageContext.servletContext.contextPath }/fymall/img/hot.gif) right no-repeat;"><a
						href="">热销</a></li>
					<li class="icon"
						style="background: url(${pageContext.servletContext.contextPath }/fymall/img/new.gif) right no-repeat;"><a
						href="">最新</a></li>
				</ul>
				<div class="hotSearch">
					热门搜索: <a href="">奔驰</a> <a href="">宝马</a> <a href="">奥迪</a> <a
						href="">凯迪拉克</a> <a href="">雪佛兰</a> <a href="">现代</a> <a href="">大众</a>
				</div>
				<div class="search">
					<form id="productSearchForm" action="" method="get">
						<input name="keyword" class="keyword" placeholder="搜索"
							maxlength="30" />
						<button type="submit">搜索</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>