package com.fengyangapp.mech.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.MechDao;
/**
 * @context 描述：nterFaceName_024--update_location---更新技工的位置
 * @author 史旭杰
 * @version 创建时间：2015年4月19日 下午8:51:07
 */
public interface UpdateLocationDao extends MechDao{

	/**
	 * InterFaceName_024--update_location---更新技工的位置
	 * @param objects
	 * @return
	 */
	public JSONObject update_location(Object [] objects);
}
