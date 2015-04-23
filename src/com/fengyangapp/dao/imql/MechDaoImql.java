package com.fengyangapp.dao.imql;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.fengyangapp.dao.BaseDao;
import com.fengyangapp.dao.MechDao;
import com.fengyangapp.utils.BaseUtils;
import com.fengyangapp.utils.InterFaceName;

public class MechDaoImql implements BaseDao {

	/**
	 * user_id//longitude// latitude//mc_id//task_id//bid_id//rescue_type
	 * ---o0------o1---------- 02 ------03----- 04 ------05-------06
	 */
	public Logger log = Logger.getLogger(super.getClass());
	public List<Object> list = new ArrayList<Object>();
	public JSONObject json = new JSONObject();
	public JSONObject jsonResponse = new JSONObject();
	public final String response = "_response";

	public MechJspDB mechJsp = new MechJspDB();
	public BaseUtils utils = new BaseUtils();
	public String result = InterFaceName.RESULT;
	String task_id = InterFaceName.TASK_ID;
	String userList = InterFaceName.userList;
	String mechanicList = InterFaceName.mechanicList;
	String refit_task = InterFaceName.refit_task;
	String rescue_task = InterFaceName.rescue_task;
	String count = InterFaceName.COUNT;

	double range = 100;

//	/**
//	 * InterFaceName_005 ----get_available_tasks--周围已经出价的车改技工信息
//	 */
//	public JSONObject get_available_tasks(Object[] objects) {
//		String interfaceName = InterFaceName.InterFaceName_005;
//		START(interfaceName);
//		try {
////			mechJsp.inteface_005_1_show_view();// 先判断view是否存在
////			mechJsp.inteface_005_2_show_view();// 先判断view是否存在
//			Object o3 = objects[0];// mc_id任务编号
//			if (utils.judgeString(o3)) {// 是否能调节范围---待定
//				JSONObject jsonObject = new JSONObject();
//				Object[] temp = new Object[] { objects[0], range };
//				json.put(result, 1);
//				jsonObject.put(refit_task, mechJsp.interface_005_1(temp));// refitList
//				jsonObject.put(rescue_task, mechJsp.interface_005_2(temp));// rescueList
//				json.put(userList, jsonObject);
//			} else {
//				SOS("merchanic_id任务编号为空");
//				json.put(result, 0);
//				json.put(userList, list);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info(e);// 异常日志
//			json.put(result, 0);
//			json.put(userList, list);
//		}
//		jsonResponse.put(interfaceName.split("/")[1] + response, json);
//		System.out.println(jsonResponse);
//		END(interfaceName);
//		return jsonResponse;
//
//	}

//	/**
//	 * InterFaceName_009 ----upload_bid--技工抢单
//	 */
//	public JSONObject upload_bid(Object[] objects) {
//		String interfaceName = InterFaceName.InterFaceName_009;
//		START(interfaceName);
//		try {
//			Object o0 = objects[0];// mc_id任务编号
//			Object o1 = objects[1];// task_id任务编号
//			Object o3 = objects[2];// price
//			if (mechJsp.inteface_009_1_select_bid(objects)) {
//				// 任务已抢或任务进行中
//				SOS("任务已抢或任务进行中");
//				json.put(result, 0);
//			} else if (!utils.judgeString(o0)) {
//				// mc_id为空
//				SOS("mc_id任务编号为空");
//				json.put(result, 0);
//			} else if (!utils.judgeString(o1)) {
//				// task_id为空
//				SOS("task_id任务编号为空");
//				json.put(result, 0);
//			} else if (!utils.judgeString(o3)) {
//				// price为空
//				SOS("price 为空");
//				json.put(result, 0);
//			} else {
//				// upload_bid 跟新数据库
//				mechJsp.inteface_009_2_upload_bid(objects);
//				SOS("添加成功");
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
//
//	}

//	/**
//	 * InterFaceName_015 ----get_success_bid--用户选择技工后，返回给技工成功的任务表
//	 */
//	public JSONObject get_success_bid(Object[] objects) {
//		String interfaceName = InterFaceName.InterFaceName_015;
//		START(interfaceName);
//		try {
//			Object o0 = objects[0];// mc_id任务编号
//			if (!utils.judgeString(o0)) {
//				// mc_id为空
//				SOS("mc_id任务编号为空");
//				json.put(result, 0);
//				json.put(userList, list);
//			} else {
//				list = mechJsp.inteface_015_1_get_success_bid(objects);
//				if (list != null && list.size() > 0) {
//					SOS("获取成功");
//					json.put(result, 1);
//					json.put(userList, list);
//				} else {
//					SOS("用户未选择技工");
//					json.put(result, 0);
//					json.put(userList, list);
//				}
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info(e);// 异常日志
//			json.put(result, 0);
//			json.put(userList, list);
//		}
//		jsonResponse.put(interfaceName.split("/")[1] + response, json);
//		System.out.println(jsonResponse);
//		END(interfaceName);
//		return jsonResponse;
//
//	}

//	/**
//	 * InterFaceName_016 ----accept_bid--技工是否确定为用户服务
//	 */
//	public JSONObject accept_bid(Object[] objects) {
//		String interfaceName = InterFaceName.InterFaceName_015;
//		START(interfaceName);
//		try {
//			Object o0 = objects[0];// bid_id
//			Object o1 = objects[1];// is_accept
//
//			if (!utils.judgeString(o0)) {
//				// bid_id为空
//				SOS("bid_id为空");
//				json.put(result, 0);
//			} else if (!utils.judgeString(o1)) {
//				// is_accept为空
//				SOS("is_accept为空");
//				json.put(result, 0);
//			} else {
//				String is_accept = utils.turnToString(o1);
//				if (is_accept.equals("1")) {
//					// 确认服务
//					Integer sign = mechJsp.inteface_016_1_accept_bid(objects);
//					if (sign == 1) {
//						SOS("确认服务");
//						json.put(result, 1);
//					} else {
//						SOS("操作失败");
//						json.put(result, 0);
//					}
//
//				} else {
//					// 取消服务
//				}
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			log.info(e);// 异常日志
//			json.put(result, 0);
//			json.put(userList, list);
//		}
//		jsonResponse.put(interfaceName.split("/")[1] + response, json);
//		System.out.println(jsonResponse);
//		END(interfaceName);
//		return jsonResponse;
//
//	}

//	/**
//	 * InterFaceName_017--bid_finished_mec--在线下服务完成后，技工申请服务完成。
//	 * 
//	 * @param objects
//	 * @return
//	 */
//	public JSONObject bid_finished_mec(Object[] objects) {
//		String interfaceName = InterFaceName.InterFaceName_017;
//		START(interfaceName);
//		try {
//			Object o0 = objects[0];// bid_id任务编号
//			if (utils.judgeString(o0)) {// 是否能调节范围---待定
//				Object one_bid_id = mechJsp.interface_017_1_select_bid(objects);// 查询结构
//				if (!utils.judgeString(one_bid_id)) {
//					// 为空时
//					Object sign = mechJsp
//							.interface_017_2_bid_finished_mec(objects);
//					if (utils.judgeString(sign)) {
//						// 数据更新成功
//						SOS("申请成功");
//						json.put(result, 1);
//					} else {
//						SOS("申请失败");
//						json.put(result, 0);
//					}
//				} else {
//					SOS("任务已申请，请等待确认");
//					json.put(result, 0);
//				}
//
//			} else {
//				SOS("bid_id任务编号为空");
//				json.put(result, 0);
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
//	 * InterFaceName_021--cancel_bid_mec--技工取消发布的任务 
//	 * 
//	 * @param objects
//	 * @return
//	 */
//	public JSONObject cancel_bid_mec(Object[] objects) {
//		String interfaceName = InterFaceName.InterFaceName_021;
//		START(interfaceName);
//		try {
//			Object o0 = objects[0];// bid_id任务编号
//			if (!utils.judgeString(o0)) {
//				// bid_id为空
//				SOS("bid_id任务编号为空");
//				json.put(result, 0);
//			} else{
//				Object sign = mechJsp.interface_021_1_cancel_bid_mec(objects);
//				if (utils.judgeString(sign)) {
//					SOS("操作成功");
//					json.put(result, 1);
//				}else {
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

}
