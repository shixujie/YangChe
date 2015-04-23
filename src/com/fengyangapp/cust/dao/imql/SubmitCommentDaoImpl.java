package com.fengyangapp.cust.dao.imql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.sf.json.JSONObject;

import com.fengyangapp.cust.dao.SubmitCommentDao;
import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;

public class SubmitCommentDaoImpl extends BaseDaoImpl implements
		SubmitCommentDao {

	@Override
	public JSONObject submit_comment(Object[] objects) {
		// TODO
		String interfaceName = InterFaceName.InterFaceName_019;
		START(interfaceName);
		try {
			if (judgeObjectSize(objects)) {
				Object o0 = objects[0];// bid_id任务编号
				Object o1 = objects[1];// star
				Object o2 = objects[2];// 评论内容comment
				if (!utils.judgeString(o0)) {
					// bid_id为空
					SOS("bid_id任务编号为空");
					json.put(result, 0);
				} else if (!utils.judgeString(o1)) {
					// star
					SOS("star为空");
					json.put(result, 0);
				} else if (!utils.judgeString(o2)) {
					// 评论内容comment为空
					SOS("评论内容comment为空");
					json.put(result, 0);
				} else {
					Object sign = interface_019_1_submit_comment(objects);
					if (utils.judgeString(sign)) {
						SOS("操作成功");
						json.put(result, 1);
					} else {
						SOS("操作失败");
						json.put(result, 0);
					}
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
	 * InterFaceName_019--submit_comment--更新用户评价
	 * 
	 * @param temp
	 * @return
	 */
	public Object interface_019_1_submit_comment(Object[] temp) {
		Object object = null;
		String sql = SQL_MySQL.SQL_019_1;
		Integer bid_id = utils.turnToInteger(temp[0]);
		double star = turnToDouble(temp[1]);
		String comment = temp[2].toString();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bid_id);
			ps.setDouble(2, star);
			ps.setString(3, comment);
			object = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
}
