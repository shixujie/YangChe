package com.fengyangapp.cust.dao.imql;

import java.util.List;

import net.sf.json.JSONObject;

import com.fengyangapp.cust.dao.GetRescueBidsDao;
import com.fengyangapp.dao.imql.BaseDaoImpl;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;


public class GetRescueBidsDaoImpl extends BaseDaoImpl implements GetRescueBidsDao{

	/**
	 * InterFaceName_012---获取抢单技工的列表---救援get_rescue_bids
	 */
	@Override
	public JSONObject get_rescue_bids(Object[] objects) {
		// TODO
		String interfaceName = InterFaceName.InterFaceName_012;
		START(interfaceName);
		try {
			if (judgeObjectSize(objects)) {
				Object o4 = objects[0];// task_id任务编号
				if (utils.judgeString(o4)) {// 是否能调节范围---待定
					Object[] temp = new Object[] { o4 };
					list = interface_0012_get_rescue_bids(temp);
					json.put(result, 1);
					json.put(mechanicList, list);
				} else {
					SOS("task_id任务编号为空");
					json.put(result, 0);
					json.put(mechanicList, list);
				}
			}else {
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
	
	
	public List<Object> interface_0012_get_rescue_bids(Object[] o) {
		String sql = SQL_MySQL.SQL_012_1;
		// 公共
		return custJsp.interface_0011_012_get_mechanic_bids(o, sql);
	}
}
