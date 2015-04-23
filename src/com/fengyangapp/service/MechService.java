package com.fengyangapp.service;

import net.sf.json.JSONObject;

public interface MechService {

	/**
	 * InterFaceName_005 ----get_available_tasks--周围已经出价的车改技工信息
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_available_tasks(Object[] objects);

	/**
	 * InterFaceName_009 ----upload_bid--技工抢单
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject upload_bid(Object[] objects);

	/**
	 * InterFaceName_015 ----get_success_bid--用户选择技工后，返回给技工成功的任务表
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_success_bid(Object[] objects);

	/**
	 * InterFaceName_016 ----accept_bid--技工是否确定为用户服务
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject accept_bid(Object[] objects);

	/**
	 * InterFaceName_017--bid_finished_mec--在线下服务完成后，技工申请服务完成。
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject bid_finished_mec(Object[] objects);

	/**
	 * InterFaceName_021--cancel_bid_mec--技工取消发布的任务
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject cancel_bid_mec(Object[] objects);

	/**
	 * InterFaceName_024--update_location---更新技工的位置
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject update_location(Object[] objects);
	/**
	 * InterFaceName_026--get_underway_bid --进行中订单
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_underway_bid(Object[] objects);
	/**
	 * InterFaceName_027---get_finished_bids-已完成的订单
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_finished_bids(Object[] objects);
	/**
	 * InterFaceName_028--基本信息获取（当技工类型为车改技工时没有救援类型）--get_merchanic_info
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_merchanic_info(Object[] objects);
	
	/**
	 * InterFaceName_029-- get_car_model--包括 车系的ID，车的品牌，车的系列名称，车的图片
	 * @return
	 */
	public JSONObject get_car_model ();
}
