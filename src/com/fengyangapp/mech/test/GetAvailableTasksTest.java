package com.fengyangapp.mech.test;

import org.junit.Test;

import com.fengyangapp.service.impl.MechServiceImpl;

public class GetAvailableTasksTest {

	Object[] objects = new Object[] { null };
	MechServiceImpl service = new MechServiceImpl();

	@Test
	public void Test1() {
		// object 为空
		service.get_available_tasks(null);
	}

	@Test
	public void Test2() {
		// task_id 为空
		service.get_available_tasks(objects);
	}

	@Test
	public void Test3() {
		// 全部参数
		objects[0] = 7;
		service.get_available_tasks(objects);
	}
}
