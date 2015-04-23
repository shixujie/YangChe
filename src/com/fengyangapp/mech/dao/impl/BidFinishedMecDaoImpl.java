package com.fengyangapp.mech.dao.impl;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.mech.dao.BidFinishedMecDao;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class BidFinishedMecDaoImpl extends BaseDaoImpl implements
		BidFinishedMecDao {

	@Override
	public JSONObject bid_finished_mec(Object[] objects) {
		String interfaceName = InterFaceName.InterFaceName_017;
		START(interfaceName);
		try {
			if (judgeObjectSize(objects)) {
				Object o0 = objects[0];// bid_id任务编号
				if (utils.judgeString(o0)) {// 是否能调节范围---待定
					Object one_bid_id = interface_017_1_select_bid(objects);// 查询结构
					if (!utils.judgeString(one_bid_id)) {
						// 为空时
						Object sign = interface_017_2_bid_finished_mec(objects);
						if (utils.judgeString(sign)) {
							// 数据更新成功
							SOS("申请成功");
							json.put(result, 1);
						} else {
							SOS("申请失败");
							json.put(result, 0);
						}
					} else {
						SOS("任务已申请，请等待确认");
						json.put(result, 0);
					}
				} else {
					SOS("bid_id任务编号为空");
					json.put(result, 0);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e);// 异常日志
			e.printStackTrace();
			json.put(result, 0);
		}
		jsonResponse.put(interfaceName.split("/")[1] + response, json);
		System.out.println(jsonResponse);
		END(interfaceName);
		return jsonResponse;
	}

	/**
	 * InterFaceName_017_1--interface_017_1_select_bid--查看是否已提交申请
	 * 
	 * @param objects
	 * @return
	 */

	public Object interface_017_1_select_bid(Object[] objects) {
		String sql = SQL_MySQL.SQL_017_1;
		return select(sql, objects);
	}

	/**
	 * interface_017_2_bid_finished_mec---将任务变为 技工申请状态
	 * 
	 * @param objects
	 * @return
	 */
	public Object interface_017_2_bid_finished_mec(Object[] objects) {
		String sql = SQL_MySQL.SQL_017_2;
		return update(sql, objects);
	}

}
