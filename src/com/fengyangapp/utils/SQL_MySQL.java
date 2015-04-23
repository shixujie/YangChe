package com.fengyangapp.utils;

public class SQL_MySQL {

	public static final String SQL_003_1 = "SELECT" 
			+ " vrfm.id," + "	vrfm.`name`," + " vrfm.latitude,"
			+ "	vrfm.longitude" + " FROM" + "	view_refitmechanic vrfm"
			+ " JOIN refitmechanic_vs_car rfc ON vrfm.id = rfc.mc_id "
			+ " JOIN task t ON t.car_id = rfc.car_id" + " AND t.id = ?"
			+ " AND vrfm.latitude > ?" + " AND vrfm.latitude < ?"
			+ " AND vrfm.longitude > ?" + " AND vrfm.longitude < ?"
			+ " GROUP BY mc_id";
	
	public static final String SQL_004_1 ="SELECT"
			+ "	vrm.id,"
			+ "	vrm.`name`,"
			+ "	vrm.latitude,"
			+ "	vrm.longitude"
			+ " FROM"
			+ "	view_rescuemechanic vrm"
			+ "	JOIN rescuemechanic_vs_car rmc ON rmc.mc_id = vrm.id"
			+ "	JOIN view_selectable_rescuetask vrt ON vrt.car_id = rmc.car_id"
			+ "	JOIN rescuemechanic_vs_rescuetype rmr ON rmr.type_id = vrt.rescue_type"
			+ " AND vrt.id = ?" + " AND vrm.latitude > ?"
			+ " AND vrm.latitude < ?" + " AND vrm.longitude> ?"
			+ " AND vrm.longitude< ?" + " GROUP BY vrm.id;";
	
			/*sql = "SELECT"

			+ "	vrm.id,"
			+ "	vrm.`name`,"
			+ "	vrm.latitude,"
			+ "	vrm.longitude"
			+ " FROM"
			+ "	view_rescuemechanic vrm"
			+ "	JOIN rescuemechanic_vs_car rmc ON rmc.mc_id = vrm.id"
			+ "	JOIN view_selectable_rescuetask vrt ON vrt.car_id = rmc.car_id"
			+ "	JOIN rescuemechanic_vs_rescuetype rmr ON rmr.type_id = vrt.rescue_type"
			+ " AND vrt.id = ?" + " AND vrm.latitude > ?"
			+ " AND vrm.latitude < ?" + " AND vrm.longitude> ?"
			+ " AND vrm.longitude< ?" + " GROUP BY vrm.id;"; 
	 */
	
	
	
	/**
	 * 搜索抢单车改技工的数量和task_id
	 */
	public static final String SQL_006_1 = "SELECT "
			+ "COUNT(bid_id),"
			+ "task_id "
			+ "FROM "
			+ "unsuccess_refitbid "
			+ "WHERE task_id = ?;";
	/**
	 * 搜索抢单救援技工的数量和task_id
	 */
	public static  String SQL_007_1 = "SELECT "
			+ " COUNT(bid_id)"
			+ " FROM"
			+ " unsuccess_rescuebid"
			+ " WHERE task_id = ?";
	
	// ------------------------------------------------------
	// 技工模块
	public static  String SQL_005_1 = "SELECT "
			+ "	vrft.user_id,"
			+ "	u.nick_name AS user_name,"
			+ "	vrft.latitude,"
			+ "	vrft.longitude,"
			+ "	vrft.id,"
			+ "	rmc.car_name AS car_model"
			+ " FROM"
			+ " view_selectable_refittask vrft"
			+ " JOIN user u ON u.id = vrft.user_id"
			+ " JOIN refitmechanic_vs_car rmc ON rmc.car_id = vrft.car_id"
			+ " JOIN view_refitmechanic vrfm  ON vrfm.id = rmc.mc_id"
			+ " AND vrfm.id = ?"
			+ " AND vrft.latitude > ?" + " AND vrft.latitude < ?"
			+ " AND vrft.longitude > ?" + " AND vrft.longitude< ?"
			+ " GROUP BY vrft.id";
	
