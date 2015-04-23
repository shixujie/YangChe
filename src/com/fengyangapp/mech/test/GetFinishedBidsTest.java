package com.fengyangapp.mech.test;

import com.fengyangapp.test.MechTest;

/**
 * @context 描述：InterFaceName_027---get_finished_bids-已完成的订单
 * @author 史旭杰
 * @version 创建时间：2015年4月20日 下午5:02:15
 */
public class GetFinishedBidsTest extends MechTest {

	@Override
	public void Test1() {
		// TODO Auto-generated method stub
		service.get_finished_bids(null);
	}

	@Override
	public void Test2() {
		// TODO Auto-generated method stub
		service.get_finished_bids(objects_1);
	}

	@Override
	public void Test3() {
		// TODO Auto-generated method stub
		objects_1[0] = 2;
		service.get_finished_bids(objects_1);
	}
}
