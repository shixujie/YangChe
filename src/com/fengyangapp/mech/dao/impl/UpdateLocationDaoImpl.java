package com.fengyangapp.mech.dao.impl;

import java.sql.SQLException;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.mech.dao.UpdateLocationDao;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class UpdateLocationDaoImpl extends BaseDaoImpl implements
		UpdateLocationDao {

	@Override
	public JSONObject update_location(Object[] objects) {
		// TODO Auto-generated method stub
		String interfaceName = InterFaceName.InterFaceName_024;
		START(interfaceName);
		try {
			if (judgeObjectSize(objects)) {
				if (!judgeString(objects[0])) {// mc_id
					SOS("mc_id 为空");
				} else if (!judgeString(objects[1])) {// lat
					SOS("latitude 为空");
				} else if (!judgeString(objects[2])) {// loni
					SOS("loni 为空");
				}else {
					sign = InterFaceName_024_update_location(objects);
					if (judgeString(sign)) {
						SOS("跟新成功");
						json.put(result, 1);
					}else {
						SOS("跟新失败");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e);// 异常日志
			json.put(result, 0);
		}
		jsonResponse.put(interfaceName.split("/")[1] + response, json);
		System.out.println(jsonResponse);
		END(interfaceName);
		return jsonResponse;
	}
	
	public Object InterFaceName_024_update_location(Object[] objects){
		String sql = SQL_MySQL.SQL_024_1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, turnToInteger(objects[0]));
			ps.setDouble(2, turnToDouble(objects[1]));
			ps.setDouble(3, turnToDouble(objects[2]));
			sign = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sign;
	}

}
