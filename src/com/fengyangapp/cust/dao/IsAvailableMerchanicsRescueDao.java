package com.fengyangapp.cust.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.CustDao;

/**
 * @context 描述：InterFaceName_007----is_available_merchanics_rescue--在用户提交订单后，
 *          用户可查看是否有车改技工抢单
 * @author 史旭杰
 * @version 创建时间：2015年4月18日 下午4:05:09
 */
public interface IsAvailableMerchanicsRescueDao extends CustDao {

	/**
	 * 在用户提交订单后，用户可查看是否有车改技工抢单
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject is_available_merchanics_rescue(Object[] objects);
}
