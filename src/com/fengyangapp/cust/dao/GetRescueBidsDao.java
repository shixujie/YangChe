package com.fengyangapp.cust.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.CustDao;

/**
 * @context 描述：InterFaceName_012--用户获取车改技工抢单表--get_rescue_bids
 * @author 史旭杰
 * @version 创建时间：2015年4月18日 下午5:35:25
 */
public interface GetRescueBidsDao extends CustDao {

	/**
	 * InterFaceName_012--用户获取车改技工抢单表--get_rescue_bids
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_rescue_bids(Object[] objects);
}
