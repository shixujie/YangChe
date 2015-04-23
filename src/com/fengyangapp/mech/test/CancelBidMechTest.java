package com.fengyangapp.mech.test;

import com.fengyangapp.test.MechTest;

public class CancelBidMechTest extends MechTest{

	@Override
	public void Test1() {
		// TODO Auto-generated method stub
		service.cancel_bid_mec(null);
	}
	
	@Override
	public void Test2() {
		// TODO Auto-generated method stub
		//bid_id 为空
		service.cancel_bid_mec(objects_1);
	}
	
	@Override
	public void Test3() {
		// TODO Auto-generated method stub
		objects_1[0] = 17;
		service.cancel_bid_mec(objects_1);
	}
}
