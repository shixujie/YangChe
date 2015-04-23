package com.fengyangapp.cust.test;

import org.junit.Test;

import com.fengyangapp.service.impl.CustServiceImpl;
/**
 * @context 描述：InterFaceName_007----is_available_merchanics_rescue--在用户提交订单后，
 *          用户可查看是否有车改技工抢单
 * @author 史旭杰
 * @version 创建时间：2015年4月18日 下午5:02:23
 */
public class IsAvailableMerchanicsRescueTest {

Object[] objects = new Object[] { null };
	
	CustServiceImpl service = new CustServiceImpl();

	@Test
	public void Test1() {
		// object 为空
		service.is_available_merchanics_rescue(null);
	}

	@Test
	public void Test2() {
		// task_id 为空
		service.is_available_merchanics_rescue(objects);
	}

	@Test
	public void Test3() {
		// 全部参数
		objects[0] = 10;
		service.is_available_merchanics_rescue(objects);
	}
}
