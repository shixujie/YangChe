package com.fengyangapp.mech.dao;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.MechDao;
/**
 * @context 描述：InterFaceName_029-- get_car_model--包括 车系的ID，车的品牌，车的系列名称，车的图片
 * @author 史旭杰
 * @version 创建时间：2015年4月21日 下午3:35:23
 */
public interface GetCarModelDao extends MechDao{

	/**
	 * InterFaceName_029-- get_car_model--包括 车系的ID，车的品牌，车的系列名称，车的图片
	 * @return
	 */
	public JSONObject get_car_model ();
}
