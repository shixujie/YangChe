package com.fengyangapp.dao;

import com.fengyangapp.dao.imql.CustJspDB;
import com.fengyangapp.utils.InterFaceName;

public interface CustDao{

	String count = InterFaceName.COUNT;
	CustJspDB custJsp = new CustJspDB();
	String task_id = InterFaceName.TASK_ID;
	String mechanicList = InterFaceName.mechanicList;
//	String refit_task = InterFaceName.refit_task;
//	String rescue_task = InterFaceName.rescue_task;
	String refitList = InterFaceName.refit_task;
	String rescueList = InterFaceName.rescue_task;
	String userInfo = InterFaceName.userInfo;

}
