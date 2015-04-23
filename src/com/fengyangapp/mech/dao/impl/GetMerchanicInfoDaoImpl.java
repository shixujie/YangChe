package com.fengyangapp.mech.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.entity.MechModel;
import com.fengyangapp.mech.dao.GetMerchanicInfoDao;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class GetMerchanicInfoDaoImpl extends BaseDaoImpl implements
		GetMerchanicInfoDao {

	@Override
	public JSONObject get_merchanic_info(Object[] objects) {
		String interfaceName = InterFaceName.InterFaceName_028;
		START(interfaceName);
		List<Object> mechList = null;
		try {
			if (judgeObjectSize(objects)) {
				Object o0 = objects[0];// mc_id任务编号
				if (!judgeString(o0)) {
					// mc_id 为空
					SOS("mc_id 任务编号为空");
				} else {
					mechList = getRefitMech(objects);
					
					if (mechList!=null &&mechList.size() >0) {
						MechModel refitMech = (MechModel) mechList.get(0);
						if (judgeString(refitMech)) {// 车改
							SOS("车改技工");
							json.put(result, 1);
							mechList = getRescueMech(objects);
							if (mechList!=null &&mechList.size() >0) {
								MechModel rescueMech = (MechModel) mechList.get(0);
								if (judgeString(rescueMech)) {// 救援
									SOS("即是救援有是车改技工");
									refitMech.setMc_type("即是救援有是车改技工");
									list = getRescue_type(objects);
									String type = "";
									Integer size = list.size();
									for (int i = 0; i < size; i++) {
										if (i == (size - 1)) {
											type += list.get(i).toString();
										} else {
											type += list.get(i).toString() + ",";
										}
									}
									refitMech.setRescue_type(type);
								}
							}
							list.clear();
							list.add(refitMech);
					}
					} else {
						MechModel rescueMech = (MechModel) getRescueMech(objects).get(0);
						if (judgeString(rescueMech)) {// 救援
							SOS("救援技工");
							list = getRescue_type(objects);
							String type = "";
							Integer size = list.size();
							for (int i = 0; i < size; i++) {
								if (i == (size - 1)) {
									type += list.get(i).toString();
								} else {
									type += list.get(i).toString() + ",";
								}
							}
							rescueMech.setRescue_type(type);
							list.clear();
							list.add(rescueMech);
						}
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			log.info(e);// 异常日志
			e.printStackTrace();
			json.put(result, 0);
		}
		json.put(mechInfo, list);
		jsonResponse.put(interfaceName.split("/")[1] + response, json);
		System.out.println(jsonResponse);
		END(interfaceName);
		return jsonResponse;
	}

	/**
	 * 车改技工基本信息
	 * 
	 * @param objects
	 * @return
	 */
	public List<Object> getRefitMech(Object[] objects) {
		String sql = SQL_MySQL.SQL_028_1;
		List<Object> list = new ArrayList<Object>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, turnToInteger(objects[0]));
			rs = ps.executeQuery();
			while (rs.next()) {
				MechModel mech = new MechModel();
				mech = new MechModel();
				mech.setMc_id(rs.getInt(1));
				mech.setMc_name(rs.getString(2));
				mech.setPhone_num(rs.getString(3));
				mech.setPic_url(rs.getString(4));
				mech.setMc_type("车改技工");
				list.add(mech);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 救援技工基本信息
	 * 
	 * @param objects
	 * @return
	 */
	public List<Object> getRescueMech(Object[] objects) {
		String sql = SQL_MySQL.SQL_028_2;
		List<Object> list = new ArrayList<Object>();
		Integer mc_id = turnToInteger(objects[0]);
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mc_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				MechModel mech = new MechModel();
				mech = new MechModel();
				mech.setMc_id(mc_id);
				mech.setMc_name(rs.getString(2));
				mech.setPhone_num(rs.getString(3));
				mech.setPic_url(rs.getString(4));
				mech.setMc_type("救援技工");
				list.add(mech);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 救援技工的救援类型
	 * 
	 * @return
	 */
	public List<Object> getRescue_type(Object[] objects) {
		List<Object> list = new ArrayList<Object>() {
		};
		String sql = SQL_MySQL.SQL_028_3;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, turnToInteger(objects[0]));
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
