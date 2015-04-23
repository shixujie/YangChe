package com.fengyangapp.mech.test;

import org.junit.Test;

import com.fengyangapp.service.impl.MechServiceImpl;

public class AcceptBidTest {

	Object[] objects = new Object[] { null, null };
	MechServiceImpl service = new MechServiceImpl();

	@Test
	public void Test1() {
		// object 为空
		service.accept_bid(null);
	}

	@Test
	public void Test2() {
		// bid_id 为空
		service.accept_bid(objects);
	}

	@Test
	public void Test3() {
		// is_accept 为空
		objects[0] = 2;// bid_id
		service.accept_bid(objects);
	}

	@Test
	public void Test4() {
		// 参数正确
		objects[0] = 25;// bid_id
		objects[1] = "1";// is_accept
		service.accept_bid(objects);
	}

	@Test
	public void Test5() {

	}

}
