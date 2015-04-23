package com.fengyangapp.mech.test;

import com.fengyangapp.test.MechTest;

public class UpdateLocationTest extends MechTest{

	@Override
	public void Test1() {
		// TODO Auto-generated method stub
		service.update_location(null);
	}
	@Override
	public void Test2() {
		// TODO Auto-generated method stub
		//mc_id 为空
		service.update_location(objects_3);
	}
	@Override
	public void Test3() {
		// TODO Auto-generated method stub
		//lat 为空
		objects_3[0] = 1;
		service.update_location(objects_3);
	}
	@Override
	public void Test4() {
		// TODO Auto-generated method stub
		objects_3[0] = 1;
		objects_3[1] = 1;
		objects_3[2] = 1;
		service.update_location(objects_3);
	}
	@Override
	public void Test5() {
		// TODO Auto-generated method stub
		service.update_location(objects_3);
	}
}
