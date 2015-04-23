package com.fengyangapp.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

public class BaseUtils {
	static final long serialVersionUID = 1L;

	public static String interFaceName = "";

	public static String sign = "";

	public static final String interface001_sql = "SELECT id FROM task WHERE `status` = 0 AND user_id =";
	/**
	 * 显示的工具类 分别为user_id//longitude// latitude// mc_id//task_id//bid_id//rescue_type
	 * ---------------o0------o1---------- 02 -------03----- 04 ------05-------06
	 */
	public static Object o0, o1, o2, o3, o4, o5,o6;
	/**
	 * json对象
	 */
	public static JSONObject json = new JSONObject();

	/**
	 * 在5公里范围内
	 */
	public static double range = 5;
	/**
	 * 时间
	 */
	public static String date = DateUtils.getNow();

	/**
	 * 初始化对象 user_id//longitude// latitude// mc_id//task_id//bid_id
	 */
	public static void init() {
		o0 = getPARAMETER("user_id");// 用户ID
		o1 = getPARAMETER("longitude");// 经度
		o2 = getPARAMETER("latitude");// 纬度
		o3 = getPARAMETER("mc_id");// 技工ID
		o4 = getPARAMETER("task_id");// 任务编号ID
		o5 = getPARAMETER("bid_id");// 技工的出价
		o6 = getPARAMETER("car_id");// 技工的出价
	}

	/**
	 * 显示的工具类 分别为 user_id//longitude// latitude// mc_id//task_id//bid_id//car_id
	 * 
	 * @return
	 */
	public static Object[] checkInit(int int0, int int1, int int2, int int3,
			int int4, int int5,int int6) {
		init();
		Object[] objects = new Object[] {};
		if (int0 == 1) {
			if (o0 != null && ((String) o0).length() > 0) {// 用户ID
				objects[0] = o0;
			}
		}
		if (int1 == 1 && int2 == 1) {
			if ((o1 != null && ((String) o1).length() > 0)
					&& (o2 != null && ((String) o2).length() > 0)) {// 经纬度获取失败
				objects[1] = o1;
				objects[2] = o2;
			}
		}

		if (int3 == 1) {
			if (o3 != null && ((String) o3).length() > 0) {// 没有检测到技工ID
				objects[3] = o3;
			}
		}
		if (int4 == 1) {
			if (o4 != null && ((String) o4).length() > 0) {// 任务表ID
				objects[4] = o4;
			}
		}
		if (int5 == 1) {
			if (o5 != null && ((String) o5).length() > 0) {// 抢单表ID
				objects[5] = o5;
			}
		}
		if (int5 == 1) {
			if (o6 != null && ((String) o6).length() > 0) {// car_ID
				objects[6] = o6;
			}
		}
		return objects;
	}

	/**
	 * System.out.println()--缩减版 将Object定义为name控制台输出
	 * 
	 * @param name
	 * @param o
	 */
	public void SOS(String name, Object o) {

		System.out.println(name + "----" + o);
	}

	/**
	 * JSONArray 前台输出
	 * 
	 * @param o
	 */
	public void outPrintJSONArray(Object o) {

		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		System.out.println("outPrintJSONArray");

		try {
			JSONArray jsonArray = JSONArray.fromObject(o);
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.print(jsonArray);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Object数据前台输出
	 * 
	 * @param o
	 */
	public PrintWriter outPrint(Object o) {
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = ServletActionContext.getResponse().getWriter();
			out.print(o);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}

	/**
	 * 获取name的session值 getSession().getAttribute(name)
	 * 
	 * @param name
	 * @return
	 */
	public Object getSESSION(String name) {

		// SOS("getSESSION", name);
		if (ServletActionContext.getRequest().getSession().getAttribute(name) == null) {
			return null;
		} else {
			return ServletActionContext.getRequest().getSession()
					.getAttribute(name);
		}

	}

	/**
	 * 将Object数据用name存放至session getSession().setAttribute(name, o)
	 * 
	 * @param name
	 * @param o
	 */
	public void setSESSION(String name, Object o) {

		SOS("setSESSION", name);
		ServletActionContext.getRequest().getSession().setAttribute(name, o);
	}

	/**
	 * 删除session中属性名为name的对象
	 * 
	 * @param name
	 */
	public void removeSESSION(String name) {

		SOS("removeSESSION", name);
		ServletActionContext.getRequest().getSession().removeAttribute(name);
	}

	/**
	 * 根据name获取页面传递的值 getParameter(name)
	 * 
	 * @param name
	 * @return Object
	 */
	public static Object getPARAMETER(String name) {

		// System.out.println("getPARAMETER");
		if (ServletActionContext.getRequest().getParameter(name) == null) {
			return null;
		} else {
			return ServletActionContext.getRequest().getParameter(name);
		}
	}

	/**
	 * sendRedirect(URL)
	 * 
	 * @param URL
	 */
	public void sendREDIRECT(String URL) {

		// System.out.println("sendREDIRECT");
		try {
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().sendRedirect(URL);
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * getRequestDispatcher(URL)
	 * 
	 * @param URL
	 */
	public void get_REQUEST_Dispatcher(String URL) {

		try {

			ServletActionContext
					.getRequest()
					.getRequestDispatcher(URL)
					.forward(ServletActionContext.getRequest(),
							ServletActionContext.getResponse());
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// double R = 6378137.0;// 取WGS84标准参考椭球中的地球长半径(单位:m)
	private static double EARTH_RADIUS = 6378.137;// 地球半径(单位：km)

	/**
	 * 一点的维度与经度lat1，lon1 ;另一点维度与经度lat2，lon2
	 * 
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @return
	 */
	public static double getDistatce(double lat1, double lon1, double lat2,
			double lon2) {

		// double R = 6378137.0;// 取WGS84标准参考椭球中的地球长半径(单位:m)
		double R = 6371;// 地球半径（单位：km）
		double distance = 0.0;// 两点间的距离
		double dLat = Math.abs((lat2 - lat1) * Math.PI / 180);// 维度差值* pi/180
		double dLon = Math.abs((lon2 - lon1) * Math.PI / 180);// 经度差值* pi/180
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(lat1 * Math.PI / 180)
				* Math.cos(lat2 * Math.PI / 180) * Math.sin(dLon / 2)
				* Math.sin(dLon / 2);
		distance = (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))) * R;
		return distance;
	}

	public static double[] GetDistance(double lat1, double lng1, double range) {
		double[] d = new double[2];
		double s = 0;// 距离
		for (double i = 0.05; i < 5; i += 0.05) {// 纬度
			s = getDistatce(lat1, lng1, lat1 + i, lng1);
			if (s >= range) {
				d[0] = i;
				break;
			}
		}
		for (double i = 0.05; i < 5; i += 0.05) {// 经度
			s = getDistatce(lat1, lng1, lat1, lng1 + i);
			if (s >= range) {
				d[1] = i;
				break;
			}
		}
		return d;
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
	 * 变为小数型double
	 */
	public double turnToDouble(Object o){
		return Double.parseDouble(o.toString());
	}
}
