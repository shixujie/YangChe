package com.fengyangapp.entity;

import java.io.Serializable;

/**
 * @context 描述： * InterFaceName_001---- 添加task时用到
 * @author 史旭杰
 * @version 创建时间：2015年4月18日 上午11:25:32
 */
public class Task implements Serializable{

	private static final long serialVersionUID = 1L;

	private Object user_id;
	private Object latitude;
	private Object longitude;
	private Object car_id;
	
	public Task() {
	}

	public Object getUser_id() {
		return user_id;
	}

	public void setUser_id(Object user_id) {
		this.user_id = user_id;
	}

	public Object getLatitude() {
		return latitude;
	}

	public void setLatitude(Object latitude) {
		this.latitude = latitude;
	}

	public Object getLongitude() {
		return longitude;
	}

	public void setLongitude(Object longitude) {
		this.longitude = longitude;
	}

	public Object getCar_id() {
		return car_id;
	}

	public void setCar_id(Object car_id) {
		this.car_id = car_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
