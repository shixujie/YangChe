function trim(str) { // 删除左右两端的空格
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
/**
 * 呼叫车改 call_refit
 */
function InterFace001() {
	window.location.href = "customerAction_call_refit?user_id=1&longitude=112&latitude=35";
}
/**
 * 呼叫救援 call_rescus
 */
function InterFace002() {
	// alert("InterFace002");
	// $.ajax({
	//
	// type: "post",
	//
	// url: "customerAction_call_rescue.action",
	//
	// data: {user_id:1, longitude:112,latitude:35},
	//
	// dataType: "json",
	//
	// success: function(data){
	// alert(data);
	// }
	//
	// });
	window.location.href = "customerAction_call_rescue?user_id=1&longitude=112&latitude=35";
}
/**
 * 获取附近车改技工的信息 get_refit_merchanics_coors
 */
function InterFace003() {
	window.location.href = "customerAction_get_refit_merchanics_coors?user_id=1&longitude=116.317&latitude=39.98";
}
/**
 * 获取附近救援技工的信息 get_rescuet_merchanics_coors
 */
function InterFace004() {
	window.location.href = "customerAction_get_rescue_merchanics_coors?user_id=1&longitude=116.317&latitude=39.98";
}

/*-------------------------------*/
/**
 * 
 */
function InterFace005() {
	window.location.href = "customerAction_is_available_merchanics_refit?user_id=1&longitude=112&latitude=35";
}
/**
 */
function InterFace006() {
	window.location.href = "customerAction_is_available_merchanics_rescue?user_id=1&longitude=112&latitude=35";
}
/**
 */
function InterFace007() {
	window.location.href = "mechanicAction_get_user_info?user_id=1";
}
/**
 */
function InterFace008() {
	window.location.href = "mechanicAction_refit_care_orders?user_id=1&mc_id=1&price=100";
}
/**
 */
function InterFace009() {
	window.location.href = "mechanicAction_rescue_care_orders?user_id=1&mc_id=1&price=100";
}
/**
 */
function InterFace010() {
	window.location.href = "customerAction_get_refit_bids?user_id=1";
}
/**
 */
function InterFace011() {
	window.location.href = "customerAction_get_rescue_bids?user_id=1";
}
/**
 */
function InterFace012() {
	window.location.href = "customerAction_choose_bid_refit?user_id=1&mc_id=1";
}
/**
 */
function InterFace013() {
	window.location.href = "customerAction_choose_bid_rescue?user_id=1&mc_id=1";
}
/**
 */
function InterFace014() {
	window.location.href = "mechanicAction_refit_render_service?user_id=1&mc_id=1";
}
/**
 */
function InterFace015() {
	window.location.href = "mechanicAction_rescue_render_service?user_id=1&mc_id=1";
}
/**
 */
function InterFace016() {
	window.location.href = "customerAction_refit_bids_finish?user_id=1&bid_id=fy_20150331-110530979";
}
/**
 */
function InterFace017() {
	window.location.href = "customerAction_rescue_bids_finish?user_id=1&mc_id=1";
}