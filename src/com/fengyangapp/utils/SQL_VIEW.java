package com.fengyangapp.utils;

public class SQL_VIEW {

	
	/**
	 * 003车改技工
	 */
	public static final String view_name_003 = "view_refitmechanic";
	/**
	 * 003===车改技工视图结构
	 */
	public static final String view_refitmechanic = "CREATE OR REPLACE VIEW view_refitmechanic AS SELECT"
			+ "	m.*"
			+ " FROM"
			+ "	mechanic m"
			+ " JOIN refitmechanic rfm ON rfm.id = m.id"
			+ " GROUP BY m.id ";
	/**
	 * 004  救援技工
	 */
	public static final String view_name_004 = "view_rescuemechanic";
	/**
	 * 004===救援技工视图结构
	 */
	public static final String view_rescuemechanic = "CREATE OR REPLACE VIEW view_rescuemechanic AS SELECT"
			+ "	m.id AS mc_id,"
			+ "	m.`name`,"
			+ "	m.latitude,"
			+ "	m.longitude,"
			+ "	c.user_id as user_id,"
			+ "	c.id AS car_id,"
			+ "	rr.rescue_type AS rescue_type"
			+ " FROM"
			+ "	mechanic m"
			+ " JOIN rescuemechanic rm ON rm.id = m.id"
			+ " JOIN rescue_carseries rc ON rc.mc_id = rm.id"
			+ " JOIN car c ON c.series_id = rc.series_id"
			+ " JOIN rescue_rescuetype rr ON rr.mc_id = rm.id"
			+ " GROUP BY m.id ,c.id,rr.rescue_type;";
	/**
	 * 006  在用户提交订单后，用户可查看是否有车改技工抢单
	 */
	public static final String view_name_006 = "unsuccess_refitbid";
	/**
	 * @context 描述：改
	 * @author 史旭杰
	 * @version 创建时间：2015年4月18日 下午4:46:45
	 */
	/**
	 * 006===在用户提交订单后，用户可查看是否有车改技工抢单  视图结构
	 */
//	public static final String unsuccess_refitbid_006 = "CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `unsuccess_refitbid` AS SELECT"
//			+ "	b.id AS bid_id,	"
//			+ "	b.task_id AS task_id,"
//			+ "	b.mc_id AS mc_id,	"
//			+ "	b.price AS price,	"
//			+ "	b.`status` AS `status`"
//			+ " FROM"
//			+ "	bid b"
//			+ " JOIN refitbid rfb ON b.id = rfb.id"
//			+ " AND b.`status` = 1"
//			+ " GROUP BY"
//			+ "	b.id,"
//			+ "	b.task_id,"
//			+ "	b.mc_id;";
	public static final String unsuccess_refitbid_006 = "CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `unsuccess_refitbid` AS SELECT"
			+ "	b.id AS bid_id,	"
			+ "	b.task_id AS task_id,"
			+ "	b.mc_id AS mc_id,	"
			+ "	b.price AS price,	"
			+ "	b.`status` AS `status`"
			+ " FROM"
			+ "	bid b"
			+ " JOIN view_selectable_refittask srf ON srf.id = b.task_id"
			+ " AND b.`status` = 1"
			+ " GROUP BY"
			+ "	b.id,"
			+ "	b.task_id,"
			+ "	b.mc_id;";
	/**
	 * 006  在用户提交订单后，用户可查看是否有车改技工抢单
	 */
	public static final String view_name_007 = "unsuccess_rescuebid";
	/**
	 * @context 描述：改
	 * @author 史旭杰
	 * @version 创建时间：2015年4月18日 下午4:47:55
	 */
	/**
	 * 006===在用户提交订单后，用户可查看是否有车改技工抢单  视图结构
	 */
	
//	public static final String unsuccess_rescuebid_007 = "CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `unsuccess_rescuebid` AS SELECT"
//			+ "	b.id AS bid_id,"
//			+ "	b.task_id AS task_id,"
//			+ "	b.mc_id AS mc_id,"
//			+ "	b.price AS price,"
//			+ "	b.`status` AS `status`"
//			+ " FROM"
//			+ "	bid b"
//			+ " JOIN rescuebid rb ON b.id = rb.id"
//			+ " AND b.`status` = 1"
//			+ " GROUP BY b.id;";
	public static final String unsuccess_rescuebid_007 = "CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `unsuccess_rescuebid` AS SELECT"
			+ "	b.id AS bid_id,"
			+ "	b.task_id AS task_id,"
			+ "	b.mc_id AS mc_id,"
			+ "	b.price AS price,"
			+ "	b.`status` AS `status`"
			+ " FROM"
			+ "	bid b"
			+ "JOIN view_selectable_rescuetask sr ON sr.id = b.task_id"
			+ " AND b.`status` = 1"
			+ " GROUP BY b.id;";
	
	//------------------------------------------------------
	// 技工模块
	/**
	 * 技工可选择的车改任务视图名称：view_selectable_refittask
	 */
	public static final String view_name_005_1 = "view_selectable_refittask";
	/**
	 * 005_1===可选的车改任务结构
	 */
	public static final String view_selectable_refittask = "CREATE OR REPLACE VIEW view_selectable_refittask AS SELECT"
			+ "	t.*"
			+ " FROM"
			+ "	task t"
			+ " JOIN refittask rft ON rft.id = t.id" + " AND t.`status` = 0;";
	/**
	 * 技工可选择的救援任务视图名称：view_selectable_rescuetask
	 */
	public static final String view_name_005_2 = "view_selectable_rescuetask";

	/**
	 * 005_2===可选的救援视图结构
	 */
	public static final String view_selectable_rescuetask = "CREATE OR REPLACE VIEW view_selectable_rescuetask AS SELECT"
			+ "	t.*,"
			+ "	rt.rescue_type AS rescue_type"
			+ " FROM"
			+ "	task t"
			+ " JOIN rescuetask rt ON rt.id = t.id" + " AND t.`status` = 0;";
	
	/**
	 *    包括 车系的ID，车的品牌，车的系列名称，车的图片
	 */
	
	public static final String car_brand_seriesName="CREATE OR REPLACE view car_brand_seriesName AS"
			+ " SELECT"
			+ " cs.id,"
			+ " cb.`name` AS brand_name,"
			+ " cs.`name` AS serier_name,"
			+ " cb.pic_url"
			+ " FROM"
			+ " carseries cs"
			+ " JOIN carbrand cb ON cb.id= cs.brand_id;";

}
