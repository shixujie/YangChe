package com.fengyangapp.mech.test;

import org.junit.Test;

import com.fengyangapp.service.impl.MechServiceImpl;

public class GetSuccessBidTest {

	Object[] objects = new Object[] { null };
	MechServiceImpl service = new MechServiceImpl();

	@Test
	public void Test1() {
		// object 为空
		service.get_success_bid(null);
	}

	@Test
	public void Test2() {
		// mc_id 为空
		service.get_success_bid(objects);
	}

	@Test
	public void Test3() {
		// 全部参数
		objects[0] = 2;
		objects[0] = 4;
		service.get_success_bid(objects);
	}
}
