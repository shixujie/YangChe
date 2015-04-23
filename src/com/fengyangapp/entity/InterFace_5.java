package com.fengyangapp.entity;

import java.io.Serializable;

/**
 * 005和015
 * @author fengyang
 *
 */
public class InterFace_5 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer user_id;
	private String user_name;// 车型
	private double latitude;
	private double longitude;
	private Integer task_id;// 任务编号
	private String car_model;// 车型
	private Integer bid_id;
	private String phone ;

	public InterFace_5() {
	}

	/**
	 * 用户信息（id,name,lat,lon）.车型
	 * 
	 * @param id
	 * @param model
	 * @param entity
	 */
	public InterFace_5(Integer user_id,String user_name, double latitude, double longitude,String car_model) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.car_model = car_model;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
