package com.fengyangapp.mech.dao.impl;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.mech.dao.CancelBidMechDao;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class CancelBidMechDaoImpl extends BaseDaoImpl implements CancelBidMechDao {

	
	@Override
	public JSONObject cancel_bid_mec(Object[] objects) {
		String interfaceName = InterFaceName.InterFaceName_021;
		START(interfaceName);
		try {
			if (judgeObjectSize(objects)) {
				Object o0 = objects[0];// bid_id任务编号
				Object sign =null;
				if (!utils.judgeString(o0)) {
					// bid_id为空
					SOS("bid_id任务编号为空");
					json.put(result, 0);
				} else{
					sign = select_cancel_bid_mec(objects);
					if (utils.judgeString(sign)) {
						SOS("任务一取消");
						json.put(result, 1);
					}else {
						sign = update_cancel_bid_mec(objects);
						if (utils.judgeString(sign)) {
							SOS("添加操作成功");
							json.put(result, 1);
						}else {
							SOS("添加操作失败");
							json.put(result, 0);
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e);// 异常日志
			json.put(result, 0);
		}
		jsonResponse.put(interfaceName.split("/")[1] + response, json);
		System.out.println(jsonResponse);
		END(interfaceName);
		return jsonResponse;
	}
	
	
	/**
	 * InterFaceName_021--cancel_bid_mec--技工取消发布的任务 
	 * 查询
	 * @param objects
	 * @return
	 */
	public Object select_cancel_bid_mec(Object[] objects) {
		String sql = SQL_MySQL.SQL_021_1;
		return select(sql, objects);
	}
	/**
	 * update
	 * 
	 * @param objects
	 * @return
	 */
	public Object update_cancel_bid_mec(Object[] objects) {
		String sql = SQL_MySQL.SQL_021_2;
		return update(sql, objects);
	}
}
