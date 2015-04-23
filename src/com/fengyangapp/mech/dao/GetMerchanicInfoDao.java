package com.fengyangapp.mech.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.MechDao;

/**
 * @context 描述：InterFaceName_028--基本信息获取（当技工类型为车改技工时没有救援类型）--get_merchanic_info
 * @author 史旭杰
 * @version 创建时间：2015年4月21日 上午11:09:28
 */
public interface GetMerchanicInfoDao extends MechDao {

	/**
	 * InterFaceName_028--基本信息获取（当技工类型为车改技工时没有救援类型）--get_merchanic_info
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject get_merchanic_info(Object[] objects);
}
