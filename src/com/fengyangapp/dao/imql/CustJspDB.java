package com.fengyangapp.dao.imql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fengyangapp.dao.BaseDao;
import com.fengyangapp.entity.InterFace_011;
import com.fengyangapp.entity.InterFace_013;
import com.fengyangapp.entity.InterFace_3_4;
import com.fengyangapp.utils.BaseUtils;
import com.fengyangapp.utils.DBUtil;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;
import com.fengyangapp.utils.SQL_VIEW;

public class CustJspDB extends BaseDaoImpl {

	private Connection conn;
	private Statement st;
	BaseUtils utils = new BaseUtils();

	public CustJspDB() {
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (list != null || list.size() > 0) {
			list.clear();
		}

	}

	/**
	 * (接口1和接口2公用)第一个接口中的SQL--查询是否有未完成的任务 num：1
	 * 
	 * @return
	 */
	public List<Object> inteface_1_2_001(Integer user_id) {
		String sql = "SELECT id FROM task WHERE `status` = 0 AND user_id = "
				+ user_id;
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getObject(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * (接口1和接口2公用) 第一个接口中的SQL--添加新的任务 num:2
	 * 
	 * @return
	 */
	public boolean inteface_1_2_002(Integer user_id, double d1, double d2,
			Integer car_id) {
		// 添加到用户任务表中
		boolean b = false;
		String sql = "INSERT INTO task (user_id,date,latitude,longitude,car_id,status) VALUES   ("
				+ user_id + ",NOW()," + d1 + "," + d2 + "," + car_id + ",0)";
		try {
			st.execute(sql);
			list = inteface_1_2_001(user_id);
			if (list != null && list.size() > 0) {
				b = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	// /**
	// * 获取refittask最新task_id
	// *
	// * @return
	// */
	// public Integer inteface_001_1() {
	// // 添加到用户任务表中
	// Integer task_id = 0;
	// Integer sign = 0;
	// String sql = "SELECT LAST_INSERT_ID()";
	// try {
	// ResultSet rs = st.executeQuery(sql);
	// while (rs.next()) {
	// task_id = Integer.parseInt(rs.getObject(1).toString());
	// sql = "INSERT INTO refittask (id) VALUES  (" + task_id + ")";
	// sign = st.executeUpdate(sql);
	// }
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// if (sign == 1) {
	// return task_id;
	// }else {
	// return 0;
	// }
	// }

	// /**
	// * 获取rescuetask最新task_id
	// *
	// * @param rescue_type
	// * @return
	// */
	//
	// public Integer inteface_002_1(Integer rescue_type) {
	// // 添加到用户任务表中
	// Integer task_id = 0;
	// String sql = "SELECT LAST_INSERT_ID()";
	// try {
	// ResultSet rs = st.executeQuery(sql);
	// while (rs.next()) {
	// task_id = Integer.parseInt(rs.getObject(1).toString());
	// sql = "INSERT INTO rescuetask (id,rescue_type) VALUES  ("
	// + task_id + "," + rescue_type + ")";
	// st.executeUpdate(sql);
	// }
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return task_id;
	// }

	// /**
	// * 获取refittask最新task_id
	// *
	// * @return
	// */
	// public Integer inteface_002_3() {
	// // 添加到用户任务表中
	// Integer task_id = 0;
	// String sql = "SELECT LAST_INSERT_ID()";
	// try {
	// ResultSet rs = st.executeQuery(sql);
	// while (rs.next()) {
	// task_id = Integer.parseInt(rs.getObject(1).toString());
	// sql = "INSERT INTO refittask (id) VALUES  (" + task_id + ")";
	// st.execute(sql);
	// }
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return task_id;
	// }

	/**
	 * 003接口的view_refitmechanic视图检测或添加
	 * 
	 * @return
	 */
	@Test
	public String inteface_003_show_view() {
		System.out.println("InterFaceName" + InterFaceName.InterFaceName_003);
		// view_refitmechanic视图
		String viewName = "";
		String sql = "show create view view_refitmechanic;";
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				viewName = rs.getObject(1).toString();
			}
		} catch (SQLException e) {
			String createNewView = "CREATE OR REPLACE VIEW view_refitmechanic AS SELECT"
					+ "	m.*"
					+ " FROM"
					+ "	mechanic m"
					+ " JOIN refitmechanic rfm ON rfm.id = m.id"
					+ " GROUP BY m.id ";
			try {
				st.execute(createNewView);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (viewName != null && viewName.length() > 0) {
			return viewName;
		} else {
			return "view_refitmechanic";
		}
	}

	// /**
	// * 003获取附近车改技工位置
	// *
	// * @param objects
	// * @return
	// */
	// public List<Object> interface_003_1(Object[] objects) {
	// Integer task_id = Integer.parseInt(objects[0].toString());// 任务编号
	// double range = Double.parseDouble(objects[1].toString());
	// double latitude = 0, longitude = 0;
	// String sql = "SELECT latitude,longitude FROM task WHERE id = "
	// + task_id;
	// try {
	// ResultSet rs = st.executeQuery(sql);
	// while (rs.next()) {
	// latitude = rs.getDouble(1);// 维度
	// longitude = rs.getDouble(2);// 经度
	// }
	// double[] b = BaseUtils.GetDistance(latitude, longitude, range);
	// sql = "SELECT" + " vrfm.id," + "	vrfm.`name`," + " vrfm.latitude,"
	// + "	vrfm.longitude" + " FROM" + "	view_refitmechanic vrfm"
	// + " JOIN refitmechanic_vs_car rfc ON vrfm.id = rfc.mc_id "
	// + " JOIN task t ON t.car_id = rfc.car_id" + " AND t.id = ?"
	// + " AND vrfm.latitude > ?" + " AND vrfm.latitude < ?"
	// + " AND vrfm.longitude > ?" + " AND vrfm.longitude < ?"
	// + " GROUP BY mc_id";
	// PreparedStatement ps = conn.prepareStatement(sql);
	// ps.setInt(1, task_id);
	// ps.setDouble(2, latitude - b[0]);
	// ps.setDouble(3, latitude + b[0]);
	// ps.setDouble(4, longitude - b[1]);
	// ps.setDouble(5, longitude + b[1]);
	// rs = ps.executeQuery();
	// while (rs.next()) {
	// InterFace_3_4 entity = new InterFace_3_4();
	// entity.setMc_id(rs.getInt(1));
	// entity.setMc_name(rs.getString(2));
	// entity.setLatitude(rs.getDouble(3));
	// entity.setLongitude(rs.getDouble(4));
	// list.add(entity);
	// }
	// for (Object o : list) {
	// InterFace_3_4 en = (InterFace_3_4) o;
	// double lat = en.getLatitude();
	// double lon = en.getLongitude();
	// if (range < BaseUtils
	// .getDistatce(latitude, longitude, lat, lon)) {// 判断在圆形范围内是否有技工
	// list.remove(en);
	// }
	// }
	// insert_into_bid(task_id, list);// 添加到bid中
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return list;
	// }

	/**
	 * 003--004---公用 存入bid中
	 * 
	 * @param task_id
	 * @param list
	 */
	public void insert_into_bid(Integer task_id, List<Object> list) {
		try {
			for (Object object : list) {
				InterFace_3_4 en = (InterFace_3_4) object;
				String sql = new String(
						"INSERT INTO bid (task_id,date,mc_id,price,status) VALUES("
								+ task_id + ",NOW()," + en.getMc_id() + ",0,0)");
				st.addBatch(sql);
			}
			st.executeBatch();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 003--004---公用 添加到 refitbid或rescuebid中
	 * 
	 * @param SQLName
	 * @param list
	 */
	public void insert_into_mech_bid(String mechName, List<Object> list) {
		try {
			for (Object object : list) {
				Integer bid_id = Integer.parseInt(object.toString());
				String sql = new String("INSERT INTO " + mechName
						+ " (id) VALUES(" + bid_id + ")");
				st.addBatch(sql);
			}
			st.executeBatch();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// /**
	// * 004接口的view_rescuemechanic视图检测或添加
	// *
	// * @return
	// */
	// public String inteface_004_show_view() {
	// System.out.println("InterFaceName" + InterFaceName.InterFaceName_004);
	// // view_refitmechanic视图
	// String viewName = "";
	// String sql = "show create view view_rescuemechanic;";
	// try {
	// ResultSet rs = st.executeQuery(sql);
	// while (rs.next()) {
	// viewName = rs.getObject(1).toString();
	// }
	// } catch (SQLException e) {
	// String createNewView =
	// "CREATE OR REPLACE VIEW view_rescuemechanic AS SELECT"
	// + "	m.id AS mc_id,"
	// + "	m.`name`,"
	// + "	m.latitude,"
	// + "	m.longitude,"
	// + "	c.user_id as user_id,"
	// + "	c.id AS car_id,"
	// + "	rr.rescue_type AS rescue_type"
	// + " FROM"
	// + "	mechanic m"
	// + " JOIN rescuemechanic rm ON rm.id = m.id"
	// + " JOIN rescue_carseries rc ON rc.mc_id = rm.id"
	// + " JOIN car c ON c.series_id = rc.series_id"
	// + " JOIN rescue_rescuetype rr ON rr.mc_id = rm.id"
	// + " GROUP BY m.id ,c.id,rr.rescue_type;";
	// try {
	// st.execute(createNewView);
	// } catch (SQLException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	// }
	//
	// if (viewName != null && viewName.length() > 0) {
	// return viewName;
	// } else {
	// return "view_rescuemechanic";
	// }
	// }

	// public List<Object> interface_004_1(Object[] objects) {
	// Integer task_id = Integer.parseInt(objects[0].toString());// 任务编号
	// double range = Double.parseDouble(objects[1].toString());
	// double latitude = 0, longitude = 0;
	// String sql = "SELECT latitude,longitude FROM task WHERE id = "
	// + task_id;
	// try {
	// if (utils.judgeList(list)) {
	// ResultSet rs = st.executeQuery(sql);
	// while (rs.next()) {
	// latitude = rs.getDouble(1);// 维度
	// longitude = rs.getDouble(2);// 经度
	// }
	// double[] b = BaseUtils.GetDistance(latitude, longitude, range);
	// sql = "SELECT"
	// + "	vrm.id,"
	// + "	vrm.`name`,"
	// + "	vrm.latitude,"
	// + "	vrm.longitude"
	// + " FROM"
	// + "	view_rescuemechanic vrm"
	// + "	JOIN rescuemechanic_vs_car rmc ON rmc.mc_id = vrm.id"
	// + "	JOIN view_selectable_rescuetask vrt ON vrt.car_id = rmc.car_id"
	// +
	// "	JOIN rescuemechanic_vs_rescuetype rmr ON rmr.type_id = vrt.rescue_type"
	// + " AND vrt.id = ?" + " AND vrm.latitude > ?"
	// + " AND vrm.latitude < ?" + " AND vrm.longitude> ?"
	// + " AND vrm.longitude< ?" + " GROUP BY vrm.id;";
	// PreparedStatement ps = conn.prepareStatement(sql);
	// ps.setInt(1, task_id);
	// ps.setDouble(2, latitude - b[0]);
	// ps.setDouble(3, latitude + b[0]);
	// ps.setDouble(4, longitude - b[1]);
	// ps.setDouble(5, longitude + b[1]);
	// rs = ps.executeQuery();
	// while (rs.next()) {
	// InterFace_3_4 entity = new InterFace_3_4();
	// entity.setMc_id(rs.getInt(1));
	// entity.setMc_name(rs.getString(2));
	// entity.setLatitude(rs.getDouble(3));
	// entity.setLongitude(rs.getDouble(4));
	// list.add(entity);
	// }
	// for (Object o : list) {
	// InterFace_3_4 en = (InterFace_3_4) o;
	// double lat = en.getLatitude();
	// double lon = en.getLongitude();
	// if (range < BaseUtils.getDistatce(latitude, longitude, lat,
	// lon)) {// 判断在圆形范围内是否有技工
	// list.remove(en);
	// }
	// }
	// if (list != null && list.size() > 0) {
	// insert_into_bid(task_id, list);// 添加到bid中
	// }
	// }
	//
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// return list;
	// }

	/**
	 * 视图
	 * 
	 * @return
	 */
	public String interface_006_show_view() {
		String viewName = SQL_VIEW.view_name_006;
		String sql_view = SQL_VIEW.unsuccess_refitbid_006;
		return show_view(viewName, sql_view);
	}

	// public List<Object> interface_006_1(Object[] o) {
	// if (utils.judgeList(list)) {
	// Integer task_id = utils.turnToInteger(o[0]);
	// String sql = SQL_MySQL.SQL_006_1;
	// try {
	// PreparedStatement ps = conn.prepareStatement(sql);
	// ps.setInt(1, task_id);// task_id
	// ResultSet rs = ps.executeQuery();
	// while (rs.next()) {
	// list.add(rs.getInt(1));// 抢单的数量
	// list.add(task_id);// 任务编号
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// return list;
	// }

	/**
	 * 视图
	 * 
	 * @return
	 */
	public String interface_007_show_view() {
		String viewName = SQL_VIEW.view_name_007;
		String sql_view = SQL_VIEW.unsuccess_rescuebid_007;
		return show_view(viewName, sql_view);
	}

	// public List<Object> interface_007_1(Object[] o) {
	// if (utils.judgeList(list)) {
	// Integer task_id = utils.turnToInteger(o[0]);
	// String sql = SQL_MySQL.SQL_007_1;
	// try {
	// PreparedStatement ps = conn.prepareStatement(sql);
	// ps.setInt(1, task_id);// task_id
	// ResultSet rs = ps.executeQuery();
	// while (rs.next()) {
	// System.out.println(rs.getInt(1));
	// list.add(rs.getInt(1));// 抢单的数量
	// list.add(task_id);// 任务编号
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// return list;
	// }

	// --------11--12----start-------------------------------
	// /**
	// * InterFaceName_011--用户获取车改技工抢单表--get_refit_bids
	// *
	// * @param o
	// * @return
	// */
	// public List<Object> interface_0011_get_refit_bids(Object[] o) {
	// String sql = SQL_MySQL.SQL_011_1;
	// return interface_0011_012_get_mechanic_bids(o, sql);
	// }

	// /**
	// * InterFaceName_012---获取抢单技工的列表---救援get_rescue_bids
	// *
	// * @param o
	// * @return
	// */
	// public List<Object> interface_0012_get_rescue_bids(Object[] o) {
	// String sql = SQL_MySQL.SQL_012_1;
	// return interface_0011_012_get_mechanic_bids(o, sql);
	// }

	/**
	 * interface_0011和interface_0012公用的接口
	 * 
	 * @param o
	 * @return
	 */
	public List<Object> interface_0011_012_get_mechanic_bids(Object[] o,
			String sql) {
		// TODO Auto-generated method stub
		if (utils.judgeList(list)) {
			Integer task_id = utils.turnToInteger(o[0]);

			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, task_id);// task_id
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					// 技工信息（id,name,lat,lon,star,price,bid_id）
					InterFace_011 en = new InterFace_011(rs.getInt(1),
							rs.getString(2), rs.getDouble(3), rs.getDouble(4),
							rs.getDouble(5), rs.getDouble(6), rs.getInt(7));
					list.add(en);//
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	// --------11--12----end-------------------------------

	// -----------13---start------------
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
							rs.getString(2), rs.getString(3), rs.getDouble(4),
							rs.getDouble(5), rs.getDouble(5), rs.getDouble(8),
							bid_id);
					list.add(en);//
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	// -----------13---end-------------

	// -----------14---start-------------
	// /**
	// * 由bid_id求task_id
	// */
	// public Object interface_0014_0_judge_bid(Object[] o){
	// String sql = SQL_MySQL.SQL_014_0;
	// return interface_014_judge_bid(o,sql);
	// }
	// /**
	// * 由task_id求 bid_ids 判断是否已经选择技工
	// */
	// public Object interface_0014_1_judge_bid(Object[] o){
	// String sql = SQL_MySQL.SQL_014_1;
	// return interface_014_judge_bid(o,sql);
	// }
	// /**
	// * bid_id 判断技工是否已被选则
	// */
	// public Object interface_0014_2_judge_bid(Object[] o){
	// String sql = SQL_MySQL.SQL_014_2;
	// return interface_014_judge_bid(o,sql);
	// }

	/**
//	 * interface_014--公用
//	 * 
//	 * @param o
//	 * @param sql
//	 * @return
//	 */
//	public Object interface_014_judge_bid(Object[] o, String sql) {
//		Object object = null;
//		if (utils.judgeList(list)) {
//			Integer bid_id = utils.turnToInteger(o[0]);// bid_id
//			try {
//				PreparedStatement ps = conn.prepareStatement(sql);
//				ps.setInt(1, bid_id);// bid_id
//				ResultSet rs = ps.executeQuery();
//				while (rs.next()) {
//					// 有数据是bool=true
//					object = rs.getObject(1);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return object;
//	}

	// public Object interface_0014_2_choose_bid(Object[] objects) {
	// String sql = SQL_MySQL.SQL_014_3;
	// return update(sql, objects);
	// if (utils.judgeList(list)) {
	// Integer bid_id = utils.turnToInteger(o[0]);//bid_id
	// try {
	// String sql = SQL_MySQL.SQL_014_3;
	// PreparedStatement ps = conn.prepareStatement(sql);
	// ps.setInt(1, bid_id);// task_id
	// ps.execute();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }

	// -----------14---end-------------

	// -----------14---start-------------
	// -----------14---end-------------

	// -----------14---start-------------
	// -----------14---end-------------

	// -----------14---start-------------
	// -----------14---end-------------

//	// -------------------------18----------start-------------
//	/**
//	 * InterFaceName_018_1--bid_unfinished_user----任务未完成
//	 * 
//	 * @param temp
//	 */
//	public Object interface_018_1_bid_unfinished_user(Object[] objects) {
//		String sql = SQL_MySQL.SQL_018_1;
//		return update(sql, objects);
//	}
//
//	/**
//	 * InterFaceName_018_2--bid_finished_user----任务完成
//	 * 
//	 * @param temp
//	 */
//	public Object interface_018_2_bid_finished_user(Object[] objects) {
//		String sql = SQL_MySQL.SQL_018_2;
//		return update(sql, objects);
//	}
//
//	// -------------------------18----------end-------------

	// *********************************
	// -------------------------19----------star-------------

//	/**
//	 * InterFaceName_019--submit_comment--用户评价
//	 */
//
//	public Object interface_019_1_submit_comment(Object[] temp) {
//		Object object = null;
//		String sql = SQL_MySQL.SQL_019_1;
//		Integer bid_id = utils.turnToInteger(temp[0]);
//		double star = utils.turnToDouble(temp[1]);
//		String comment = temp[2].toString();
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, bid_id);
//			ps.setDouble(2, star);
//			ps.setString(3, comment);
//			object = ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return object;
//	}

	// -------------------------19----------end-------------

	// *********************************
	// -------------------------20----------star-------------
//	/**
//	 * InterFaceName_020--cancel_bid_user--用户取消发布的任务
//	 */
//	public Object interface_020_1_cancel_bid_user(Object[] objects) {
//		String sql = SQL_MySQL.SQL_020_1;
//		return update(sql, objects);
//	}

	/**
	 * InterFaceName_020--cancel_bid_user--用户取消发布的任务
	 */
	public Object interface_022_1_cancel_bid_user(Object[] objects) {
		String sql = SQL_MySQL.SQL_022_1;
		return update(sql, objects);
	}

	// -------------------------20----------end-------------

	// ************************************

	// -------------------------22----------star-------------

//	/**
//	 * InterFaceName_022_1--cancel_task_user--更新task
//	 */
//	public Object interface_022_1_cancel_task_user(Object[] objects) {
//		String sql = SQL_MySQL.SQL_022_1;
//		return update(sql, objects);
//	}
//
//	/**
//	 * InterFaceName_022_2--cancel_task_user--更新bid
//	 */
//	public Object interface_022_2_cancel_task_user(Object[] objects) {
//		String sql = SQL_MySQL.SQL_022_2;
//		return update(sql, objects);
//	}
//
//	/**
//	 * InterFaceName_022_3--cancel_task_user--搜索task
//	 */
//	public Object interface_022_3_cancel_task_user(Object[] objects) {
//		String sql = SQL_MySQL.SQL_022_3;
//		return select(sql, objects);
//	}

	// -------------------------22----------end-------------

//	/**
//	 * 公共的update-------适用于只有一个条件且为integer类型是
//	 * 
//	 * @param sql
//	 * @param objects
//	 * @return
//	 */
//	public Object update(String sql, Object[] objects) {
//		Object object = null;
//		PreparedStatement ps;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, utils.turnToInteger(objects[0]));
//			object = ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return object;
//	}
//
//	/**
//	 * 公共的select-------适用于只有一个条件且为integer类型是
//	 * 
//	 * @param sql
//	 * @param objects
//	 * @return
//	 */
//	public Object select(String sql, Object[] objects) {
//		Object object = null;
//		PreparedStatement ps;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, utils.turnToInteger(objects[0]));
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				object = rs.getObject(1);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return object;
//	}

	public static void main(String[] args) {
		CustJspDB db = new CustJspDB();
		Object[] objects = new Object[] { 2, 5 };

	}

	// @After
	// public void destory() {
	// if (conn != null) {
	// try {
	// conn.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }
}
