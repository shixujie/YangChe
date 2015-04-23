package com.fengyangapp.cust.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.CustDao;
/**
 * @context 描述：InterFaceName_025--get_user_info--获取用户的信息
 * @author 史旭杰
 * @version 创建时间：2015年4月19日 下午10:14:15
 */
public interface GetUserInfoDao extends CustDao {

	/**
	 * InterFaceName_025--get_user_info--获取用户的信息
	 * @param objects
	 * @return
	 */
	public JSONObject get_user_info(Object[] objects);
}
