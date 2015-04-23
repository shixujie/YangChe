package com.fengyangapp.cust.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.CustDao;
/**
 * @context 描述：InterFaceName_019--submit_comment--用户评价
 * @author 史旭杰
 * @version 创建时间：2015年4月19日 下午5:22:15
 */
public interface SubmitCommentDao extends CustDao{

	/**
	 * InterFaceName_019--submit_comment--用户评价
	 * @param objects
	 * @return
	 */
	public JSONObject submit_comment(Object[] objects);

}
