package com.fengyangapp.cust.test;

import org.junit.Test;

import com.fengyangapp.cust.dao.imql.GetRefitMerchanicsCoorsDaoImpl;

/**
 * @context 描述：InterFaceName_003----test
 * @author 史旭杰
 * @version 创建时间：2015年4月18日 下午1:53:07
 */
public class GetRefitMerchanicsCoorsTest {

	Object[] objects = new Object[] { null };
	GetRefitMerchanicsCoorsDaoImpl dao = new GetRefitMerchanicsCoorsDaoImpl();
	@Test
	public void Test1() {
		//object 为空
		dao.get_refit_merchanics_coors(null);
	}

	@Test
	public void Test2() {
		//task_id 为空
		dao.get_refit_merchanics_coors(objects);
	}

	@Test
	public void Test3() {
		//全部参数
		objects[0] = 27;
		dao.get_refit_merchanics_coors(objects);
	}
}
