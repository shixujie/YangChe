package com.fengyangapp.cust.dao.imql;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import com.fengyangapp.cust.dao.GetRescueMerchanicsCoorsDao;
import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.entity.InterFace_3_4;
import com.fengyangapp.utils.BaseUtils;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class GetRescueMerchanicsCoorsDaoImpl extends BaseDaoImpl implements
		GetRescueMerchanicsCoorsDao {

	/**
	 * InterFaceName_004----get_rescue_merchanics_coors 获取附近的救援技工位置及姓名
	 */
	public JSONObject get_rescue_merchanics_coors(Object[] objects) {
		// TODO
		String interfaceName = InterFaceName.InterFaceName_004;
		START(interfaceName);
		try {
//			custJsp.inteface_004_show_view();// 先判断view是否存在
			if (utils.judgeObjectSize(objects)) {
				Object o4 = objects[0];// task_id任务编号
				if (o4 != null && o4.toString().length() > 0) {// 是否能调节范围---待定
					Object[] temp = new Object[] { objects[0], range };
					list = interface_004_1(temp);
					json.put(result, 1);
					json.put(mechanicList, list);
				} else {
					SOS("task_id任务编号为空");
					json.put(result, 0);
					json.put(mechanicList, list);
				}
			} else {
				SOS("obejcets 为空");
				json.put(result, 0);
				json.put(mechanicList, list);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e);// 异常日志
			json.put(result, 0);
			json.put(mechanicList, list);
		}
		jsonResponse.put(interfaceName.split("/")[1] + response, json);
		System.out.println(jsonResponse);
		END(interfaceName);
		return jsonResponse;
	}

	
	
	public List<Object> interface_004_1(Object[] objects) {
		Integer task_id = Integer.parseInt(objects[0].toString());// 任务编号
		double range = Double.parseDouble(objects[1].toString());
		double latitude = 0, longitude = 0;
		String sql = "SELECT latitude,longitude FROM task WHERE id = "
				+ task_id;
		try {
			if (utils.judgeList(list)) {
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					latitude = rs.getDouble(1);// 维度
					longitude = rs.getDouble(2);// 经度
				}
				double[] b = BaseUtils.GetDistance(latitude, longitude, range);
				sql = SQL_MySQL.SQL_004_1;
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, task_id);
				ps.setDouble(2, latitude - b[0]);
				ps.setDouble(3, latitude + b[0]);
				ps.setDouble(4, longitude - b[1]);
				ps.setDouble(5, longitude + b[1]);
				rs = ps.executeQuery();
				while (rs.next()) {
					InterFace_3_4 entity = new InterFace_3_4();
					entity.setMc_id(rs.getInt(1));
					entity.setMc_name(rs.getString(2));
					entity.setLatitude(rs.getDouble(3));
					entity.setLongitude(rs.getDouble(4));
					list.add(entity);
				}
				for (Object o : list) {
					InterFace_3_4 en = (InterFace_3_4) o;
					double lat = en.getLatitude();
					double lon = en.getLongitude();
					if (range < BaseUtils.getDistatce(latitude, longitude, lat,
							lon)) {// 判断在圆形范围内是否有技工
						list.remove(en);
					}
				}
				if (list != null && list.size() > 0) {
					//公共接口
					custJsp.insert_into_bid(task_id, list);// 添加到bid中
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
