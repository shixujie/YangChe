package com.fengyangapp.cust.test;

import org.junit.Test;

import com.fengyangapp.entity.Task;
import com.fengyangapp.service.impl.CustServiceImpl;
/**
 * @context 描述：InterFaceName_001 Test
 * @author 史旭杰
 * @version 创建时间：2015年4月18日 上午11:43:38
 */
public class CallRescueTest {

	CustServiceImpl service = new CustServiceImpl();
	Task task = new Task();
	
	Object[] objects = new Object[]{null,null,null,null,null};
	@Test
	public void Test1(){
		//object为空
		service.call_rescue(null);
	}
	@Test
	public void Test3(){
		//位置为空
		objects[0] = 9;
		service.call_rescue(objects);
	}
	@Test
	public void Test4(){
		//car_id为空
		objects[0] = 9;
		objects[1] = 39.975598;
		objects[2] = 116.318646;
		service.call_rescue(objects);
	}
	@Test
	public void Test5(){
		//rescue_type 为空
		objects[0] = 12;
		objects[1] = 39.975598;
		objects[2] = 116.318646;
		objects[3] = 1;
		service.call_rescue(objects);
	}
	@Test
	public void Test6(){
		//参数正确
		objects[0] = 12;
		objects[1] = 39.975598;
		objects[2] = 116.318646;
		objects[3] = 1;
		objects[4] = 1;
		service.call_rescue(objects);
	}
}
