package com.fengyangapp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @context 描述：InterFaceName_027---get_finished_bids-已完成的订单
 * @author 史旭杰
 * @version 创建时间：2015年4月20日 下午6:11:33
 */
public class BidBaseInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer user_id;
	private String user_name;// 车型
	private double latitude;
	private double longitude;
	private Integer task_id;// 任务编号
	private String car_model;// 车型
	private Integer bid_id;
	private String date;
	private double price;

	public BidBaseInfo() {}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Integer getTask_id() {
		return task_id;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	public String getCar_model() {
		return car_model;
	}

	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}

	public Integer getBid_id() {
		return bid_id;
	}

	public void setBid_id(Integer bid_id) {
		this.bid_id = bid_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
