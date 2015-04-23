package com.fengyangapp.cust.dao.imql;

import java.util.List;

import net.sf.json.JSONObject;

import com.fengyangapp.cust.dao.IsAvailableMerchanicsRescueDao;
import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class IsAvailableMerchanicsRescueDaoImpl extends BaseDaoImpl implements
		IsAvailableMerchanicsRescueDao {

	@Override
	public JSONObject is_available_merchanics_rescue(Object[] objects) {
		// TODO
		String interfaceName = InterFaceName.InterFaceName_007;
		START(interfaceName);
		try {
//			interface_007_show_view();// 先判断view是否存在
			if (judgeObjectSize(objects)) {
				Object o4 = objects[0];// task_id任务编号
				if (utils.judgeString(o4)) {// 是否能调节范围---待定
					Object[] temp = new Object[] { o4 };
					list = interface_007_1(temp);
					json.put(result, 1);
					json.put(count, list.get(0));
					json.put(task_id, list.get(1));
				} else {
					SOS("task_id任务编号为空");
					json.put(result, 0);
					json.put(count, 0);
					json.put(task_id, 0);
				}
			} else {
				json.put(count, 0);
				json.put(task_id, 0);
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

	public List<Object> interface_007_1(Object[] objects) {
		if (utils.judgeList(list)) {
			// Integer task_id = utils.turnToInteger(o[0]);
			String sql = SQL_MySQL.SQL_007_1;
			Integer task_id = utils.turnToInteger(objects[0]);
			//公共
			Integer count = utils.turnToInteger(custJsp.select(sql, objects));
			list.add(count);// 抢单的数量
			list.add(task_id);// 任务编号
			// try {
			// PreparedStatement ps = conn.prepareStatement(sql);
			// ps.setInt(1, task_id);// task_id
			// ResultSet rs = ps.executeQuery();
			// while (rs.next()) {
			// list.add(rs.getInt(1));// 抢单的数量
			// list.add(task_id);// 任务编号
			// }
			// } catch (SQLException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}
		return list;
	}
}
