package com.fengyangapp.cust.test;

import org.junit.Test;

import com.fengyangapp.test.CustTest;

public class BidFinishedUserTest extends CustTest {

	// bid_id任务编号
	// is_finished任务编号
	@Override
	public void Test1() {
		// TODO Auto-generated method stub
		// objects_2 为空
		service.bid_finished_user(null);
	}

	@Override
	public void Test2() {
		// TODO Auto-generated method stub
		// bid_id任务编号 为空
		service.bid_finished_user(objects_2);
	}

	@Override
	public void Test3() {
		// TODO Auto-generated method stub
		// is_finished任务编号 为空
		objects_2[0] = 17; // bid_id任务编号
		service.bid_finished_user(objects_2);
	}

	@Override
	public void Test4() {
		// TODO Auto-generated method stub
		// 数据全说·
		objects_2[0] = 17; // bid_id任务编号
		objects_2[1] = 0; // is_finished任务编号

		service.bid_finished_user(objects_2);
	}

}
