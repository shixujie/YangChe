package com.fengyangapp.service;

import java.util.List;

import net.sf.json.JSONObject;

public interface CustService {

	/**
	 * InterFaceName_001----call_refit-将改车信息和用户信息发送到服务器
	 * 
	 * @param o0
	 * @param o1
	 * @param o2
	 * @param o3
	 * @return
	 */
	public JSONObject call_refit(Object object);

	/**
	 * InterFaceName_002----call_rescue--将救援信息和用户信息发送到服务器
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject call_rescue(Object[] objects);

	/**
	 * 描述：InterFaceName_003-----get_refit_merchanics_coors----获取附近车改技工位置
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_refit_merchanics_coors(Object[] objects);

	/**
	 * InterFaceName_004----get_rescue_merchanics_coors 获取附近的救援技工位置及姓名
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_rescue_merchanics_coors(Object[] objects);

	/**
	 * InterFaceName_006----is_available_merchanics_refit 用户可查看是否有车改技工抢单
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject is_available_merchanics_refit(Object[] objects);

	/**
	 * InterFaceName_007----is_available_merchanics_rescue--在用户提交订单后，
	 * 用户可查看是否有车改技工抢单
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject is_available_merchanics_rescue(Object[] objects);

	/**
	 * InterFaceName_011--用户获取车改技工抢单表--get_refit_bids
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_refit_bids(Object[] objects);

	/**
	 * InterFaceName_012--用户获取车改技工抢单表--get_rescue_bids
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_rescue_bids(Object[] objects);

	/**
	 * InterFaceName_013-- 获取抢单技工的详细详细--get_bid
	 * 
	 * @param objects
	 * @return
	 */
	JSONObject get_bid(Object[] objects);

	/**
	 * InterFaceName_014--用户选择技工--choose_bid
	 * 
	 * @param objects
	 * @return
	 */
	JSONObject choose_bid(Object[] objects);

	/**
	 * InterFaceName_018--bid_finished_user----用户确认任务是否完成
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject bid_finished_user(Object[] objects);

	/**
	 * InterFaceName_019--submit_comment--用户评价
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject submit_comment(Object[] objects);

	/**
	 * InterFaceName_020--cancel_bid_user--用户取消发布的任务
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject cancel_bid_user(Object[] objects);
	
	/**
	 * InterFaceName_022--cancel_task_user--用户取消呼叫
	 * @param objects
	 * @return
	 */
	public JSONObject cancel_task_user(Object[] objects);

	/**
	 * InterFaceName_023--get_mechanics--打开软件时，默认加载附近的技工（包括车改和救援）
	 * 
	 * @param object
	 * @return
	 */
	public JSONObject get_mechanics(Object[] object);

	public List<Object> get_refit_mechanics(double[] loc, double[] locErr,
			double range);

	public List<Object> get_rescue_mechanics(double[] loc, double[] locErr,
			double range);
	
	/**
	 * InterFaceName_026--get_user_info--获取用户的信息
	 * @param objects
	 * @return
	 */
	public JSONObject get_user_info(Object[] objects);
}
