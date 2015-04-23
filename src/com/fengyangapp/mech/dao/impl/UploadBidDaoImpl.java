package com.fengyangapp.mech.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.mech.dao.UploadBidDao;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class UploadBidDaoImpl extends BaseDaoImpl implements UploadBidDao {

	@Override
	public JSONObject upload_bid(Object[] objects) {
		String interfaceName = InterFaceName.InterFaceName_009;
		START(interfaceName);
		try {
			if (judgeObjectSize(objects)) {
				Object o0 = objects[0];// mc_id任务编号
				Object o1 = objects[1];// task_id任务编号
				Object o3 = objects[2];// price
				if (!utils.judgeString(o0)) {
					// mc_id为空
					SOS("mc_id任务编号为空");
					json.put(result, 0);
				} else if (!utils.judgeString(o1)) {
					// task_id为空
					SOS("task_id任务编号为空");
					json.put(result, 0);
				} else if (!utils.judgeString(o3)) {
					// price为空
					SOS("price 为空");
					json.put(result, 0);
				} else if (inteface_009_1_select_bid(objects)) {
					// 任务已抢或任务进行中
					SOS("任务已抢或任务进行中");
					json.put(result, 0);
				} else {
					// upload_bid 跟新数据库
					inteface_009_2_upload_bid(objects);
					SOS("添加成功");
					json.put(result, 1);
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
	 * InterFaceName_009_1 ----select_bid--技工抢单 判断是否已抢单
	 * 
	 * @param objects
	 */
	public boolean inteface_009_1_select_bid(Object[] objects) {
		Integer mc_id = utils.turnToInteger(objects[0]);// mc_id任务编号
		Integer task_id = utils.turnToInteger(objects[1]);// task_id任务编号
		String sql = SQL_MySQL.SQL_009_1;
		boolean b = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mc_id);
			ps.setInt(2, task_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// 有数据是bool=true
				b = utils.judgeString(rs.getObject(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * InterFaceName_009_2 ----upload_bid--技工抢单
	 * 
	 * @param objects
	 */
	public void inteface_009_2_upload_bid(Object[] objects) {
		Integer mc_id = utils.turnToInteger(objects[0]);// mc_id任务编号
		Integer task_id = utils.turnToInteger(objects[1]);// task_id任务编号
		double price = utils.turnToDouble(objects[2]);// price
		String sql = SQL_MySQL.SQL_009_2;
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, price);
			ps.setInt(2, mc_id);
			ps.setInt(3, task_id);
			boolean b = ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
