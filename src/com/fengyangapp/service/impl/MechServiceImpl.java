package com.fengyangapp.service.impl;

import net.sf.json.JSONObject;

import com.fengyangapp.mech.dao.GetSuccessBidDao;
import com.fengyangapp.mech.dao.impl.AcceptBidDaoImpl;
import com.fengyangapp.mech.dao.impl.BidFinishedMecDaoImpl;
import com.fengyangapp.mech.dao.impl.CancelBidMechDaoImpl;
import com.fengyangapp.mech.dao.impl.GetAvailableTasksDaoImpl;
import com.fengyangapp.mech.dao.impl.GetCarModelDaoImpl;
import com.fengyangapp.mech.dao.impl.GetFinishedBidsDaoImpl;
import com.fengyangapp.mech.dao.impl.GetMerchanicInfoDaoImpl;
import com.fengyangapp.mech.dao.impl.GetSuccessBidDaoImpl;
import com.fengyangapp.mech.dao.impl.GetUnderwayBidDaoImpl;
import com.fengyangapp.mech.dao.impl.UpdateLocationDaoImpl;
import com.fengyangapp.mech.dao.impl.UploadBidDaoImpl;
import com.fengyangapp.service.MechService;

public class MechServiceImpl implements MechService {

	@Override
	public JSONObject get_available_tasks(Object[] objects) {
		/*
		 * InterFaceName_005 ----get_available_tasks--周围已经出价的车改技工信息
		 */
		GetAvailableTasksDaoImpl dao = new GetAvailableTasksDaoImpl();
		return dao.get_available_tasks(objects);
	}

	@Override
	public JSONObject upload_bid(Object[] objects) {
		/**
		 * public JSONObject upload_bid(Object[] objects);
		 */
		UploadBidDaoImpl dao = new UploadBidDaoImpl();
		return dao.upload_bid(objects);
	}

	/**
	 * InterFaceName_015 ----get_success_bid--用户选择技工后，返回给技工成功的任务表
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_success_bid(Object[] objects) {
		GetSuccessBidDaoImpl dao = new GetSuccessBidDaoImpl();
		return dao.get_success_bid(objects);
	}

	/**
	 * InterFaceName_016 ----accept_bid--技工是否确定为用户服务
	 * 
	 * @param objects
	 * @return
	 */
	@Override
	public JSONObject accept_bid(Object[] objects) {
		AcceptBidDaoImpl dao = new AcceptBidDaoImpl();
		return dao.accept_bid(objects);
	}

	/**
	 * InterFaceName_017--bid_finished_mec--在线下服务完成后，技工申请服务完成。
	 * 
	 * @param objects
	 * @return
	 */
	@Override
	public JSONObject bid_finished_mec(Object[] objects) {
		BidFinishedMecDaoImpl dao = new BidFinishedMecDaoImpl();
		return dao.bid_finished_mec(objects);
	}
	
	
	/**
	 * InterFaceName_021--cancel_bid_mec--技工取消发布的任务
	 * 
	 * @param objects
	 * @return
	 */
	@Override
	public JSONObject cancel_bid_mec(Object[] objects){
		CancelBidMechDaoImpl dao= new CancelBidMechDaoImpl();
		return dao.cancel_bid_mec(objects);
	}
	
	/**
	 * InterFaceName_024--update_location---更新技工的位置
	 * @param objects
	 * @return
	 */
	@Override
	public JSONObject update_location(Object [] objects){
		UpdateLocationDaoImpl dao = new UpdateLocationDaoImpl();
		return dao.update_location(objects);
	}
	/**
	 * InterFaceName_026--get_underway_bid --进行中订单
	 * 
	 * @param objects
	 * @return
	 */
	@Override
	public JSONObject get_underway_bid(Object[] objects){
		GetUnderwayBidDaoImpl dao = new GetUnderwayBidDaoImpl();
		return dao.get_underway_bid(objects);
	}
	
	/**
	 * InterFaceName_027---get_finished_bids-已完成的订单
	 * 
	 * @param objects
	 * @return
	 */
	@Override
	public JSONObject get_finished_bids(Object[] objects){
		GetFinishedBidsDaoImpl dao = new GetFinishedBidsDaoImpl();
		return dao.get_finished_bids(objects);
	}
	
	/**
	 * InterFaceName_028--基本信息获取（当技工类型为车改技工时没有救援类型）--get_merchanic_info
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_merchanic_info(Object[] objects){
		GetMerchanicInfoDaoImpl dao = new GetMerchanicInfoDaoImpl();
		return dao.get_merchanic_info(objects);
	}
	/**
	 * InterFaceName_029-- get_car_model--包括 车系的ID，车的品牌，车的系列名称，车的图片
	 * @return
	 */
	@Override
	public JSONObject get_car_model() {
		GetCarModelDaoImpl dao = new GetCarModelDaoImpl();
		return dao.get_car_model();
	}
}
