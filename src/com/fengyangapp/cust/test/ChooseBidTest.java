package com.fengyangapp.cust.test;

import org.junit.Test;

import com.fengyangapp.service.impl.CustServiceImpl;

public class ChooseBidTest {


	Object[] objects = new Object[] { null };

	CustServiceImpl service = new CustServiceImpl();

	@Test
	public void Test1() {
		// object 为空
		service.choose_bid(null);
	}

	@Test
	public void Test2() {
		// bid_id 为空
		service.choose_bid(objects);
	}

	@Test
	public void Test3() {
		// 全部参数
		objects[0] = 17;
		service.choose_bid(objects);
	}
}
