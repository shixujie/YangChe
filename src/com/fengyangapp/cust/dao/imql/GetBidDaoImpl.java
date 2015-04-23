package com.fengyangapp.cust.dao.imql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import com.fengyangapp.cust.dao.GetBidDao;
import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.entity.InterFace_013;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class GetBidDaoImpl extends BaseDaoImpl implements GetBidDao{

	/**
	 * InterFaceName_013-- 获取抢单技工的详细详细--get_bid
	 */
	@Override
	public JSONObject get_bid(Object[] objects) {
		// TODO
		String interfaceName = InterFaceName.InterFaceName_013;
		START(interfaceName);
		try {
			if (judgeObjectSize(objects)) {
				Object o0 = objects[0];// bid_id任务编号
				if (utils.judgeString(o0)) {// 是否能调节范围---待定
					Object[] temp = new Object[] { o0 };
					list = interface_0013_get_bid(temp);
					json.put(result, 1);
					json.put(mechanicList, list);
				} else {
					SOS("bid_id编号为空");
					json.put(result, 0);
					json.put(mechanicList, list);
				}
			}else {
				SOS("objects 为空");
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
	
	
	public List<Object> interface_0013_get_bid(Object[] o) {
		if (utils.judgeList(list)) {
			Integer bid_id = utils.turnToInteger(o[0]);
			try {
				String sql = SQL_MySQL.SQL_013_1;
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, bid_id);// task_id
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					// 技工信息（id,name,lat,lon,star,price,bid_id）
					InterFace_013 en = new InterFace_013(rs.getInt(1),
							rs.getString(2),rs.getString(3), rs.getDouble(4), rs.getDouble(5),
							rs.getDouble(5), rs.getDouble(8), bid_id);
					list.add(en);//
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

}
