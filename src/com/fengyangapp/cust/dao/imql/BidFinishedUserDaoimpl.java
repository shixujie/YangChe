package com.fengyangapp.cust.dao.imql;

import net.sf.json.JSONObject;

import com.fengyangapp.cust.dao.BidFinishedUserDao;
import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class BidFinishedUserDaoimpl extends BaseDaoImpl implements
		BidFinishedUserDao {

	@Override
	public JSONObject bid_finished_user(Object[] objects) {
		// TODO
		String interfaceName = InterFaceName.InterFaceName_018;
		START(interfaceName);
		try {
			if (judgeObjectSize(objects)) {
				Object o0 = objects[0];// bid_id任务编号
				Object o1 = objects[1];// is_finished任务编号
				if (!utils.judgeString(o0)) {
					// bid_id为空
					SOS("bid_id任务编号为空");
					json.put(result, 0);
				} else if (!utils.judgeString(o1)) {
					// is_finished任务编号为空
					SOS("is_finished任务编号为空");
					json.put(result, 0);
				} else if (o1.toString().equals("1")) {// 确认任务完成
					Object sign = interface_018_2_bid_finished_user(objects);
					if (utils.judgeString(sign)
							&& utils.turnToInteger(sign) == 1) {
						SOS("确认任务完成---操作成功");
						json.put(result, 1);
					} else {
						SOS("确认任务完成--操作失败");
						json.put(result, 0);
					}
				} else {// 确认任务未完成
					Object sign = interface_018_1_bid_unfinished_user(objects);
					if (utils.judgeString(sign)) {
						SOS("确认任务未完成--操作成功");
						json.put(result, 1);
					} else {
						SOS("确认任务未完成---操作失败");
						json.put(result, 0);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e);// 异常日志
			json.put(result, 0);
			json.put(count, 0);
			json.put(task_id, 0);
		}
		jsonResponse.put(interfaceName.split("/")[1] + response, json);
		System.out.println(jsonResponse);
		END(interfaceName);
		return jsonResponse;
	}

	/**
	 * InterFaceName_018_1--bid_unfinished_user----任务未完成
	 * 
	 * @param temp
	 */
	public Object interface_018_1_bid_unfinished_user(Object[] objects) {
		String sql = SQL_MySQL.SQL_018_1;
		return update(sql, objects);
	}

	/**
	 * InterFaceName_018_2--bid_finished_user----任务完成
	 * 
	 * @param temp
	 */
	public Object interface_018_2_bid_finished_user(Object[] objects) {
		String sql = SQL_MySQL.SQL_018_2;
		return update(sql, objects);
	}
}
