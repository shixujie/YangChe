package com.fengyangapp.cust.test;

import com.fengyangapp.test.CustTest;

public class GetUserInfoTest extends CustTest {

	@Override
	public void Test1() {
		// TODO Auto-generated method stub
		service.get_user_info(null);
	}

	public void Test2() {
		// TODO Auto-generated method stub
		service.get_user_info(objects_1);
	}

	public void Test3() {
		// TODO Auto-generated method stub
		objects_1[0] = 9;
		service.get_user_info(objects_1);
	}
}
