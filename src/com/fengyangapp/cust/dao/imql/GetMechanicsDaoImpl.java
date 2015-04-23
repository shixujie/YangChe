package com.fengyangapp.cust.dao.imql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import com.fengyangapp.cust.dao.GetMechanicsDao;
import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.entity.InterFace_3_4;
import com.fengyangapp.utils.BaseUtils;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;
/**
 * 获取附近技工的信息(初始打开软件时)
 * @author 史旭杰
 * 2015-4-18 10:30:31
 *
 */
public class GetMechanicsDaoImpl extends BaseDaoImpl implements GetMechanicsDao {

	@Override
	public JSONObject get_mechanics(Object[] object) {
		String interfaceName = InterFaceName.InterFaceName_023;
		START(interfaceName);
		try {
			if (utils.judgeList(list)&&object.length >0) {
				if (!utils.judgeString(object[0])) {
					SOS("lat为空");
					json.put(result, 0);
					json.put(mechanicList, list);
				} else if (!utils.judgeString(object[1])) {
					SOS("lon为空");
					json.put(result, 0);
					json.put(mechanicList, list);
				} else {
					// 用户经纬度
					double lat = utils.turnToDouble(object[0]);
					double lon = utils.turnToDouble(object[1]);
					double[] loc = new double[] { lat, lon };
					// 坐标矩阵范围
					double[] locErr = utils.GetDistance(lat, lon, range);
					JSONObject jsonObject = new JSONObject();
					jsonObject.put(refitList,
							get_refit_mechanics(loc, locErr, range));
					jsonObject.put(rescueList,
							get_rescue_mechanics(loc, locErr, range));
					SOS("成功");
					json.put(result, 1);
					json.put(mechanicList, jsonObject);
				}
			}else {
				SOS("位置为空");
				json.put(result, 0);
				json.put(mechanicList, list);
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e);
			json.put(result, 0);
			json.put(mechanicList, list);
		}
		jsonResponse.put(interfaceName.split("/")[1] + response, json);
		System.out.println(jsonResponse);
		 END(interfaceName);
		return jsonResponse;
	}

	/**
	 * 根据坐标查找技工位置
	 * 
	 * @param sql
	 * @param loc
	 * @param locErr
	 * @param range
	 * @return
	 */
	public List<Object> getList(String sql, double[] loc, double[] locErr,
			double range) {

		if (utils.judgeList(list)) {
			try {
				ps = conn.prepareStatement(sql);
				ps.setDouble(1, loc[0] - locErr[0]);
				ps.setDouble(2, loc[0] + locErr[0]);
				ps.setDouble(3, loc[1] - locErr[1]);
				ps.setDouble(4, loc[1] + locErr[1]);
				ResultSet rs = ps.executeQuery();
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
					if (range < BaseUtils.getDistatce(loc[0], loc[1], lat, lon)) {// 判断在圆形范围内是否有技工
						list.remove(en);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Object> get_refit_mechanics(double[] loc, double[] locErr,
			double range) {
		// TODO Auto-generated method stub
		String sql = SQL_MySQL.SQL_023_1;
		return getList(sql, loc, locErr, range);

	}

	@Override
	public List<Object> get_rescue_mechanics(double[] loc, double[] locErr,
			double range) {
		// TODO Auto-generated method stub
		String sql = SQL_MySQL.SQL_023_2;
		return getList(sql, loc, locErr, range);
	}
}
