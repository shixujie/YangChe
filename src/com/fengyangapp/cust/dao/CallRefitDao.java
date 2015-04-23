package com.fengyangapp.cust.dao;

import com.fengyangapp.dao.CustDao;

import net.sf.json.JSONObject;

/**
 * @context 描述：InterFaceName_001----call_refit-将改车信息和用户信息发送到服务器
 * @author 史旭杰
 * @version 创建时间：2015年4月18日 上午11:14:36
 */
public interface CallRefitDao extends CustDao{

	/**
	 * InterFaceName_001----call_refit-将改车信息和用户信息发送到服务器
	 * 
	 * @param o0
	 * @param o1
	 * @param o2
	 * @param o3
	 * @return
	 */
	public JSONObject call_refit(Object object);
}
