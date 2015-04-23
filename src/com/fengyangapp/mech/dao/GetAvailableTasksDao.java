package com.fengyangapp.mech.dao;

import com.fengyangapp.dao.MechDao;

import net.sf.json.JSONObject;

/**
 * @context 描述：InterFaceName_005 ----get_available_tasks--周围已经出价的车改技工信息
 * @author 史旭杰
 * @version 创建时间：2015年4月18日 下午2:58:52
 */

public interface GetAvailableTasksDao extends MechDao {

	/**
	 * InterFaceName_005 ----get_available_tasks--周围已经出价的车改技工信息
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_available_tasks(Object[] objects);

}
