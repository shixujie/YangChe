package com.fengyangapp.dao.imql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import sun.swing.UIAction;

import com.fengyangapp.dao.BaseDao;
import com.fengyangapp.utils.BaseUtils;
import com.fengyangapp.utils.DBUtil;
import com.fengyangapp.utils.DateUtils;
import com.fengyangapp.utils.InterFaceName;

public class BaseDaoImpl {

	public JSONObject json = new JSONObject();
	public JSONObject jsonResponse = new JSONObject();
	public static BaseUtils utils = new BaseUtils();// 工具类
	public String result = InterFaceName.RESULT;// 结果
	public double range = 10.0;// 默认的区域范围
	public final String response = "_response";
	public List<Object> list = new ArrayList<Object>();
	public List<JSONObject> jsonList = new ArrayList<JSONObject>();
	public String bidList = InterFaceName.bidList;

	public Connection conn;
	public ResultSet rs;
	public static Statement st;
	public PreparedStatement ps;
	public Object sign = "";//标识符
	public Logger log = Logger.getLogger(super.getClass());

	public BaseDaoImpl() {
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 设置double的精度----默认为小数点6位
	 * 
	 * @param d
	 * @return
	 */
	public double turnToDouble(Object object) {
		// DecimalFormat format = new DecimalFormat("0.000000");
		// System.out.println(format.format(d));
		// System.out.println(utils.turnToDouble(format.format(d)));
		// return Double.parseDouble(format.format(d));
		return utils.turnToDouble(object);
	}

	// /**
	// * 通过获取技工的坐标
	// */
	// public double[] getMec_Lon_Lat(String sql) {
	// return get_Lon_Lat(sql);
	// }
	//
	// /**
	// * 获取坐标的
	// *
	// * @param sql
	// * @param range
	// * @return
	// */
	// public double[] get_Lon_Lat(String sql) {
	// double [] d=new double[]{2};
	// try {
	// ResultSet rs = st.executeQuery(sql);
	// while (rs.next()) {
	// d[0] = rs.getDouble(1);// 维度
	// d[1] = rs.getDouble(2);// 经度
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return d;
	// }

	/**
	 * 公用----查询或添加view视图
	 * 
	 * @param viewName
	 * @param sql_view
	 * @return
	 */
	public String show_view(String viewName, String sql_view) {
		// TODO
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
		if (jsonList != null && jsonList.size() > 0) {//不为空时
			jsonList.clear();
		}
		System.out.println(interfaceName + "..start..");
		log.info(interfaceName + "..start..");// 开启log日志
	}

	/**
	 * 退出接口
	 * 
	 * @param interfaceName
	 */
	public void END(String interfaceName) {
		// TODO
		System.out.println("json==" + json);
		System.out.println(interfaceName + "....end....");
		log.info(interfaceName + "....end....");// log日志结束
	}

	/**
	 * 简单的输出
	 * 
	 * @param value
	 */
	public void SOS(String value) {
		System.out.println("message===" + value);
	}

	/**
	 * 公共的update-------适用于只有一个条件且为integer类型是
	 * 
	 * @param sql
	 * @param objects
	 * @return
	 */
	public Object update(String sql, Object[] objects) {
		Object object = null;
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

	/**
	 * 公共的select-------适用于只有一个条件且为integer类型是
	 * 
	 * @param sql
	 * @param objects
	 * @return
	 */
	public Object select(String sql, Object[] objects) {
		Object object = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, utils.turnToInteger(objects[0]));
			rs = ps.executeQuery();
			while (rs.next()) {
				object = rs.getObject(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
	/**
	 * 判断Object[]是否为空
	 * 不为空返回true ---为空时返回false
	 * @return
	 */
	public boolean judgeObjectSize (Object[] o){
		if (o != null && o.length >0) {
			return true;
		}else {
			SOS(" object[] 为空");
			json.put(result, 0);
			return false;
		}
	}
	
	/**
	 * 判断 list的size
	 * @param list
	 * @return
	 */
	public boolean judgeListSize(List<Object> list){
		if (list != null && list.size() > 0) {
			return true;
		}else {
			SOS("list.size  为空 ");
			json.put(result, 0);
			return false;
		}
	}

	/**
	 * 判断Object是否为空
	 * 不为空返回true ---为空时返回false
	 * @return
	 */
	public boolean judgeString (Object o){
		if (o != null && o.toString().length() >0) {
			return true;
		}else {
			json.put(result, 0);
			return false;
		}
	}
	/**
	 * 判断集合是否为空
	 * @param list
	 * @return
	 */
	public boolean judgeList (List<Object> list){
		int size = list.size();
		if (list != null ||  size > 0) {
			list.clear();
		}
		return true;
	}
	/**
	 * 判断JSONObject是否为空
	 * @param list
	 * @return
	 */
	public boolean judgJson (JSONObject object){
		if (object != null) {
			object.clear();
		}
		return true;
	}
	/**
	 * 变为字符串型String
	 */
	public String turnToString(Object o){
		return o.toString();
	}
	/**
	 * 变为整数型Integer
	 */
	public Integer turnToInteger(Object o){
		return Integer.parseInt(o.toString());
	}
	/**
	 * 时间转换成String 
	 * 
	 * @param date
	 * @return
	 */
	public String dateTurnToString(Date date){
		SimpleDateFormat formate = new SimpleDateFormat(DateUtils.FORMAT_LONG);
		return formate.format(date);
	}
}
