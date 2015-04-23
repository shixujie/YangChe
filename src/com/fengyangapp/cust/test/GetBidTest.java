package com.fengyangapp.cust.test;

import org.junit.Test;

import com.fengyangapp.service.impl.CustServiceImpl;

public class GetBidTest {

	Object[] objects = new Object[] { null };

	CustServiceImpl service = new CustServiceImpl();

	@Test
	public void Test1() {
		// object 为空
		service.get_bid(null);
	}

	@Test
	public void Test2() {
		// task_id 为空
		service.get_bid(objects);
	}

	@Test
	public void Test3() {
		// 全部参数
		objects[0] = 17;
		service.get_bid(objects);
	}
}
