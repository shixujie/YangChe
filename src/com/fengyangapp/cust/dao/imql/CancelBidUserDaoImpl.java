package com.fengyangapp.cust.dao.imql;

import net.sf.json.JSONObject;

import com.fengyangapp.cust.dao.CancelBidUserDao;
import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class CancelBidUserDaoImpl extends BaseDaoImpl implements
		CancelBidUserDao {
	Object sign = null;

	@Override
	public JSONObject cancel_bid_user(Object[] objects) {
		// TODO
		String interfaceName = InterFaceName.InterFaceName_020;
		START(interfaceName);
		try {
			if (judgeObjectSize(objects)) {
				Object o0 = objects[0];// bid_id任务编号
				if (!utils.judgeString(o0)) {
					// bid_id为空
					SOS("bid_id任务编号为空");
					json.put(result, 0);
				} else {
					sign = interface_020_1_cancel_bid_user(objects);
					if (utils.judgeString(sign)) {
						SOS("任务已取消");
						json.put(result, 0);
					}else {
						sign = interface_020_2_cancel_bid_user(objects);
						if (utils.judgeString(sign)) {
							SOS("操作成功");
							json.put(result, 1);
						} else {
							SOS("操作失败");
							json.put(result, 0);
						}
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
	 * 查询是否已取消
	 * 
	 * @param objects
	 * @return
	 */
	public Object interface_020_1_cancel_bid_user(Object[] objects) {
		String sql = SQL_MySQL.SQL_020_1;
		return select(sql, objects);
	}

	/**
	 * InterFaceName_020--cancel_bid_user--用户取消发布的任务
	 * 
	 * @param objects
	 * @return
	 */
	public Object interface_020_2_cancel_bid_user(Object[] objects) {
		String sql = SQL_MySQL.SQL_020_2;
		return update(sql, objects);
	}

}
