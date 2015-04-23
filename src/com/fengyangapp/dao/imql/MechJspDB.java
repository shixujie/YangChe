package com.fengyangapp.dao.imql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fengyangapp.entity.InterFace_3_4;
import com.fengyangapp.entity.InterFace_5;
import com.fengyangapp.utils.BaseUtils;
import com.fengyangapp.utils.DBUtil;
import com.fengyangapp.utils.InterFaceName;
import com.fengyangapp.utils.SQL_MySQL;
import com.fengyangapp.utils.SQL_VIEW;

public class MechJspDB {

	private Connection conn;
	private Statement st;
	public List<Object> list = new ArrayList<Object>();
	BaseUtils utils = new BaseUtils();
	BaseDaoImpl daoImpl = new BaseDaoImpl();
	PreparedStatement ps;

	public MechJspDB() {
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Before
	public void init() {
		if (list != null || list.size() > 0) {
			list.clear();
		}
	}

	/**
	 * @return
	 */
	public String inteface_005_1_show_view() {
		String viewName = SQL_VIEW.view_name_005_1;// 005中用到的视图名称
		String sql_view = SQL_VIEW.view_selectable_refittask;
		return show_view(viewName, sql_view);

	}

	/**
	 * @return
	 */
	public String inteface_005_2_show_view() {
		String viewName = SQL_VIEW.view_name_005_2;// 005中用到的视图名称
		String sql_view = SQL_VIEW.view_selectable_rescuetask;
		return show_view(viewName, sql_view);

	}

	// /**
	// * 005_1-get_available_refittasks-获取可抢的任务单
	// *
	// * @param temp
	// * @return
	// */
	// public List<Object> interface_005_1(Object[] temp) {
	// try {
	// Integer mc_id = utils.turnToInteger(temp[0]);// 技工ID
	// double range = utils.turnToDouble(temp[1]);// 范围
	// String sql = "SELECT latitude,longitude FROM mechanic WHERE id = "
	// + mc_id + ";";
	// double[] location = getMec_Lon_Lat(sql);
	// double latitude = location[0];// 技工维度
	// double longitude = location[1];// 技工经度
	// double[] locationError = BaseUtils.GetDistance(latitude, longitude,
	// range);// 坐标矩阵
	// sql = SQL_MySQL.SQL_005_1;
	// list = getList(sql, mc_id, location, locationError, range);
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// return list;
	// }
	//
	// /**
	// * 005_1-get_available_rescuetasks-获取可抢的任务单
	// *
	// * @param temp
	// * @return
	// */
	// public List<Object> interface_005_2(Object[] temp) {
	// try {
	// Integer mc_id = utils.turnToInteger(temp[0]);// 技工ID
	// double range = utils.turnToDouble(temp[1]);// 范围
	// String sql = "SELECT latitude,longitude FROM mechanic WHERE id = "
	// + mc_id + ";";
	// double[] location = get_Lon_Lat(sql);
	// System.out.println(location[0] + "-----" + location[1]);
	//
	// double latitude = location[0];// 技工维度
	// double longitude = location[1];// 技工经度
	// double[] locationError = BaseUtils.GetDistance(latitude, longitude,
	// range);// 坐标矩阵
	// sql = SQL_MySQL.SQL_005_2;
	// list = getList(sql, mc_id, location, locationError, range);
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// return list;
	// }

	/**
	 * 公共
	 * 
	 * @param sql
	 * @param mc_id
	 * @param loc
	 * @param locErr
	 * @param range
	 * @return
	 */
	public List<Object> getList(String sql, Integer mc_id, double[] loc,
			double[] locErr, double range) {
		PreparedStatement ps = null;
		if (utils.judgeList(list)) {
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, mc_id);
				ps.setDouble(2, loc[0] - locErr[0]);
				ps.setDouble(3, loc[0] + locErr[0]);
				ps.setDouble(4, loc[1] - locErr[1]);
				ps.setDouble(5, loc[1] + locErr[1]);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					InterFace_5 pojo = new InterFace_5(rs.getInt(1),
							rs.getString(2), rs.getDouble(3), rs.getDouble(4),
							rs.getString(6));
					pojo.setTask_id(rs.getInt(5));
					list.add(pojo);
				}
				for (Object o : list) {
					InterFace_5 en = (InterFace_5) o;
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

	public double[] getMec_Lon_Lat(String sql) {
		return get_Lon_Lat(sql);
	}

	/**
	 * 获取坐标的
	 * 
	 * @param sql
	 * @param range
	 * @return
	 */
	public double[] get_Lon_Lat(String sql) {
		double[] d = null;
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getDouble(1));
				System.out.println(rs.getDouble(2));
				// 维度// 经度
				d = new double[] { rs.getDouble(1), rs.getDouble(2) };
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * 公用----查询或添加view视图
	 * 
	 * @param viewName
	 * @param sql_view
	 * @return
	 */
	public String show_view(String viewName, String sql_view) {
		System.out.println("InterFaceName" + viewName);
		// view_refitmechanic视图
		String temp = "";
		String sql = "show create view " + viewName + ";";
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				temp = rs.getObject(1).toString();
			}
		} catch (SQLException e) {
			try {
				st.execute(sql_view);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (temp != null && temp.length() > 0) {
			return temp;
		} else {
			return viewName;
		}
	}

	// /**
	// * InterFaceName_009_1 ----select_bid--技工抢单 判断是否已抢单
	// *
	// * @param objects
	// */
	// public boolean inteface_009_1_select_bid(Object[] objects) {
	// Integer mc_id = utils.turnToInteger(objects[0]);// mc_id任务编号
	// Integer task_id = utils.turnToInteger(objects[1]);// task_id任务编号
	// String sql = SQL_MySQL.SQL_009_1;
	// boolean b = false;
	// try {
	// ps = conn.prepareStatement(sql);
	// ps.setInt(1, mc_id);
	// ps.setInt(2, task_id);
	// ResultSet rs = ps.executeQuery();
	// while (rs.next()) {
	// // 有数据是bool=true
	// b = utils.judgeString(rs.getObject(1));
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return b;
	// }
	//
	// /**
	// * InterFaceName_009_2 ----upload_bid--技工抢单
	// *
	// * @param objects
	// */
	// public void inteface_009_2_upload_bid(Object[] objects) {
	// Integer mc_id = utils.turnToInteger(objects[0]);// mc_id任务编号
	// Integer task_id = utils.turnToInteger(objects[1]);// task_id任务编号
	// double price = utils.turnToDouble(objects[2]);// price
	// String sql = SQL_MySQL.SQL_009_2;
	// try {
	// ps = conn.prepareStatement(sql);
	// ps.setDouble(1, price);
	// ps.setInt(2, mc_id);
	// ps.setInt(3, task_id);
	// boolean b = ps.execute();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	@Test
	public void show() {
		String sql = SQL_MySQL.SQL_005_1;
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------15---------------start------------
	// public List<Object> inteface_015_1_get_success_bid(Object[] objects) {
	// try {
	// Integer mc_id = utils.turnToInteger(objects[0]);
	// if (utils.judgeList(list)) {
	// String sql = SQL_MySQL.SQL_015_1;
	// ps = conn.prepareStatement(sql);
	// ps.setInt(1, mc_id);
	// ResultSet rs = ps.executeQuery();
	// while (rs.next()) {
	// // 用户信息（id,name,lat,lon）.车型
	// InterFace_5 pojo = new InterFace_5(rs.getInt(1),
	// rs.getString(2), rs.getDouble(3), rs.getDouble(4),
	// rs.getString(6));
	// pojo.setBid_id(rs.getInt(5));
	// list.add(pojo);
	// }
	// }
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// return list;
	// }

	// ------------15---------------end------------

	// ------------16---------------start------------
	// public Integer inteface_016_1_accept_bid(Object[] objects) {
	// Integer sign = 0;
	// try {
	// Integer bid_id = utils.turnToInteger(objects[0]);// 抢单编号
	// if (utils.judgeList(list)) {
	// String sql = SQL_MySQL.SQL_016_1;
	// ps = conn.prepareStatement(sql);
	// ps.setInt(1, bid_id);
	// sign = ps.executeUpdate();
	// }
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// return sign;
	// }

	// ------------16---------------end------------

	// //------------------------2015-4-15 19:50:13
	// // ------------------------17---------start-----------------
	// /**
	// * InterFaceName_017_1--interface_017_1_select_bid--查看是否已提交申请
	// *
	// * @param objects
	// * @return
	// */
	//
	// public Object interface_017_1_select_bid(Object[] objects) {
	// String sql = SQL_MySQL.SQL_017_1;
	// return select(sql, objects);
	// }
	//
	// /**
	// * interface_017_2_bid_finished_mec---将任务变为 技工申请状态
	// *
	// * @param objects
	// * @return
	// */
	// public Object interface_017_2_bid_finished_mec(Object[] objects) {
	// String sql = SQL_MySQL.SQL_017_2;
	// return update(sql, objects);
	// }
	//
	// // ------------------------17---------end-----------------

	// *********************************************
	// ------------------------21---------start-----------------
//	/**
//	 * InterFaceName_021--cancel_bid_mec--技工取消发布的任务 *
//	 * 
//	 * @param objects
//	 * @return
//	 */
//	public Object interface_021_1_cancel_bid_mec(Object[] objects) {
//		String sql = SQL_MySQL.SQL_021_1;
//		return update(sql, objects);
//	}

	// -------------------------20----------end-------------

	public Object update(String sql, Object[] objects) {
		Object object = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, utils.turnToInteger(objects[0]));
			object = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	public Object select(String sql, Object[] objects) {
		Object object = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, utils.turnToInteger(objects[0]));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				object = rs.getObject(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
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
