package com.fengyangapp.mech.dao;

import com.fengyangapp.dao.MechDao;

import net.sf.json.JSONObject;

/**
 * @context 描述： InterFaceName_026--get_underway_bid --进行中订单
 * @author 史旭杰
 * @version 创建时间：2015年4月20日 下午12:08:42
 */
public interface GetUnderwayBidDao extends MechDao {
	/**
	 * InterFaceName_026--get_underway_bid --进行中订单
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_underway_bid(Object[] objects);
}
