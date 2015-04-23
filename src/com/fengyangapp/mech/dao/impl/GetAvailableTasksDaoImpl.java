package com.fengyangapp.mech.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import sun.net.www.content.audio.basic;
import net.sf.json.JSONObject;

import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.dao.imql.MechDaoImql;
import com.fengyangapp.mech.dao.GetAvailableTasksDao;
import com.fengyangapp.utils.BaseUtils;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class GetAvailableTasksDaoImpl extends BaseDaoImpl implements GetAvailableTasksDao{

	@Override
	public JSONObject get_available_tasks(Object[] objects) {
		String interfaceName = InterFaceName.InterFaceName_005;
		START(interfaceName);
		try {
//			inteface_005_1_show_view();// 先判断view是否存在
//			inteface_005_2_show_view();// 先判断view是否存在
			if (judgeObjectSize(objects)) {//判断objects是否为空
				Object o3 = objects[0];// mc_id任务编号
				if (utils.judgeString(o3)) {// 是否能调节范围---待定
					JSONObject jsonObject = new JSONObject();
					Object[] temp = new Object[] { objects[0], range };
					json.put(result, 1);
					jsonObject.put(refit_task, interface_005_1(temp));// refitList
					jsonObject.put(rescue_task, interface_005_2(temp));// rescueList
					json.put(userList, jsonObject);
				} else {
					SOS("merchanic_id任务编号为空");
					json.put(result, 0);
					json.put(userList, list);
				}
			}else {
				json.put(userList, list);
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
	 * 005_1-get_available_refittasks-获取可抢的任务单
	 * 
	 * @param temp
	 * @return
	 */
	public List<Object> interface_005_1(Object[] temp) {
		try {
			Integer mc_id = utils.turnToInteger(temp[0]);// 技工ID
			double range = utils.turnToDouble(temp[1]);// 范围
			String sql = "SELECT latitude,longitude FROM mechanic WHERE id = "
					+ mc_id + ";";
			double[] location = get_Lon_Lat(sql);
			double latitude = location[0];// 技工维度
			double longitude = location[1];// 技工经度
			double[] locationError = BaseUtils.GetDistance(latitude, longitude,
					range);// 坐标矩阵
			sql = SQL_MySQL.SQL_005_1;
			//公共接口
			list = mechJsp.getList(sql, mc_id, location, locationError, range);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 005_1-get_available_rescuetasks-获取可抢的任务单
	 * 
	 * @param temp
	 * @return
	 */
	public List<Object> interface_005_2(Object[] temp) {
		try {
			Integer mc_id = utils.turnToInteger(temp[0]);// 技工ID
			double range = utils.turnToDouble(temp[1]);// 范围
			String sql = "SELECT latitude,longitude FROM mechanic WHERE id = "
					+ mc_id + ";";
			double[] location = get_Lon_Lat(sql);
			System.out.println(location[0] + "-----" + location[1]);

			double latitude = location[0];// 技工维度
			double longitude = location[1];// 技工经度
			double[] locationError = BaseUtils.GetDistance(latitude, longitude,
					range);// 坐标矩阵
			sql = SQL_MySQL.SQL_005_2;
			//公共
			list = mechJsp.getList(sql, mc_id, location, locationError, range);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 获取坐标的
	 * 
	 * @param sql
	 * @param range
	 * @return
	 */
	public  double[] get_Lon_Lat(String sql) {
		double [] d=new double[]{0,0};
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				d[0] = rs.getDouble(1);// 维度
				System.out.println("d[0]=="+d[0]);
				d[1] = rs.getDouble(2);// 经度
				System.out.println("d[1]=="+d[1]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

}
