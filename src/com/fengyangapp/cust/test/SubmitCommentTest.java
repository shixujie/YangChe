package com.fengyangapp.cust.test;

import com.fengyangapp.test.CustTest;

public class SubmitCommentTest extends CustTest {

	// Object o0 = objects[0];// bid_id任务编号
	// Object o1 = objects[1];// star
	// Object o2 = objects[2];// 评论内容comment
	@Override
	public void Test1() {
		// TODO Auto-generated method stub
		// objects 为空
		service.submit_comment(null);
	}

	@Override
	public void Test2() {
		// TODO Auto-generated method stub
		// bid_id任务编号 为空
		service.submit_comment(objects_3);
	}

	@Override
	public void Test3() {
		// TODO Auto-generated method stub
		// star 为空
		objects_3[0] = 1;
		service.submit_comment(objects_3);
	}

	@Override
	public void Test4() {
		// TODO Auto-generated method stub
		// comm 为空
		objects_3[0] = 1;
		objects_3[1] = 1.0;
		service.submit_comment(objects_3);
	}

	@Override
	public void Test5() {
		// TODO Auto-generated method stub
		objects_3[0] = 1;
		objects_3[1] = 1.0;
		objects_3[2] = "满意";
		service.submit_comment(objects_3);
	}
}
