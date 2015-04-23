package com.fengyangapp.cust.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.CustDao;
/**
 * @context 描述：InterFaceName_020--cancel_bid_user--用户取消发布的任务
 * @author 史旭杰
 * @version 创建时间：2015年4月19日 下午6:22:24
 */
public interface CancelBidUserDao extends CustDao {

	/**
	 * InterFaceName_020--cancel_bid_user--用户取消发布的任务
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject cancel_bid_user(Object[] objects);

}
