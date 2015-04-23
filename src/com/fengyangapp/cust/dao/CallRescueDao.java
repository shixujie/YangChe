package com.fengyangapp.cust.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.CustDao;
/**
 * @context 描述：InterFaceName_002----call_rescue--将救援信息和用户信息发送到服务器
 * @author 史旭杰
 * @version 创建时间：2015年4月18日 下午12:46:53
 */
public interface CallRescueDao extends CustDao {

	/**
	 * InterFaceName_002----call_rescue--将救援信息和用户信息发送到服务器
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject call_rescue(Object [] objects);
}
