package com.fengyangapp.mech.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.CustDao;

/**
 * @context 描述：InterFaceName_027---get_finished_bids-已完成的订单
 * @author 史旭杰
 * @version 创建时间：2015年4月20日 下午5:02:15
 */
public interface GetFinishedBidsDao extends CustDao {

	/**
	 * InterFaceName_027---get_finished_bids-已完成的订单
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_finished_bids(Object[] objects);
}
