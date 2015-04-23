package com.fengyangapp.mech.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.MechDao;

/**
 * @context 描述：InterFaceName_021--cancel_bid_mec--技工取消发布的任务
 * @author 史旭杰
 * @version 创建时间：2015年4月19日 下午6:44:26
 */
public interface CancelBidMechDao extends MechDao {

	/**
	 * InterFaceName_021--cancel_bid_mec--技工取消发布的任务
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject cancel_bid_mec(Object[] objects);

}
