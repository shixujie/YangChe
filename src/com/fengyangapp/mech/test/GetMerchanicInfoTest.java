package com.fengyangapp.mech.test;

import com.fengyangapp.test.MechTest;

public class GetMerchanicInfoTest extends MechTest{

	@Override
	public void Test1() {
		// TODO Auto-generated method stub
		service.get_merchanic_info(null);
	}
	@Override
	public void Test2() {
		// TODO Auto-generated method stub
		service.get_merchanic_info(objects_1);
	}
	@Override
	public void Test3() {
		// TODO Auto-generated method stub
		objects_1[0]= 1;//车改技工
		service.get_merchanic_info(objects_1);
	}
	@Override
	public void Test4() {
		// TODO Auto-generated method stub
		objects_1[0]= 2;//救援技工
		service.get_merchanic_info(objects_1);
	}
	@Override
	public void Test5() {
		// TODO Auto-generated method stub
		objects_1[0]= 3;//车改 和救援技工
		service.get_merchanic_info(objects_1);
	}
}
