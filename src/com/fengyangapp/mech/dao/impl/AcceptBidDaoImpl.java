package com.fengyangapp.mech.dao.impl;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.mech.dao.AcceptBidDao;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class AcceptBidDaoImpl extends BaseDaoImpl implements AcceptBidDao {

	/**
	 * InterFaceName_016 ----accept_bid--技工是否确定为用户服务
	 */
	@Override
	public JSONObject accept_bid(Object[] objects) {
		String interfaceName = InterFaceName.InterFaceName_016;
		START(interfaceName);
		try {
			if (judgeObjectSize(objects)) {
				Object o0 = objects[0];// bid_id
				Object o1 = objects[1];// is_accept
				if (!utils.judgeString(o0)) {
					// bid_id为空
					SOS("bid_id为空");
					json.put(result, 0);
				} else if (!utils.judgeString(o1)) {
					// is_accept为空
					SOS("is_accept为空");
					json.put(result, 0);
				} else {
					String is_accept = utils.turnToString(o1);
					if (is_accept.equals("1")) {
						// 确认服务
						Integer sign = inteface_016_1_accept_bid(objects);
						if (sign == 1) {
							SOS("确认服务");
							json.put(result, 1);
						} else {
							SOS("操作失败");
							json.put(result, 0);
						}
					} else {
						// 取消服务
						
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e);// 异常日志
			json.put(result, 0);
			json.put(userList, list);
		}
		jsonResponse.put(interfaceName.split("/")[1] + response, json);
		System.out.println(jsonResponse);
		END(interfaceName);
		return jsonResponse;
	}

	/**
	 * 更新bid 状态
	 * 
	 * @param objects
	 * @return
	 */
	public Integer inteface_016_1_accept_bid(Object[] objects) {
		String sql = SQL_MySQL.SQL_016_1;
		return (Integer) update(sql, objects);
		// Integer sign = 0;
		// try {
		// Integer bid_id = utils.turnToInteger(objects[0]);// 抢单编号
		// if (utils.judgeList(list)) {
		// ps = conn.prepareStatement(sql);
		// ps.setInt(1, bid_id);
		// sign = ps.executeUpdate();
		// }
		// } catch (Exception e) {
		// // TODO: handle exception
		// e
		// }
		// return sign;
	}

}
