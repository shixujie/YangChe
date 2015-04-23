package com.fengyangapp.utils;

public class InterFaceName {

	public static final String InterFaceName_001 = "customer/call_refit";
	public static final String InterFaceName_002 = "customer/call_rescue";
	public static final String InterFaceName_003 = "customer/get_refit_merchanics_coors";
	public static final String InterFaceName_004 = "customer/get_rescue_merchanics_coors";
	public static final String InterFaceName_005 = "mechanic/get_available_tasks";
	public static final String InterFaceName_006 = "customer/is_available_merchanics_refit";
	public static final String InterFaceName_007 = "customer/is_available_merchanics_rescue";
	public static final String InterFaceName_008 = "";
	public static final String InterFaceName_009 = "mechanic/upload_bid";
	public static final String InterFaceName_010 = "";
	public static final String InterFaceName_011 = "customer/get_refit_bids";
	public static final String InterFaceName_012 = "customer/get_rescue_bids";
	public static final String InterFaceName_013 = "customer/get_bid";
	public static final String InterFaceName_014 = "customer/choose_bid";
	public static final String InterFaceName_015 = "mechanic/get_success_bid";
	public static final String InterFaceName_016 = "mechanic/accept_bid";
	// --------------------2015-4-15 20:01:24
	public static final String InterFaceName_017 = "mechanic/bid_finished_mec";
	public static final String InterFaceName_018 = "customer/bid_finished_user";
	public static final String InterFaceName_019 = "customer/submit_comment";
	public static final String InterFaceName_020 = "customer/cancel_bid_user";
	public static final String InterFaceName_021 = "customer/cancel_bid_mec";
	public static final String InterFaceName_022 = "customer/cancel_task_user";
	public static final String InterFaceName_023 = "customer/get_merchanics";
	public static final String InterFaceName_024 = "mechanic/update_location";
	public static final String InterFaceName_025 = "customer/get_user_info";
	public static final String InterFaceName_026 = "mechanic/get_underway_bid";
	public static final String InterFaceName_027 = "mechanic/get_finished_bids";
	public static final String InterFaceName_028 = "mechanic/get_merchanic_info";
	public static final String InterFaceName_029 = "mechanic/get_car_model";
	//------------------end--------
	public static final String RESULT = "result";
	public static final String TASK_ID = "task_id";
	public static final String mechanicList = "mechanicList";
	public static final String userList = "userList";
	public static final String refit_task = "refit_task";
	public static final String rescue_task = "rescue_task";
	public static final String COUNT = "count";
	public static final String userInfo = "userInfo";
	public static final String bidList = "bidList";
	final String refitList = "refitList";
	final String rescueList = "rescueList";
	public final static String mechInfo = "mechInfo";
	public final static String carList = "carList";
	public static void main(String[] args) {

		for (int i = 0; i < 20; i++) {
			System.out.println("public static final String InterFaceName_00"
					+ i + "= '';");
		}
	}

}
