package com.fengyangapp.cust.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.CustDao;

/**
 * @context 描述：InterFaceName_014--用户选择技工--choose_bid
 * @author 史旭杰
 * @version 创建时间：2015年4月19日 上午10:08:53
 */
public interface ChooseBidDao extends CustDao {

	/**
	 * InterFaceName_014--用户选择技工--choose_bid
	 * 
	 * @param objects
	 * @return
	 */
	JSONObject choose_bid(Object[] objects);

}
