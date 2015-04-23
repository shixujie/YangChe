package com.fengyangapp.cust.dao.imql;

import net.sf.json.JSONObject;

import com.fengyangapp.cust.dao.CancelTaskUserDao;
import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class CancelTaskUserDaoImpl extends BaseDaoImpl implements
		CancelTaskUserDao {

	@Override
	public JSONObject cancel_task_user(Object[] objects) {
		// TODO
		String interfaceName = InterFaceName.InterFaceName_022;
		START(interfaceName);
		try {
			if (judgeObjectSize(objects)) {
				Object o0 = objects[0];// task_id任务编号
				Object sign = null;
				if (!utils.judgeString(o0)) {
					// task_id为空
					SOS("task_id任务编号为空");
					json.put(result, 0);
				} else {
					sign = select_cancel_task(objects);
					if (!judgeString(sign)) {
						Object sign1 = update_task(objects);
						Object sign2 = update_bid(objects);
						if (utils.judgeString(sign1)
								&& utils.turnToInteger(sign1) >= 1
								&& utils.judgeString(sign2)
								&& utils.turnToInteger(sign2) >= 1) {
							SOS("操作成功");
							json.put(result, 1);
						} else {
							SOS("操作失败");
							json.put(result, 0);
						}
					}else {
						SOS("任务 一取消");
						json.put(result, 0);
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
	 * InterFaceName_022_3--cancel_task_user--搜索task
	 */
	public Object select_cancel_task(Object[] objects) {
		String sql = SQL_MySQL.SQL_022_1;
		return select(sql, objects);
	}

	/**
	 * InterFaceName_022_1--cancel_task_user--更新task
	 */
	public Object update_task(Object[] objects) {
		String sql = SQL_MySQL.SQL_022_2;
		return update(sql, objects);
	}

	/**
	 * InterFaceName_022_2--cancel_task_user--更新bid
	 */
	public Object update_bid(Object[] objects) {
		String sql = SQL_MySQL.SQL_022_3;
		return update(sql, objects);
	}

}
