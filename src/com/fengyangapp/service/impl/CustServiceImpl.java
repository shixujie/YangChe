package com.fengyangapp.service.impl;

import java.util.List;

import net.sf.json.JSONObject;

import com.fengyangapp.cust.dao.IsAvailableMerchanicsRefitDao;
import com.fengyangapp.cust.dao.imql.BidFinishedUserDaoimpl;
import com.fengyangapp.cust.dao.imql.CallRefitDaoImpl;
import com.fengyangapp.cust.dao.imql.CallRescueDaoImpl;
import com.fengyangapp.cust.dao.imql.CancelBidUserDaoImpl;
import com.fengyangapp.cust.dao.imql.CancelTaskUserDaoImpl;
import com.fengyangapp.cust.dao.imql.ChooseBidDaoImpl;
import com.fengyangapp.cust.dao.imql.GetBidDaoImpl;
import com.fengyangapp.cust.dao.imql.GetMechanicsDaoImpl;
import com.fengyangapp.cust.dao.imql.GetRefitBidsDaoImpl;
import com.fengyangapp.cust.dao.imql.GetRefitMerchanicsCoorsDaoImpl;
import com.fengyangapp.cust.dao.imql.GetRescueBidsDaoImpl;
import com.fengyangapp.cust.dao.imql.GetRescueMerchanicsCoorsDaoImpl;
import com.fengyangapp.cust.dao.imql.GetUserInfoDaoImpl;
import com.fengyangapp.cust.dao.imql.IsAvailableMerchanicsRefitDaoImpl;
import com.fengyangapp.cust.dao.imql.IsAvailableMerchanicsRescueDaoImpl;
import com.fengyangapp.cust.dao.imql.SubmitCommentDaoImpl;
import com.fengyangapp.service.CustService;

/**
 * @context 描述：service层
 * @author 史旭杰
 * @version 创建时间：2015年4月18日 上午11:22:25
 */
public class CustServiceImpl implements CustService {

	// ----------------InterFaceName_001---start----
	public JSONObject call_refit(Object object) {
		// TODO Auto-generated method stub
		CallRefitDaoImpl dao = new CallRefitDaoImpl();
		return dao.call_refit(object);
	}

	// ----------------InterFaceName_001---end----
	// ***************************

	// ---------------InterFaceName_002------------start----------

	@Override
	public JSONObject call_rescue(Object[] objects) {
		// TODO Auto-generated method stub
		CallRescueDaoImpl dao = new CallRescueDaoImpl();
		return dao.call_rescue(objects);
	}

	// ---------------InterFaceName_002------------end----------

	// ***************************

	// ---------------InterFaceName_003------------start----------
	@Override
	public JSONObject get_refit_merchanics_coors(Object[] objects) {
		GetRefitMerchanicsCoorsDaoImpl dao = new GetRefitMerchanicsCoorsDaoImpl();
		return dao.get_refit_merchanics_coors(objects);
	}

	// ---------------InterFaceName_003------------end----------

	// ***************************
	// ---------------InterFaceName_004------------start----------
	@Override
	public JSONObject get_rescue_merchanics_coors(Object[] objects) {
		GetRescueMerchanicsCoorsDaoImpl dao = new GetRescueMerchanicsCoorsDaoImpl();
		return dao.get_rescue_merchanics_coors(objects);
	}

	// ---------------InterFaceName_004------------end----------
	// ***************************
	// ---------------InterFaceName_006------------start----------
	@Override
	/**
	 * InterFaceName_006----is_available_merchanics_refit 用户可查看是否有车改技工抢单
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject is_available_merchanics_refit(Object[] objects) {
		IsAvailableMerchanicsRefitDaoImpl dao = new IsAvailableMerchanicsRefitDaoImpl();
		return dao.is_available_merchanics_refit(objects);
	}

	// ---------------InterFaceName_006------------end----------

	// ***************************

	// ---------------InterFaceName_007------------start----------
	/**
	 * InterFaceName_007----is_available_merchanics_rescue--在用户提交订单后，
	 * 用户可查看是否有车改技工抢单
	 */
	@Override
	public JSONObject is_available_merchanics_rescue(Object[] objects) {
		IsAvailableMerchanicsRescueDaoImpl dao = new IsAvailableMerchanicsRescueDaoImpl();
		return dao.is_available_merchanics_rescue(objects);
	}

	// ---------------InterFaceName_007------------end----------

