package com.fengyangapp.cust.dao;

import java.util.List;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.CustDao;
import com.fengyangapp.utils.InterFaceName;
/**
 * @context 描述：InterFaceName_004----get_rescue_merchanics_coors 获取附近的救援技工位置及姓名
 * @author 史旭杰
 * @version 创建时间：2015年4月18日 下午1:28:32
 */
public interface GetRescueMerchanicsCoorsDao extends CustDao{

	/**
	 * InterFaceName_004----get_rescue_merchanics_coors 获取附近的救援技工位置及姓名
	 */
	public JSONObject get_rescue_merchanics_coors(Object[] objects) ;
}
