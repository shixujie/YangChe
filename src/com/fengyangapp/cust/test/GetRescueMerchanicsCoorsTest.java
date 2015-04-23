package com.fengyangapp.cust.test;

import org.junit.Test;

import sun.print.resources.serviceui;

import com.fengyangapp.cust.dao.imql.GetRefitMerchanicsCoorsDaoImpl;
import com.fengyangapp.cust.dao.imql.GetRescueMerchanicsCoorsDaoImpl;
import com.fengyangapp.service.impl.CustServiceImpl;

/**
 * @context 描述：InterFaceName_004----test
 * @author 史旭杰
 * @version 创建时间：2015年4月18日 下午1:53:07
 */
public class GetRescueMerchanicsCoorsTest {

	Object[] objects = new Object[] { null };
	
	CustServiceImpl service = new CustServiceImpl();

	@Test
	public void Test1() {
		// object 为空
		service.get_rescue_merchanics_coors(null);
	}

	@Test
	public void Test2() {
		// task_id 为空
		service.get_rescue_merchanics_coors(objects);
	}

	@Test
	public void Test3() {
		// 全部参数
		objects[0] = 30;
		service.get_rescue_merchanics_coors(objects);
	}
}
