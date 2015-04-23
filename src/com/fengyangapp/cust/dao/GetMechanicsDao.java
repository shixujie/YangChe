package com.fengyangapp.cust.dao;

import java.util.List;

import com.fengyangapp.dao.CustDao;

import net.sf.json.JSONObject;

/**
 * InterFaceName_023--get_mechanics--打开软件时，默认加载附近的技工（包括车改和救援）
 * 
 * @author 史旭杰 2015-4-18 10:04:50
 *
 */
public interface GetMechanicsDao extends CustDao {

	/**
	 * InterFaceName_023--get_mechanics--打开软件时，默认加载附近的技工（包括车改和救援）
	 * 
	 * @param object
	 * @return
	 */
	public JSONObject get_mechanics(Object[] object);

	/**
	 * 获取车改
	 * 
	 * @param loc
	 * @param locErr
	 * @param range
	 * @return
	 */
	public List<Object> get_refit_mechanics(double[] loc, double[] locErr,
			double range);

	/**
	 * 获取救援
	 * 
	 * @param loc
	 * @param locErr
	 * @param range
	 * @return
	 */
	public List<Object> get_rescue_mechanics(double[] loc, double[] locErr,
			double range);
}
