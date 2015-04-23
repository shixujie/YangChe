package com.fengyangapp.cust.dao.imql;

import java.sql.SQLException;

import net.sf.json.JSONObject;

import com.fengyangapp.cust.dao.CallRescueDao;
import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.utils.InterFaceName;

public class CallRescueDaoImpl extends BaseDaoImpl implements CallRescueDao{

	/**
	 * InterFaceName_002----call_rescue
	 * 
	 * @param objects
	 * @return
	 */
	public JSONObject call_rescue(Object[] objects) {
		// TODO
		String interfaceName = InterFaceName.InterFaceName_002;
		START(interfaceName);
		Integer tast_id = 0;
		if (utils.judgeString(objects) && objects.length >0) {
			try {
				Object o0 = objects[0];// user_id
				Object o1 = objects[1];// longitude
				Object o2 = objects[2];// latitude
				Object o3 = objects[3];// mc_id
				Object o6 = objects[4];// rescue_type
				if (!utils.judgeString(o0)) {// 用户ID
					System.out.println("用户名为空");
					json.put(result, 0);
					json.put(task_id, tast_id);
				} else if (!(utils.judgeString(o1) && utils.judgeString(o2))) {// 用户的经纬度
					System.out.println("地址为空");
					json.put(result, 0);
					json.put(task_id,task_id );
					
				} else if (!utils.judgeString(o3)) {// 车ID
					System.out.println("车的型号为空");
					json.put(result, 0);
					json.put(task_id, tast_id);
				} else if (!utils.judgeString(o6)) {// 救援类型
					System.out.println("救援类型为空");
					json.put(result, 0);
					json.put(task_id, tast_id);
				}else {
					//条件成立
					Integer user_id = Integer.parseInt(o0.toString());// 用户
					double longitude = Double.parseDouble(o1.toString());// 用户的经度
					double latitude = Double.parseDouble(o2.toString());// 用户的维度
					Integer car_id = Integer.parseInt(o3.toString());// 车ID
					Integer rescue_type = Integer.parseInt(o6.toString());// 救援类型ID
					System.out.println(user_id + "," + longitude + "," + latitude
							+ "," + car_id + "," + rescue_type);
					list = custJsp.inteface_1_2_001(user_id);// 先查询（是否还有未完成的任务）

					if (list != null && list.size() > 0) {
						System.out.println("还有未完成的任务");
						json.put(result, 0);
						json.put(task_id, Integer.parseInt(list.get(0).toString()));
					} else {
						boolean b = custJsp.inteface_1_2_002(user_id, latitude,
								longitude, car_id);
						
						if (b) {
							System.out.println("添加成功");
							tast_id = inteface_002_1(rescue_type);// 获取rescuetask最新task_id
							json.put(result, 1);
							json.put(task_id, tast_id);
						} else {
							System.out.println("添加失败");
							json.put(result, 0);
							json.put(task_id, tast_id);
						}
					}
				}
			} catch (Exception e) {
				log.info(e);// 异常日志
				e.printStackTrace();
				json.put(result, 0);
				json.put(task_id, tast_id);
			}
		}else {
			SOS("objects 为空");
			json.put(result, 0);
			json.put(task_id, tast_id);
		}
		jsonResponse.put(interfaceName.split("/")[1] + response, json);
		System.out.println(jsonResponse);
		END(interfaceName);
		return jsonResponse;
	}
	
	/**
	 * 获取rescuetask最新task_id
	 * 
	 * @param rescue_type
	 * @return
	 */

	public Integer inteface_002_1(Integer rescue_type) {
		// 添加到用户任务表中
		Integer task_id = 0;
		String sql = "SELECT LAST_INSERT_ID()";
		try {
			 rs = st.executeQuery(sql);
			while (rs.next()) {
				task_id = Integer.parseInt(rs.getObject(1).toString());
				sql = "INSERT INTO rescuetask (id,rescue_type) VALUES  ("
						+ task_id + "," + rescue_type + ")";
				st.executeUpdate(sql);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return task_id;
	}

}
