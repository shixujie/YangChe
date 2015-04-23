package com.fengyangapp.mech.test;

import org.junit.Test;

import com.fengyangapp.service.impl.MechServiceImpl;

public class BidFinishedMecTest {

	Object[] objects = new Object[] { null };
	MechServiceImpl service = new MechServiceImpl();

	@Test
	public void Test1() {
		// object 为空
		service.bid_finished_mec(null);
	}

	@Test
	public void Test2() {
		// bid_id 为空
		service.bid_finished_mec(objects);
	}

	@Test
	public void Test3() {
		// 全部参数
		objects[0] = 17;
		service.bid_finished_mec(objects);
	}
}