	public static final String SQL_005_2 = "SELECT " 
			+ "	srt.id,"
			+ "	u.nick_name AS user_name ,"
			+ "	srt.latitude,"
			+ "	srt.longitude,"
			+ "	srt.id,"
			+ "	rmc.car_name AS car_model "
			+ " FROM view_rescuemechanic vrm"
			+ " JOIN rescuemechanic_vs_car rmc ON rmc.mc_id = vrm.id"
			+ " JOIN view_selectable_rescuetask srt ON srt.car_id = rmc.car_id"
			+ " JOIN rescuemechanic_vs_rescuetype rmr ON  rmr.mc_id =vrm.id"
			+ " JOIN `user` u ON u.id = srt.user_id" + " AND vrm.id = ?"
			+ " AND srt.latitude > ?" + " AND srt.latitude < ?"
			+ " AND srt.longitude > ?" + " AND srt.longitude< ?"
			+ "GROUP BY srt.id;";
	//InterFaceName_009_1 ----selelct_bid--技工抢单
	public static final String SQL_009_1 = "SELECT"
			+ "	id"
			+ " FROM"
			+ " bid"
			+ " WHERE"
			+ "	`status` > 0"
			+ " AND mc_id = ?"
			+ " AND task_id = ?";
	
	
	//InterFaceName_009_2 ----upload_bid--技工抢单
	public static final String SQL_009_2 = "UPDATE "
			+ " bid "
			+ "	SET "
			+ " `status` = 1,price = ?"
			+ "	WHERE mc_id = ? "
			+ " AND `status` = 0 "
			+ " AND task_id = ?";

	public static final String SQL_011_1 = "SELECT"
			+ "	rfm.id,"
			+ "	rfm.`name`,"
			+ "	rfm.latitude,"
			+ "	rfm.longitude,"
			+ "	rfm.star,"
			+ "	urfb.price,"
			+ "	urfb.bid_id"
			+ " FROM"
			+ " view_refitmechanic rfm"
			+ " JOIN unsuccess_refitbid urfb ON urfb.mc_id = rfm.id"
			+ " AND urfb.task_id = ?";  
	
	public static final String SQL_012_1 = "SELECT"
			+ "	rm.id,"
			+ "	rm.`name`,"
			+ "	rm.latitude,"
			+ "	rm.longitude,"
			+ "	rm.star,"
			+ "	urb.price,"
			+ "	urb.bid_id"
			+ " FROM"
			+ " view_rescuemechanic rm"
			+ " JOIN unsuccess_rescuebid urb ON urb.mc_id = rm.id"
			+ " AND urb.task_id = ?";  
	
	public static final String SQL_013_1 = "SELECT"
			+ "	m.*,"
			+ "	b.price "
			+ " FROM"
			+ "	mechanic m"
			+ " JOIN bid b ON b.mc_id = m.id"
			+ " AND b.`status` = 1"
			+ " AND b.id = ? ;";
	//-----------------------
	/**
	 * 由bid_id求task_id
	 */
	public static final String SQL_014_0 = "SELECT"
			+ "	task_id"
			+ " FROM"
			+ "	bid"
			+ " WHERE"
			+ "	id = ?;";
	/**
	 * 由task_id求 bid_id 判断是否已经选择技工
	 */
	public static final String SQL_014_1 = "SELECT"
			+ "	id"
			+ " FROM"
			+ "	bid"
			+ " WHERE"
			+ "	task_id = ?"
			+ " AND `status` = 2;";
	/**
	 * 判断技工是否已被选则
	 */
	public static final String SQL_014_2 = "SELECT"
			+ "	id"
			+ " FROM"
			+ "	bid"
			+ " WHERE"
			+ "	id = ?"
			+ " AND `status` = 2;";
	/**
	 * 更新数据
	 */
	public static final String SQL_014_3 = "UPDATE "
			+ "	bid"
			+ " SET"
			+ "	`status` = 2"
			+ " WHERE"
			+ "	id = ? ;";
	
	//-------------15------------
	/**
	 */
	public static final String SQL_015_1 = "SELECT"
			+ "	u.id,"
			+ "	u.nick_name,"
			+ "	t.latitude,"
			+ "  t.longitude,"
			+ "	b.id,"
			+ "	cb.`name`"
			+ " FROM"
			+ "	`user` u"
			+ " JOIN task t ON t.user_id = u.id"
			+ " JOIN car c ON c.user_id = t.user_id"
			+ " JOIN carbrand cb ON cb.id = c.series_id"
			+ " JOIN bid b ON b.task_id = t.id"
			+ " JOIN mechanic m ON m.id = b.mc_id"
			+ " AND m.id = ?"
			+ " AND b.`status` = 2"
			+ " GROUP BY u.id;";
	//-------------16------------
	/**
	 * 确认服务
	 */
	public static final String SQL_016_1 = "UPDATE "
			+ "	bid"
			+ " SET"
			+ " `status` = 3"
			+ " WHERE"
			+ " id = ?";
	/**
	 * 添加refitbid
	 */
	
	public static final String SQL_016_2 = "";
	/**
	 * 添加rescuebid
	 */
	public static final String SQL_016_3 = "";
	/**
	 * 删除bid
	 */
	public static final String SQL_016_4 = "DELETE "
			+ "FROM "
			+ "bid "
			+ "WHERE task_id = ? "
			+ "AND id != ? ;";
	/**
	 *取消服务
	 */
	public static final String SQL_016_5 = "UPDATE "
			+ "	bid"
			+ " SET"
			+ " `status` = 3"
			+ " WHERE"
			+ " id = ?";
	
