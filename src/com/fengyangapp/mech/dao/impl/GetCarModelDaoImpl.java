package com.fengyangapp.mech.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.scripts.JS;
import net.sf.json.JSONObject;

import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.mech.dao.GetCarModelDao;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class GetCarModelDaoImpl extends BaseDaoImpl implements GetCarModelDao {

	@Override
	public JSONObject get_car_model() {
		String interfaceName = InterFaceName.InterFaceName_029;
		START(interfaceName);
		try {
			jsonList = getCarModels();
			if (jsonList != null && jsonList.size() > 0) {// 不为空时，添加
				list.addAll(jsonList);
				json.put(result, 1);
			} else {
				json.put(result, 0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e);// 异常日志
			e.printStackTrace();
			json.put(result, 0);
		}
		json.put(carList, list);
		jsonResponse.put(interfaceName.split("/")[1] + response, json);
		System.out.println(jsonResponse);
		END(interfaceName);
		return jsonResponse;
	}

	/**
	 * 获取json值
	 * 
	 * @param objects
	 * @return
	 */
	public List<JSONObject> getCarModels() {
		List<JSONObject> list = new ArrayList<JSONObject>();
		String sql = SQL_MySQL.SQL_029_1;
		List<String> strings = new ArrayList<String>();
		String first = "";
		String get2 = "";
		try {
			rs = st.executeQuery(sql);
			while (rs.next()) {
				get2 = rs.getString(2);
				if (!get2.equals(first)) {
					JSONObject json = new JSONObject();
					if (utils.judgeString(first)) {
						json.put("brand", first);// 品牌
						json.put("model", strings);// 车系名称
						list.add(json);
						strings.clear();// 清空
						first = rs.getString(2);
					} else {
						// 循环时，第一次进入时
						first = rs.getString(2);
					}
				}
				strings.add(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
