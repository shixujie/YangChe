package com.fengyangapp.cust.dao.imql;

import java.sql.SQLException;

import net.sf.json.JSONObject;

import com.fengyangapp.cust.dao.GetUserInfoDao;
import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.entity.User;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class GetUserInfoDaoImpl extends BaseDaoImpl implements GetUserInfoDao {

	@Override
	public JSONObject get_user_info(Object[] objects) {
		// TODO Auto-generated method stub
		String interfaceName = InterFaceName.InterFaceName_025;
		START(interfaceName);
		try {
			User user = null;
			if (judgeObjectSize(objects)) {
				if (!judgeString(objects[0])) {// mc_id
					SOS("user_id 为空");
				} else {
					user = getUser(objects);
					if (judgeString(user)) {
						SOS("跟新成功");
						json.put(result, 1);
					} else {
						SOS("跟新失败");
					}
				}
			}else {
				json.put(result, 0);
			}
			json.put(userInfo, user);
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

	public User getUser(Object[] objects) {
		User user = null;
		String sql = SQL_MySQL.SQL_025_1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, turnToInteger(objects[0]));
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUser_id(rs.getInt(1));// id
				user.setUser_name(rs.getString(2));
				user.setPhone(rs.getString(3));
				user.setHome_address(rs.getString(4));
				user.setPhoto(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
