package com.fengyangapp.mech.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.MechDao;

/**
 * @context 描述：InterFaceName_015 ----get_success_bid--用户选择技工后，返回给技工成功的任务表
 * @author 史旭杰
 * @version 创建时间：2015年4月19日 上午11:23:03
 */
public interface GetSuccessBidDao extends MechDao {

	/**
	 * InterFaceName_015 ----get_success_bid--用户选择技工后，返回给技工成功的任务表
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_success_bid(Object[] objects);

}
