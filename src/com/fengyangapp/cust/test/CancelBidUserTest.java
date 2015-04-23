package com.fengyangapp.cust.test;

import com.fengyangapp.test.CustTest;

public class CancelBidUserTest extends CustTest{

	@Override
	public void Test1() {
		// TODO Auto-generated method stub
		service.cancel_bid_user(null);
	}
	
	@Override
	public void Test2() {
		// TODO Auto-generated method stub
		//bid_id 为空
		service.cancel_bid_user(objects_1);
	}
	
	@Override
	public void Test3() {
		// TODO Auto-generated method stub
		objects_1[0] = 17;
		service.cancel_bid_user(objects_1);
	}
}
