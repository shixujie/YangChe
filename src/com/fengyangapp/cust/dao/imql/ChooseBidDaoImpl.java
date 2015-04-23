package com.fengyangapp.cust.dao.imql;

import net.sf.json.JSONObject;

import com.fengyangapp.cust.dao.ChooseBidDao;
import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class ChooseBidDaoImpl extends BaseDaoImpl implements ChooseBidDao {

	/**
	 * InterFaceName_014--用户选择技工--choose_bid
	 */
	@Override
	public JSONObject choose_bid(Object[] objects) {
		// TODO
		String interfaceName = InterFaceName.InterFaceName_014;
		START(interfaceName);
		try {
			if (judgeObjectSize(objects)) {
				Object o0 = objects[0];// bid_id任务编号
				Object task_id = null;
				Object bid_ids = null;
				Object one_bid_id = null;
				if (!utils.judgeString(o0)) {// 判断bid_id 是否为空
					SOS("bid_id编号为空");
					json.put(result, 0);
				} else {
					task_id = select_task_id(objects);// task_id任务编号
					bid_ids = select_bid_ids(new Object[] { task_id });// 搜索技工bid_ids
					one_bid_id = select_bid_id(objects);// 搜索技工bid_id

					if (utils.judgeString(one_bid_id)) {// one_bid_id 是否为空
						SOS("已选择该技工");
						json.put(result, 0);
					} else if (utils.judgeString(bid_ids)) {// bid_ids 是否为空
						SOS("已有技工被选中");
						json.put(result, 0);
					} else {// 是否能调节范围---待定
						Object[] o = new Object[] { o0 };
						update_choose_bid(o);
						SOS("选择成功");
						json.put(result, 1);
					}
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
	 * 跟新技工的状态
	 * 
	 * @param objects
	 * @return
	 */
	public Object update_choose_bid(Object[] objects) {
		String sql = SQL_MySQL.SQL_014_3;
		return update(sql, objects);
	}

	/**
	 * 由bid_id求task_id
	 */
	public Object select_task_id(Object[] objects) {
		String sql = SQL_MySQL.SQL_014_0;
		// 调用公共接口
		return select(sql, objects);
	}

	/**
	 * 由task_id求 bid_ids 判断是否已经选择技工
	 */
	public Object select_bid_ids(Object[] objects) {
		String sql = SQL_MySQL.SQL_014_1;
		// 调用公共接口
		return select(sql, objects);
	}

	/**
	 * bid_id 判断技工是否已被选则
	 */
	public Object select_bid_id(Object[] objects) {
		String sql = SQL_MySQL.SQL_014_2;
		return select(sql, objects);
	}
}
