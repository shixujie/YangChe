package com.fengyangapp.cust.dao.imql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import com.fengyangapp.cust.dao.GetRefitMerchanicsCoorsDao;
import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.entity.InterFace_3_4;
import com.fengyangapp.utils.BaseUtils;
import com.fengyangapp.utils.InterFaceName;

public class GetRefitMerchanicsCoorsDaoImpl extends BaseDaoImpl implements
		GetRefitMerchanicsCoorsDao {

	/**
	 * InterFaceName_003----get_refit_merchanics_coors
	 */
	public JSONObject get_refit_merchanics_coors(Object[] objects) {
		// TODO
		String interfaceName = InterFaceName.InterFaceName_003;
		START(interfaceName);
		try {
			// custJsp.inteface_003_show_view();// 先判断view是否存在
			if (utils.judgeObjectSize(objects)) {
				Object o4 = objects[0];// task_id任务编号
				if (o4 != null && o4.toString().length() > 0) {// 是否能调节范围---待定
					Object[] temp = new Object[] { objects[0], range };
					list = interface_003_1(temp);
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

	/**
	 * 003获取附近车改技工位置
	 * 
	 * @param objects
	 * @return
	 */
	public List<Object> interface_003_1(Object[] objects) {
		String interfaceName = InterFaceName.InterFaceName_003;
		START(interfaceName);
		Integer task_id = Integer.parseInt(objects[0].toString());// 任务编号
		double range = Double.parseDouble(objects[1].toString());
		double latitude = 0, longitude = 0;
		String sql = "SELECT latitude,longitude FROM task WHERE id = "
				+ task_id;
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				latitude = rs.getDouble(1);// 维度
				longitude = rs.getDouble(2);// 经度
			}
			double[] b = BaseUtils.GetDistance(latitude, longitude, range);
			sql = "SELECT" + " vrfm.id," + "	vrfm.`name`," + " vrfm.latitude,"
					+ "	vrfm.longitude" + " FROM" + "	view_refitmechanic vrfm"
					+ " JOIN refitmechanic_vs_car rfc ON vrfm.id = rfc.mc_id "
					+ " JOIN task t ON t.car_id = rfc.car_id" + " AND t.id = ?"
					+ " AND vrfm.latitude > ?" + " AND vrfm.latitude < ?"
					+ " AND vrfm.longitude > ?" + " AND vrfm.longitude < ?"
					+ " GROUP BY mc_id";
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
				if (range < BaseUtils
						.getDistatce(latitude, longitude, lat, lon)) {// 判断在圆形范围内是否有技工
					list.remove(en);
				}
			}
			//公共接口
			custJsp.insert_into_bid(task_id, list);// 添加到bid中

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

//	/**
//	 * 003--004---公用
//	 * 
//	 * @param task_id
//	 * @param list
//	 */
//	public void insert_into_bid(Integer task_id, List<Object> list) {
//		try {
//			for (Object object : list) {
//				InterFace_3_4 en = (InterFace_3_4) object;
//				String sql = new String(
//						"INSERT INTO bid (task_id,date,mc_id,price,status) VALUES("
//								+ task_id + ",NOW()," + en.getMc_id() + ",0,0)");
//				st.addBatch(sql);
//			}
//			st.executeBatch();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}

	

}
