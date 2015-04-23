package com.fengyangapp.cust.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.CustDao;

/**
 * @context 描述：InterFaceName_013-- 获取抢单技工的详细详细--get_bid
 * @author 史旭杰
 * @version 创建时间：2015年4月19日 上午9:49:09
 */
public interface GetBidDao extends CustDao {

	/**
	 * InterFaceName_013-- 获取抢单技工的详细详细--get_bid
	 * 
	 * @param objects
	 * @return
	 */
	JSONObject get_bid(Object[] objects);

}