	//-------------------------2015-4-15 20:09:46
		//-------------------------17----------start-------------
		/**
		 * InterFaceName_017_1--interface_017_1_select_bid--查看是否已提交申请
		 */
		public static final String SQL_017_1 = "SELECT"
				+ "	id"
				+ " FROM"
				+ "	bid"
				+ " WHERE"
				+ "	`status` = 4"
				+ " AND id = ?;";
		/**
		 * interface_017_2_bid_finished_mec---将任务变为 技工申请状态
		 */
		public static final String SQL_017_2 = "UPDATE "
				+ "	bid"
				+ " SET"
				+ "	`status` = 4"
				+ " WHERE"
				+ "	id = ?;";
		
		//-------------------------17----------end-------------
		
		//*****************************
		//-------------------------18----------start-------------
		
		/**
		 * InterFaceName_018_1--bid_unfinished_user----任务未完成
		 */
		public static final String SQL_018_1 = "UPDATE "
				+ "	bid"
				+ " SET"
				+ "	`status` = 3"
				+ " WHERE"
				+ "	id = ?;";
		/**
		 * InterFaceName_018_2--bid_finished_user----任务完成
		 */
		public static final String SQL_018_2 = "UPDATE "
				+ "	bid"
				+ " SET"
				+ "	`status` = 5"
				+ " WHERE"
				+ "	id = ?;";
		
		//-------------------------18----------end-------------

		//-------------------------19----------star-------------
		
		/**
		 * InterFaceName_019--submit_comment--用户评价
		 */
		public static final String SQL_019_1 = "INSERT INTO"
				+ " bidcomment"
				+ "	(bid_id, date, star, content)"
				+ " VALUES"
				+ "	(?, NOW(), ?, ?);";

		//-------------------------19----------end-------------
		
		//-------------------------20----------star-------------
		
		/**
		 * InterFaceName_020--cancel_bid_user--用户取消发布的任务
		 * 查询
		 */
		public static final String SQL_020_1 = "SELECT "
				+ "id"
				+ " FROM"
				+ " bid"
				+ " WHERE"
				+ " `status` = -1"
				+ " AND id = ?;";
		/**
		 * InterFaceName_020--cancel_bid_user--用户取消发布的任务
		 * 更新
		 */
		public static final String SQL_020_2 = "UPDATE "
				+ "	bid"
				+ " SET"
				+ "	`status` = -1"
				+ " WHERE"
				+ "	id = ?;";
		
		//-------------------------20----------end-------------
		//-------------------------21----------star-------------
		
		/**
		 * InterFaceName_021--cancel_bid_mec--技工取消发布的任务 
		 * 查询
		 */
		public static final String SQL_021_1 = "SELECT "
				+ "id"
				+ " FROM"
				+ " bid"
				+ " WHERE"
				+ " `status` = -2"
				+ " AND id = ?;";
		/**
		 * InterFaceName_021--cancel_bid_mec--技工取消发布的任务 
		 * 更新
		 */
		public static final String SQL_021_2 = "UPDATE "
				+ "	bid"
				+ " SET"
				+ "	`status` = -2"
				+ " WHERE"
				+ "	id = ?;";
		
		//-------------------------21----------end-------------
		//*********************************************
		//-------------------------22----------star-------------
		/**
		 * InterFaceName_022_3--cancel_task_user--搜索task
		 */
		public static final String SQL_022_1 ="SELECT"
				+ " id"
				+ " FROM"
				+ " task"
				+ " WHERE"
				+ " `status` = -1"
				+ " AND id = ? ;";
		
		/**
		 * InterFaceName_022_1--cancel_task_user--更新task
		 */
		public static final String SQL_022_2 ="UPDATE "
				+ "task"
				+ " SET"
				+ " `status` = -1"
				+ " WHERE"
				+ " id = ? ;";
		/**
		 * InterFaceName_022_2--cancel_task_user--更新bid
		 */
		public static final String SQL_022_3 = "UPDATE "
				+ "	bid"
				+ " SET"
				+ "	`status` = -3"
				+ " WHERE"
				+ "	task_id  = ?;";
		
		
		//-------------------------22----------end-------------
		//-------------------------23----------start-------------
		/**
		 * InterFaceName_023_1--get_refit_mechanics--打开软件时，默认加载附近的技工（车改
		 */
		public static final String SQL_023_1 ="SELECT"
				+ "	vrm.id,"
				+ "	vrm.`name`,"
				+ "	vrm.latitude,"
				+ "	vrm.longitude"
				+ " FROM"
				+ "	view_refitmechanic vrm"
				+ " WHERE"
				+ "	vrm.latitude > ?"
				+ " AND vrm.latitude < ?"
				+ " AND vrm.longitude > ?"
				+ " AND vrm.longitude < ?;";
		/**
		 * InterFaceName_023_2--get_rescue_mechanics--打开软件时，默认加载附近的技工（救援
		 */
		public static final String SQL_023_2 ="SELECT"
				+ "	vrm.id,"
				+ "	vrm.`name`,"
				+ "	vrm.latitude,"
				+ "	vrm.longitude"
				+ " FROM"
				+ "	view_rescuemechanic vrm"
				+ " WHERE"
				+ "	vrm.latitude > ?"
				+ " AND vrm.latitude < ?"
				+ " AND vrm.longitude > ?"
				+ " AND vrm.longitude < ?;";
		
