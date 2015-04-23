package com.fengyangapp.cust.test;

import org.junit.Test;

import com.fengyangapp.cust.dao.imql.GetMechanicsDaoImpl;
/**
 * GetMechanicsTest
 * @author 史旭杰
 * 2015-4-18 10:35:10
 */
public class GetMechanicsTest {

	Object o0 = 39.981351;
	Object o1 = 116.303167;
	Object [] object = null;
	GetMechanicsDaoImpl dao = new GetMechanicsDaoImpl();
	@Test
	public void test1() {
		//无参数时
		Object [] object = new Object[]{};
		dao.get_mechanics(object);
	}
	@Test
	public void test2() {
		//只有lat时
		 object = new Object[]{o0,null};
		dao.get_mechanics(object);
	}
	@Test
	public void test3() {
		//参数正确时
		Object [] object = new Object[]{o0,o1};
		dao.get_mechanics(object);
	}
}
