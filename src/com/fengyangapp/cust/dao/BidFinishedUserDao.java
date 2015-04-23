package com.fengyangapp.cust.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.CustDao;

/**
 * @context 描述：InterFaceName_018--bid_finished_user----用户确认任务是否完成
 * @author 史旭杰
 * @version 创建时间：2015年4月19日 上午11:51:43
 */
public interface BidFinishedUserDao extends CustDao {

	/**
	 * InterFaceName_018--bid_finished_user----用户确认任务是否完成
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject bid_finished_user(Object[] objects);

}
