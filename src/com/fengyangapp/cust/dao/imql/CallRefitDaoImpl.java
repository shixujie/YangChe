package com.fengyangapp.cust.dao.imql;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONObject;

import com.fengyangapp.cust.dao.CallRefitDao;
import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.entity.Task;
import com.fengyangapp.utils.InterFaceName;

/**
 * @context 描述：将改车信息和用户信息发送到服务器
 * @author 史旭杰
 * @version 创建时间：2015年4月18日 上午11:31:04
 */
public class CallRefitDaoImpl extends BaseDaoImpl implements CallRefitDao {

	Task task = null;

	/**
	 * InterFaceName_001----call_refit
	 * 
	 * @param o0
	 * @param o1
	 * @param o2
	 * @param o3
	 * @return
	 */
	public JSONObject call_refit(Object object) {
		// TODO
		String interfaceName = InterFaceName.InterFaceName_001;
		START(interfaceName);
		Integer tast_id = 0;
		if (utils.judgeString(object)) {
			task = (Task) object;
			Object o0 = task.getUser_id();
			Object o1 = task.getLatitude();
			Object o2 = task.getLongitude();
			Object o3 = task.getCar_id();
			try {
				if (!utils.judgeString(o0)) {// 用户ID
					System.out.println("用户名为空");
					json.put(result, 0);
				} else if (!(utils.judgeString(o1) && utils.judgeString(o2))) {// 用户的经纬度
					System.out.println("地址为空");
					json.put(result, 0);
				} else if (!utils.judgeString(o3)) {// 车ID
					System.out.println("车的型号为空");
					json.put(result, 0);
				} else {
					// 符合条件
					Integer user_id = Integer.parseInt(o0.toString());// 用户
					double longitude = Double.parseDouble(o1.toString());// 用户的经度
					double latitude = Double.parseDouble(o2.toString());// 用户的维度
					Integer car_id = Integer.parseInt(o3.toString());// 车ID

					System.out.println(user_id + "," + longitude + ","
							+ latitude + "," + car_id);
					// 公共   先查询（是否还有未完成的任务）
					list = custJsp.inteface_1_2_001(user_id);

					if (list != null && list.size() > 0) {
						System.out.println("还有未完成的任务");
						json.put(result, 0);
						json.put(task_id,
								Integer.parseInt(list.get(0).toString()));
					} else {
						// 没有还有未完成的任务----添加
						boolean b = custJsp.inteface_1_2_002(user_id, latitude,
								longitude, car_id);
						
						if (b) {
							System.out.println("添加成功");
							tast_id = inteface_001_1();// 获取refittask最新task_id
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
				json.put(result, 0);
				json.put(task_id, tast_id);
			}
		}else {
			SOS("object为空");
			json.put(result, 0);
			json.put(task_id, tast_id);
		}
		jsonResponse.put(interfaceName.split("/")[1] + response, json);
		System.out.println(json);
		END(InterFaceName.InterFaceName_001);
		return jsonResponse;
	}
	
	
	
	
	/**
	 * 获取refittask最新task_id
	 * 
	 * @return
	 */
	public Integer inteface_001_1() {
		// 添加到用户任务表中
		Integer task_id = 0;
		Integer sign = 0;
		String sql = "SELECT LAST_INSERT_ID()";
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				task_id = Integer.parseInt(rs.getObject(1).toString());
				sql = "INSERT INTO refittask (id) VALUES  (" + task_id + ")";
				sign = st.executeUpdate(sql);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sign == 1) {
			return task_id;
		}else {
			return 0;
		}
	}
}
