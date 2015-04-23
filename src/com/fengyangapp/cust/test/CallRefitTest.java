package com.fengyangapp.cust.test;

import org.junit.Test;

import com.fengyangapp.entity.Task;
import com.fengyangapp.service.impl.CustServiceImpl;
/**
 * @context 描述：InterFaceName_001 Test
 * @author 史旭杰
 * @version 创建时间：2015年4月18日 上午11:43:38
 */
public class CallRefitTest {

	CustServiceImpl service = new CustServiceImpl();
	Task task = new Task();
	@Test
	public void Test1(){
		//object为空
		service.call_refit(null);
	}
	@Test
	public void Test2(){
		//user_id为空
		service.call_refit(task);
	}
	@Test
	public void Test3(){
		//位置为空
		task.setUser_id(1);
		service.call_refit(task);
	}
	@Test
	public void Test4(){
		//car_id为空
		task.setUser_id(1);
		task.setLatitude(39.981351);
		task.setLongitude(116.303167);
		
		service.call_refit(task);
	}
	@Test
	public void Test5(){
		task.setUser_id(9);
		task.setLatitude(116.303167);
		task.setLongitude(39.981351);
		task.setCar_id(1);
		service.call_refit(task);
	}
	@Test
	public void Test6(){
		service.call_refit(task);
	}
}
