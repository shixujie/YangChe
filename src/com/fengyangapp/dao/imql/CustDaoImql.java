package com.fengyangapp.dao.imql;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.fengyangapp.dao.BaseDao;
import com.fengyangapp.dao.CustDao;
import com.fengyangapp.utils.BaseUtils;
import com.fengyangapp.utils.InterFaceName;

public class CustDaoImql extends BaseDaoImpl implements CustDao {

	/**
	 * user_id//longitude// latitude//mc_id//task_id//bid_id//rescue_type
	 * ---o0------o1---------- 02 ------03----- 04 ------05-------06
	 */
	Logger log = Logger.getLogger(super.getClass());

	public List<Object> list = new ArrayList<Object>();

	

	
//	/**
//	 * InterFaceName_003----get_refit_merchanics_coors
//	 */
//	public JSONObject get_refit_merchanics_coors(Object[] objects) {
//		// TODO
//		String interfaceName = InterFaceName.InterFaceName_003;
//		START(interfaceName);
//		try {
//			custJsp.inteface_003_show_view();// 先判断view是否存在
//			Object o4 = objects[0];// task_id任务编号
//			if (o4 != null && o4.toString().length() > 0) {// 是否能调节范围---待定
//				Object[] temp = new Object[] { objects[0], range };
//				list = custJsp.interface_003_1(temp);
//				json.put(result, 1);
//				json.put(mechanicList, list);
//			} else {
//				SOS("task_id任务编号为空");
//				json.put(result, 0);
//				json.put(mechanicList, list);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info(e);// 异常日志
//			json.put(result, 0);
//			json.put(mechanicList, list);
//		}
//		jsonResponse.put(interfaceName.split("/")[1] + response, json);
//		System.out.println(jsonResponse);
//		END(interfaceName);
//		return jsonResponse;
//	}

//	/**
//	 * InterFaceName_004----get_rescue_merchanics_coors 获取附近的救援技工位置及姓名
//	 */
//	public JSONObject get_rescue_merchanics_coors(Object[] objects) {
//		// TODO
//		String interfaceName = InterFaceName.InterFaceName_004;
//		START(interfaceName);
//		try {
//			custJsp.inteface_004_show_view();// 先判断view是否存在
//			Object o4 = objects[0];// task_id任务编号
//			if (o4 != null && o4.toString().length() > 0) {// 是否能调节范围---待定
//				Object[] temp = new Object[] { objects[0], range };
//				list = custJsp.interface_004_1(temp);
//				json.put(result, 1);
//				json.put(mechanicList, list);
//			} else {
//				SOS("task_id任务编号为空");
//				json.put(result, 0);
//				json.put(mechanicList, list);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info(e);// 异常日志
//			json.put(result, 0);
//			json.put(mechanicList, list);
//		}
//		jsonResponse.put(interfaceName.split("/")[1] + response, json);
//		System.out.println(jsonResponse);
//		END(interfaceName);
//		return jsonResponse;
//
//	}

//	/**
//	 * InterFaceName_006----is_available_merchanics_refit
//	 * 在用户提交订单后，用户可查看是否有车改技工抢单
//	 */
//	public JSONObject is_available_merchanics_refit(Object[] objects) {
//		// TODO
//		String interfaceName = InterFaceName.InterFaceName_006;
//		START(interfaceName);
//		try {
//			custJsp.interface_006_show_view();// 先判断view是否存在
//			Object o4 = objects[0];// task_id任务编号
//			if (utils.judgeString(o4)) {// 是否能调节范围---待定
//				Object[] temp = new Object[] { o4 };
//				list = custJsp.interface_006_1(temp);
//				json.put(result, 1);
//				json.put(count, list.get(0));
//				json.put(task_id, list.get(1));
//			} else {
//				SOS("task_id任务编号为空");
//				json.put(result, 0);
//				json.put(count, 0);
//				json.put(task_id, 0);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info(e);// 异常日志
//			json.put(result, 0);
//			json.put(count, 0);
//			json.put(task_id, 0);
//		}
//		jsonResponse.put(interfaceName.split("/")[1] + response, json);
//		System.out.println(jsonResponse);
//		END(interfaceName);
//		return jsonResponse;
//
//	}

//	/**
//	 * InterFaceName_007----is_available_merchanics_rescue
//	 * 在用户提交订单后，用户可查看是否有车改技工抢单
//	 */
//	public JSONObject is_available_merchanics_rescue(Object[] objects) {
//		// TODO
//		String interfaceName = InterFaceName.InterFaceName_007;
//		START(interfaceName);
//		try {
//			custJsp.interface_007_show_view();// 先判断view是否存在
//			Object o4 = objects[0];// task_id任务编号
//			if (utils.judgeString(o4)) {// 是否能调节范围---待定
//				Object[] temp = new Object[] { o4 };
//				list = custJsp.interface_007_1(temp);
//				json.put(result, 1);
//				json.put(count, list.get(0));
//				json.put(task_id, list.get(1));
//			} else {
//				SOS("task_id任务编号为空");
//				json.put(result, 0);
//				json.put(count, 0);
//				json.put(task_id, 0);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info(e);// 异常日志
//			json.put(result, 0);
//			json.put(count, 0);
//			json.put(task_id, 0);
//		}
//		jsonResponse.put(interfaceName.split("/")[1] + response, json);
//		System.out.println(jsonResponse);
//		END(interfaceName);
//		return jsonResponse;
//
//	}

//	/**
//	 * InterFaceName_011--用户获取车改技工抢单表--get_refit_bids
//	 */
//	public JSONObject get_refit_bids(Object[] objects) {
//		// TODO
//		String interfaceName = InterFaceName.InterFaceName_011;
//		START(interfaceName);
//		try {
//			Object o4 = objects[0];// task_id任务编号
//			if (utils.judgeString(o4)) {// 是否能调节范围---待定
//				Object[] temp = new Object[] { o4 };
//				list = custJsp.interface_0011_get_refit_bids(temp);
//				json.put(result, 1);
//				json.put(mechanicList, list);
//			} else {
//				SOS("task_id任务编号为空");
//				json.put(result, 0);
//				json.put(mechanicList, list);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info(e);// 异常日志
//			json.put(result, 0);
//			json.put(mechanicList, list);
//		}
//		jsonResponse.put(interfaceName.split("/")[1] + response, json);
//		System.out.println(jsonResponse);
//		END(interfaceName);
//		return jsonResponse;
//
//	}

//	/**
//	 * InterFaceName_012---获取抢单技工的列表---救援get_rescue_bids
//	 */
//	public JSONObject get_rescue_bids(Object[] objects) {
//		// TODO
//		String interfaceName = InterFaceName.InterFaceName_012;
//		START(interfaceName);
//		try {
//			Object o4 = objects[0];// task_id任务编号
//			if (utils.judgeString(o4)) {// 是否能调节范围---待定
//				Object[] temp = new Object[] { o4 };
//				list = custJsp.interface_0012_get_rescue_bids(temp);
//				json.put(result, 1);
//				json.put(mechanicList, list);
//			} else {
//				SOS("task_id任务编号为空");
//				json.put(result, 0);
//				json.put(mechanicList, list);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info(e);// 异常日志
//			json.put(result, 0);
//			json.put(mechanicList, list);
//		}
//		jsonResponse.put(interfaceName.split("/")[1] + response, json);
//		System.out.println(jsonResponse);
//		END(interfaceName);
//		return jsonResponse;
//
//	}

//	/**
//	 * InterFaceName_013-- 获取抢单技工的详细详细--get_bid
//	 */
//	public JSONObject get_bid(Object[] objects) {
//		// TODO
//		String interfaceName = InterFaceName.InterFaceName_013;
//		START(interfaceName);
//		try {
//			Object o0 = objects[0];// bid_id任务编号
//			if (utils.judgeString(o0)) {// 是否能调节范围---待定
//				Object[] temp = new Object[] { o0 };
//				list = custJsp.interface_0013_get_bid(temp);
//				json.put(result, 1);
//				json.put(mechanicList, list);
//			} else {
//				SOS("bid_id编号为空");
//				json.put(result, 0);
//				json.put(mechanicList, list);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info(e);// 异常日志
//			json.put(result, 0);
//			json.put(mechanicList, list);
//		}
//		jsonResponse.put(interfaceName.split("/")[1] + response, json);
//		System.out.println(jsonResponse);
//		END(interfaceName);
//		return jsonResponse;
//
//	}

//	/**
//	 * InterFaceName_014--用户选择技工--choose_bid
//	 */
//	public JSONObject choose_bid(Object[] objects) {
//		// TODO
//		String interfaceName = InterFaceName.InterFaceName_014;
//		START(interfaceName);
//		try {
//			Object o0 = objects[0];// bid_id任务编号
//			Object task_id = custJsp.interface_0014_0_judge_bid(objects);// task_id任务编号
//			Object bid_ids = custJsp.interface_0014_1_judge_bid(new Object[]{task_id});// 搜索技工bid_id
//			Object one_bid_id = custJsp.interface_0014_2_judge_bid(objects) ;//搜索技工bid_id
//			
//			if (!utils.judgeString(o0)){//判断bid_id 是否为空
//				SOS("bid_id编号为空");
//				json.put(result, 0);
//			}else if (utils.judgeString(one_bid_id)) {//one_bid_id  是否为空
//				SOS("已选择该技工");
//				json.put(result, 0);
//			}else if (utils.judgeString(bid_ids)) {//bid_ids  是否为空
//				SOS("已有技工被选中");
//				json.put(result, 0);
//			}else {// 是否能调节范围---待定
//				Object[] o = new Object[] { o0 };
//				custJsp.interface_0014_2_choose_bid(o);
//				SOS("选择成功");
//				json.put(result, 1);
//			} 
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info(e);// 异常日志
//			json.put(result, 0);
//		}
//		jsonResponse.put(interfaceName.split("/")[1] + response, json);
//		System.out.println(jsonResponse);
//		END(interfaceName);
//		return jsonResponse;
//	}

//	/**
//	 * InterFaceName_018--bid_finished_user----用户确认任务是否完成
//	 */
//	public JSONObject bid_finished_user(Object[] objects) {
//		// TODO
//		String interfaceName = InterFaceName.InterFaceName_018;
//		START(interfaceName);
//		try {
//			Object o0 = objects[0];// bid_id任务编号
//			Object o1 = objects[1];// is_finished任务编号
//			if (!utils.judgeString(o0)) {
//				// bid_id为空
//				SOS("bid_id任务编号为空");
//				json.put(result, 0);
//			} else if (!utils.judgeString(o1)) {
//				// is_finished任务编号为空
//				SOS("is_finished任务编号为空");
//				json.put(result, 0);
//			} else if (o1.toString().equals("1")) {// 确认任务完成
//				Object sign = custJsp
//						.interface_018_2_bid_finished_user(objects);
//				if (utils.judgeString(sign) && utils.turnToInteger(sign) == 1) {
//					SOS("操作成功");
//					json.put(result, 1);
//				} else {
//					SOS("操作失败");
//					json.put(result, 0);
//				}
//			}
//			// else {//确认任务未完成
//			// Object sign =
//			// custJsp.interface_018_1_bid_unfinished_user(objects);
//			// if (utils.judgeString(sign)) {
//			// SOS("操作成功");
//			// json.put(result, 1);
//			// }else {
//			// SOS("操作失败");
//			// json.put(result, 0);
//			// }
//			// }
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info(e);// 异常日志
//			json.put(result, 0);
//			json.put(count, 0);
//			json.put(task_id, 0);
//		}
//		jsonResponse.put(interfaceName.split("/")[1] + response, json);
//		System.out.println(jsonResponse);
//		END(interfaceName);
//		return jsonResponse;
//
//	}

//	/**
//	 * InterFaceName_019--submit_comment--用户评价
//	 */
//	public JSONObject submit_comment(Object[] objects) {
//		// TODO
//		String interfaceName = InterFaceName.InterFaceName_019;
//		START(interfaceName);
//		try {
//			Object o0 = objects[0];// bid_id任务编号
//			Object o1 = objects[1];// star
//			Object o2 = objects[2];// 评论内容comment
//			if (!utils.judgeString(o0)) {
//				// bid_id为空
//				SOS("bid_id任务编号为空");
//				json.put(result, 0);
//			} else if (!utils.judgeString(o1)) {
//				// star
//				SOS("star为空");
//				json.put(result, 0);
//			} else if (!utils.judgeString(o2)) {
//				// 评论内容comment为空
//				SOS("评论内容comment为空");
//				json.put(result, 0);
//			} else {
//				Object sign = custJsp.interface_019_1_submit_comment(objects);
//				if (utils.judgeString(sign)) {
//					SOS("操作成功");
//					json.put(result, 1);
//				} else {
//					SOS("操作失败");
//					json.put(result, 0);
//				}
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info(e);// 异常日志
//			json.put(result, 0);
//		}
//		jsonResponse.put(interfaceName.split("/")[1] + response, json);
//		System.out.println(jsonResponse);
//		END(interfaceName);
//		return jsonResponse;
//	}

//	/**
//	 * InterFaceName_020--cancel_bid_user--用户取消发布的任务
//	 */
//	public JSONObject cancel_bid_user(Object[] objects) {
//		// TODO
//		String interfaceName = InterFaceName.InterFaceName_020;
//		START(interfaceName);
//		try {
//			Object o0 = objects[0];// bid_id任务编号
//			if (!utils.judgeString(o0)) {
//				// bid_id为空
//				SOS("bid_id任务编号为空");
//				json.put(result, 0);
//			} else {
//				Object sign = custJsp.interface_020_1_cancel_bid_user(objects);
//				if (utils.judgeString(sign)) {
//					SOS("操作成功");
//					json.put(result, 1);
//				} else {
//					SOS("操作失败");
//					json.put(result, 0);
//				}
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info(e);// 异常日志
//			json.put(result, 0);
//		}
//		jsonResponse.put(interfaceName.split("/")[1] + response, json);
//		System.out.println(jsonResponse);
//		END(interfaceName);
//		return jsonResponse;
//	}

//	/**
//	 * InterFaceName_022--cancel_task_user--用户取消呼叫
//	 */
//	public JSONObject cancel_task_user(Object[] objects) {
//		// TODO
//		String interfaceName = InterFaceName.InterFaceName_022;
//		START(interfaceName);
//		try {
//			Object o0 = objects[0];// task_id任务编号
//			if (!utils.judgeString(o0)) {
//				// task_id为空
//				SOS("task_id任务编号为空");
//				json.put(result, 0);
//			} else {
//				Object sign1 = custJsp
//						.interface_022_1_cancel_task_user(objects);
//				Object sign2 = custJsp
//						.interface_022_2_cancel_task_user(objects);
//				if (utils.judgeString(sign1) && utils.turnToInteger(sign1) >= 1
//						&& utils.judgeString(sign2)
//						&& utils.turnToInteger(sign2) >= 1) {
//					SOS("操作成功");
//					json.put(result, 1);
//				} else {
//					SOS("操作失败");
//					json.put(result, 0);
//				}
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info(e);// 异常日志
//			json.put(result, 0);
//		}
//		jsonResponse.put(interfaceName.split("/")[1] + response, json);
//		System.out.println(jsonResponse);
//		END(interfaceName);
//		return jsonResponse;
//	}

	/**
	 * 进入接口时的初始化操作
	 * 
	 * @param interfaceName
	 */
	public void START(String interfaceName) {
		// TODO
		utils.judgeList(list);
		utils.judgJson(json);
		utils.judgJson(jsonResponse);
		System.out.println(interfaceName + "..start..");
		log.info(interfaceName + "..start..");// 开启log日志
	}

	/**
	 * 退出接口
	 * 
	 * @param interfaceName
	 */
	public void END(String interfaceName) {
		System.out.println("json==" + json);
		System.out.println(interfaceName + "....end....");
		log.info(interfaceName + "....end....");// log日志结束
	}

	public void SOS(String value) {
		System.out.println("message===" + value);
	}

	public static void main(String[] args) {
		System.out.println(utils.judgeString("1111111111111"));
	}

}