	// ***************************
	// ---------------InterFaceName_007------------start----------
	/**
	 * InterFaceName_011--用户获取车改技工抢单表--get_refit_bids
	 * 
	 * @param objects
	 * @return
	 */
	@Override
	public JSONObject get_refit_bids(Object[] objects) {
		GetRefitBidsDaoImpl dao = new GetRefitBidsDaoImpl();
		return dao.get_refit_bids(objects);
	}

	// ---------------InterFaceName_007------------end----------

	// ***************************

	// ---------------InterFaceName_012------------start----------

	/**
	 * InterFaceName_012--用户获取车改技工抢单表--get_rescue_bids
	 * 
	 * @param objects
	 * @return
	 */
	@Override
	public JSONObject get_rescue_bids(Object[] objects) {
		GetRescueBidsDaoImpl dao = new GetRescueBidsDaoImpl();
		return dao.get_rescue_bids(objects);
	}

	// ---------------InterFaceName_012------------end----------

	// ***************************
	// ---------------InterFaceName_013------------end----------
	/**
	 * InterFaceName_013-- 获取抢单技工的详细详细--get_bid
	 * 
	 * @param objects
	 * @return
	 */
	@Override
	public JSONObject get_bid(Object[] objects) {
		GetBidDaoImpl dao = new GetBidDaoImpl();
		return dao.get_bid(objects);

	}

	// ---------------InterFaceName_013------------end----------

	// ***************************
	// ---------------InterFaceName_014------------start----------
	/**
	 * InterFaceName_014--用户选择技工--choose_bid
	 * 
	 * @param objects
	 * @return
	 */
	@Override
	public JSONObject choose_bid(Object[] objects) {
		ChooseBidDaoImpl dao = new ChooseBidDaoImpl();
		return dao.choose_bid(objects);

	}

	// ---------------InterFaceName_014------------end----------

	// ***************************
	// ---------------InterFaceName_018------------start----------
	/**
	 * InterFaceName_018--bid_finished_user----用户确认任务是否完成
	 * 
	 * @param objects
	 * @return
	 */
	@Override
	public JSONObject bid_finished_user(Object[] objects) {
		BidFinishedUserDaoimpl dao = new BidFinishedUserDaoimpl();
		return dao.bid_finished_user(objects);
	}

	// ---------------InterFaceName_018------------end----------

	// ***************************
	// ---------------InterFaceName_019------------start----------
	/**
	 * InterFaceName_019--submit_comment--用户评价
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject submit_comment(Object[] objects) {
		SubmitCommentDaoImpl dao = new SubmitCommentDaoImpl();
		return dao.submit_comment(objects);
	}

	// ---------------InterFaceName_019------------end----------

	// ***************************
	// ---------------InterFaceName_020------------start----------
	/**
	 * InterFaceName_020--cancel_bid_user--用户取消发布的任务
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject cancel_bid_user(Object[] objects) {
		CancelBidUserDaoImpl dao = new CancelBidUserDaoImpl();
		return dao.cancel_bid_user(objects);
	}

	// ---------------InterFaceName_020------------end----------

	// ***************************

	// ---------------InterFaceName_021------------start----------
	/**
	 * InterFaceName_022--cancel_task_user--用户取消呼叫
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject cancel_task_user(Object[] objects) {
		CancelTaskUserDaoImpl dao = new CancelTaskUserDaoImpl();
		return dao.cancel_task_user(objects);
	}

	// ---------------InterFaceName_021------------end----------

	// ***************************

	// ----------------InterFaceName_023---start----

	@Override
	public JSONObject get_mechanics(Object[] object) {
		GetMechanicsDaoImpl dao = new GetMechanicsDaoImpl();
		return dao.get_mechanics(object);
	}

	@Override
	public List<Object> get_refit_mechanics(double[] loc, double[] locErr,
			double range) {
		GetMechanicsDaoImpl dao = new GetMechanicsDaoImpl();
		return dao.get_refit_mechanics(loc, locErr, range);
	}

	@Override
	public List<Object> get_rescue_mechanics(double[] loc, double[] locErr,
			double range) {
		GetMechanicsDaoImpl dao = new GetMechanicsDaoImpl();
		return dao.get_rescue_mechanics(loc, locErr, range);
	}

	// ----------------InterFaceName_023---end----
	// ***************************
	// ----------------InterFaceName_025---start----
	/**
	 * InterFaceName_025--get_user_info--获取用户的信息
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_user_info(Object[] objects) {
		GetUserInfoDaoImpl dao = new GetUserInfoDaoImpl();
		return dao.get_user_info(objects);
	}
	// ----------------InterFaceName_025---end----
	// ***************************
}
