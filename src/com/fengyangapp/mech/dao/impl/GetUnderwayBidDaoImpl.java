package com.fengyangapp.mech.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.entity.InterFace_5;
import com.fengyangapp.mech.dao.GetUnderwayBidDao;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class GetUnderwayBidDaoImpl extends BaseDaoImpl implements
		GetUnderwayBidDao {

	@Override
	public JSONObject get_underway_bid(Object[] objects) {
		String interfaceName = InterFaceName.InterFaceName_026;
		START(interfaceName);
		try {
			if (judgeObjectSize(objects)) {
				Object o0 = objects[0];// mc_id任务编号
				if (!judgeString(o0)) {
					// mc_id 为空
					SOS("bid_id 任务编号为空");
					// json.put(userList, list);
				} else {
					list = inteface_027_1_get_underway_bid(objects);
					if (judgeListSize(list)) {
						SOS("获取成功");
						json.put(result, 1);
						// json.put(userList, list);
					} else {
						SOS("用户未选择技工");
						// json.put(userList, list);
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			log.info(e);// 异常日志
			json.put(result, 0);
		}
		json.put(userList, list);
		jsonResponse.put(interfaceName.split("/")[1] + response, json);
		System.out.println(jsonResponse);
		END(interfaceName);
		return jsonResponse;
	}

	/**
	 * 
	 * @param objects
	 * @return
	 */
	public List<Object> inteface_027_1_get_underway_bid(Object[] objects) {
		try {
			Integer mc_id = utils.turnToInteger(objects[0]);
			if (utils.judgeList(list)) {
				String sql = SQL_MySQL.SQL_026_1;
				ps = conn.prepareStatement(sql);
				ps.setInt(1, mc_id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					// 用户信息（id,name,lat,lon）.车型
					InterFace_5 pojo = new InterFace_5(rs.getInt(1),
							rs.getString(2), rs.getDouble(3), rs.getDouble(4),
							rs.getString(6));
					pojo.setBid_id(rs.getInt(5));
					pojo.setPhone(rs.getString(7));
					pojo.setTask_id(8);
					list.add(pojo);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
