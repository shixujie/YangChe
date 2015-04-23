package com.fengyangapp.cust.test;

import org.junit.Test;

import com.fengyangapp.service.impl.CustServiceImpl;

/**
 * @context 描述： InterFaceName_006----is_available_merchanics_refit用户可查看是否有车改技工抢单
 * @author 史旭杰
 * @version 创建时间：2015年4月18日 下午5:01:34
 */
public class IsAvailableMerchanicsRefitTest {

	Object[] objects = new Object[] { null };

	CustServiceImpl service = new CustServiceImpl();

	@Test
	public void Test1() {
		// object 为空
		service.is_available_merchanics_refit(null);
	}

	@Test
	public void Test2() {
		// task_id 为空
		service.is_available_merchanics_refit(objects);
	}

	@Test
	public void Test3() {
		// 全部参数
		objects[0] = 30;
		service.is_available_merchanics_refit(objects);
	}
}
