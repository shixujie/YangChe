package com.fengyangapp.mech.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.MechDao;

/**
 * @context 描述：InterFaceName_016 ----accept_bid--技工是否确定为用户服务
 * @author 史旭杰
 * @version 创建时间：2015年4月19日 上午10:50:37
 */
public interface AcceptBidDao extends MechDao {

	/**
	 * InterFaceName_016 ----accept_bid--技工是否确定为用户服务
	 * 
	 * @param objects
	 * @return
	 */
	JSONObject accept_bid(Object[] objects);

}
