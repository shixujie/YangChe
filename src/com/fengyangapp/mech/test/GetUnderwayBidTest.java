package com.fengyangapp.mech.test;

import com.fengyangapp.test.MechTest;

public class GetUnderwayBidTest extends MechTest {

	@Override
	public void Test1() {
		// TODO Auto-generated method stub
		service.get_underway_bid(null);
	}
	
	public void Test2() {
		// TODO Auto-generated method stub
		service.get_underway_bid(objects_1);
	}
	public void Test3() {
		objects_1[0] = 2;
		service.get_underway_bid(objects_1);
	}
}
