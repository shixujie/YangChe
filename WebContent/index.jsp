<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>风扬科技</title>
<meta name="author" content="风扬科技" />
<meta name="copyright" content="风扬科技" />
<meta name="keywords" content="风扬科技" />
<meta name="description" content="风扬科技" />
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath }/fymall/script/show.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>将信息和用户信息发送到服务器</td>
			<td>001:------<input type="button" onclick="InterFace001();"
				value="call_refit" /></td>
			<td>002:------<input type="button" onclick="InterFace002();"
				value="call_rescus" /></td>
		</tr>
		<tr>
			<td>获取附近技工的信息</td>
			<td>003-------<input type="button" onclick="InterFace003();"
				value="get_refit_merchanics_coors" /></td>
			<td>004-------<input type="button" onclick="InterFace004();"
				value="get_rescuet_merchanics_coors" /></td>
		</tr>
		<tr>
			<td>判断是否有技工抢单</td>
			<td>005-------<input type="button" onclick="InterFace005();"
				value="is_available_merchanics_refit" /></td>
			<td>006-------<input type="button" onclick="InterFace006();"
				value="is_available_merchanics_rescue" /></td>
		</tr>

		<tr>
			<td>获取用户发布任务的详细信息</td>
			<td>007-------<input type="button" onclick="InterFace007();"
				value="get_user_info" /></td>
		</tr>
		<tr>
			<td>技工抢单</td>
			<td>008-------<input type="button" onclick="InterFace008();"
				value="refit_care_Orders" /></td>
			<td>009-------<input type="button" onclick="InterFace009();"
				value="refit_care_Orders" /></td>

		</tr>
		<tr>
			<td>周围已经出价的技工信息</td>
			<td>010-------<input type="button" onclick="InterFace010();"
				value="get_refit_bids" /></td>
			<td>011-------<input type="button" onclick="InterFace011();"
				value="get_rescue_bids" /></td>
		</tr>
		<tr>
			<td>发送已选择技工信息</td>
			<td>012-------<input type="button" onclick="InterFace012();"
				value="choose_bid_refit" /></td>
			<td>013-------<input type="button" onclick="InterFace013();"
				value="choose_bid_rescue" /></td>
		</tr>
		<tr>
			<td>技工确认服务</td>
			<td>014-------<input type="button" onclick="InterFace014();"
				value="refit_render_service" /></td>
			<td>015-------<input type="button" onclick="InterFace015();"
				value="rescue_render_service" /></td>
		</tr>
		<tr>
			<td>技工任务完成</td>
			<td>016-------<input type="button" onclick="InterFace016();"
				value="refit_bids_finish" /></td>
			<td>017-------<input type="button" onclick="InterFace017();"
				value="rescue_bids_finish" /></td>
		</tr>
	</table>
</body>