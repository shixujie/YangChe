package com.fengyangapp.dao;

import com.fengyangapp.dao.imql.MechJspDB;
import com.fengyangapp.utils.InterFaceName;

public interface MechDao {

	MechJspDB mechJsp = new MechJspDB();
	String userList = InterFaceName.userList;
	String refit_task = InterFaceName.refit_task;
	String rescue_task = InterFaceName.rescue_task;
	String count = InterFaceName.COUNT;
	String mechInfo = InterFaceName.mechInfo;
	String carList = InterFaceName.carList;
	
}
