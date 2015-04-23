package com.fengyangapp.mech.test;

import org.junit.Test;

import com.fengyangapp.service.impl.MechServiceImpl;

public class UploadBidTest {
	Object[] objects = new Object[] { null, null, null };
	MechServiceImpl service = new MechServiceImpl();

	@Test
	public void Test1() {
		// object 为空
		service.upload_bid(null);
	}

	@Test
	public void Test2() {
		// mc_id 为空
		service.upload_bid(objects);
	}

	@Test
	public void Test3() {
		// task_id 为空
		objects[0] = 2;// mc_id
		service.upload_bid(objects);
	}

	@Test
	public void Test4() {
		// price 为空
		objects[0] = 2;// mc_id
		objects[1] = 10;//task_id

		service.upload_bid(objects);
	}

	@Test
	public void Test5() {
		// 参数正确
		objects[0] = 2;// mc_id
		objects[1] = 30;//task_id
		objects[2] = 2;// price
		service.upload_bid(objects);
	}
}