		//-------------------------23----------end-------------
		//*****************************
		//------------InterFaceName_024----------start-------------
		/**
		 * InterFaceName_025--update_location---更新技工的位置
		 */
		public static final String SQL_024_1 ="UPDATE"
				+ " mechanic"
				+ " SET"
				+ " latitude = ? ,longitude = ?"
				+ " WHERE"
				+ " id = ?;";
		//------------InterFaceName_024----------end-------------
		//*****************************
		//------------InterFaceName_025----------end-------------
		public static final String SQL_025_1 ="SELECT "
				+ "id,"
				+ "nick_name,"
				+ "phone,"
				+ "home_address,"
				+ "photo "
				+ " FROM"
				+ " `user`"
				+ " WHERE id = ?";
		
		//------------InterFaceName_025----------end-------------
		//*****************************
		//------------InterFaceName_026----------start-------------
		public static final String SQL_026_1 = "SELECT"
				+ "	u.id,"
				+ "	u.nick_name,"
				+ "	t.latitude,"
				+ " t.longitude,"
				+ "	b.id,"
				+ "	cb.`name`,"
				+ " u.phone,"
				+ " t.id"
				+ " FROM"
				+ "	`user` u"
				+ " JOIN task t ON t.user_id = u.id"
				+ " JOIN car c ON c.user_id = t.user_id"
				+ " JOIN carbrand cb ON cb.id = c.series_id"
				+ " JOIN bid b ON b.task_id = t.id"
				+ " JOIN mechanic m ON m.id = b.mc_id"
				+ " AND m.id = ?"
				+ " AND b.`status` = 3"
				+ " GROUP BY u.id;";
		//------------InterFaceName_026----------end-------------
		//*****************************
		//------------InterFaceName_027----------start-------------
		/**
		 *InterFaceName_027   基本信息
		 */
		public static final String SQL_027_1 = "SELECT * FROM mc_finished_bids WHERE mc_id = ?;";
		/**
		 * 品论
		 */
		public static final String SQL_027_2 = "SELECT"
				+ "	bc.date,"
				+ "	bc.star,"
				+ "	bc.`comment`"
				+ " FROM"
				+ "	mechanic m"
				+ " JOIN bid b ON b.mc_id = m.id"
				+ " JOIN bidcomment bc ON bc.bid_id = b.id"
				+ " AND b.`status` = 5"
				+ " AND m.id = ?"
				+ " GROUP BY date DESC"
				+ " LIMIT 0,"
				+ " 3;";//分页----三条为一页
		
		
		//------------InterFaceName_027----------end-------------
		//*****************************
		//------------InterFaceName_028----------start-------------
		/**
		 * 车改技工
		 */
		public static final String SQL_028_1 = "SELECT "
				+ "	m.id,"
				+ "	m.name,"
				+ "	m.phone_num,"
				+ "	m.pic_url"
				+ " FROM"
				+ " mechanic m"
				+ " JOIN refitmechanic rfc ON rfc.id = m.id"
				+ " AND m.id = ? ;";
		/**
		 * 救援技工
		 */
		public static final String SQL_028_2 = "SELECT "
				+ "	m.id,"
				+ "	m.name,"
				+ "	m.phone_num,"
				+ "	m.pic_url"
				+ " FROM"
				+ " mechanic m"
				+ " JOIN rescuemechanic rfc ON rfc.id = m.id"
				+ " AND m.id = ? ;";
		/**
		 * 救援类型
		 */
		public static final String SQL_028_3 = "SELECT"
				+ "	rt.`name`"
				+ " FROM"
				+ "	rescuetype rt"
				+ " JOIN rescue_rescuetype rr ON rr.rescue_type = rt.id"
				+ " WHERE rr.mc_id = ? ;";
		//------------InterFaceName_028----------end-------------
		//*****************************
		//------------InterFaceName_029----------start-------------
		/**
		 * 
		 */
		public static final String SQL_029_1 = "SELECT "
				+ "*"
				+ " FROM"
				+ " car_brand_seriesName;";
		//------------InterFaceName_028----------end-------------
		//*****************************
}
