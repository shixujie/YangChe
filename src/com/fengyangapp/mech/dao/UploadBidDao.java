package com.fengyangapp.mech.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.MechDao;

/**
 * @context 描述：InterFaceName_009 ----upload_bid--技工抢单
 * @author 史旭杰
 * @version 创建时间：2015年4月18日 下午5:14:27
 */
public interface UploadBidDao extends MechDao {
	/**
	 * InterFaceName_009 ----upload_bid--技工抢单
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject upload_bid(Object[] objects);

}
