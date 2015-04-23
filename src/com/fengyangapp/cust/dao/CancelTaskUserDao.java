package com.fengyangapp.cust.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.CustDao;
/**
 * @context 描述：InterFaceName_022--cancel_task_user--用户取消呼叫
 * @author 史旭杰
 * @version 创建时间：2015年4月19日 下午7:06:32
 */
public interface CancelTaskUserDao extends CustDao {

	/**
	 * InterFaceName_022--cancel_task_user--用户取消呼叫
	 * @param objects
	 * @return
	 */
	public JSONObject cancel_task_user(Object[] objects);

}
