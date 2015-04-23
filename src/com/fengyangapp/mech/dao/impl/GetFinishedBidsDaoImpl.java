package com.fengyangapp.mech.dao.impl;

import java.util.List;

import javafx.scene.input.DataFormat;

import javax.servlet.http.Cookie;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.entity.BidBaseInfo;
import com.fengyangapp.mech.dao.GetFinishedBidsDao;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

/**
 * @context 描述：InterFaceName_027---get_finished_bids-已完成的订单
 * @author 史旭杰
 * @version 创建时间：2015年4月20日 下午5:02:15
 */
public class GetFinishedBidsDaoImpl extends BaseDaoImpl implements
		GetFinishedBidsDao {

	@Override
	public JSONObject get_finished_bids(Object[] objects) {
		String interfaceName = InterFaceName.InterFaceName_027;
		START(interfaceName);
		try {
			if (judgeObjectSize(objects)) {
				Object o0 = objects[0];// mc_id任务编号
				if (!judgeString(o0)) {
					// mc_id为空
					SOS("mc_id任务编号为空");
				} else {
					list = getList(objects);// 任务的基本信息
					if (judgeListSize(list)) {
						SOS("获取成功");
						json.put(result, 1);
					} else {
						SOS("用户未选择技工");
						json.put(result, 0);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e);// 异常日志
			json.put(result, 0);
		}
		json.put(bidList, list);
		jsonResponse.put(interfaceName.split("/")[1] + response, json);
		System.out.println(jsonResponse);
		END(interfaceName);
		return jsonResponse;
	}

	/**
	 * 
	 * @param objects
	 * @return
	 */
	public List<Object> getList(Object[] objects) {
		try {
			String sql = SQL_MySQL.SQL_027_1;
			Integer mc_id = turnToInteger(objects[0]);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mc_id);// mc_id
			rs = ps.executeQuery();
			while (rs.next()) {
				BidBaseInfo base = new BidBaseInfo();
				base.setUser_id(rs.getInt(1));// user_id
				base.setUser_name(rs.getString(2));
				base.setLatitude(rs.getDouble(3));
				base.setLongitude(rs.getDouble(4));
				base.setBid_id(rs.getInt(5));
				base.setTask_id(rs.getInt(6));
				base.setDate(dateTurnToString(rs.getDate(7)));
				base.setPrice(rs.getDouble(8));
				base.setCar_model(rs.getString(9));
				list.add(base);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

}
