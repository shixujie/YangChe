package com.fengyangapp.mech.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.MechDao;

/**
 * @context 描述：InterFaceName_017--bid_finished_mec--在线下服务完成后，技工申请服务完成。
 * @author 史旭杰
 * @version 创建时间：2015年4月19日 上午11:37:16
 */
public interface BidFinishedMecDao extends MechDao {

	/**
	 * InterFaceName_017--bid_finished_mec--在线下服务完成后，技工申请服务完成。
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject bid_finished_mec(Object[] objects);

}
