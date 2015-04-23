package com.fengyangapp.entity;

import java.io.Serializable;

public class InterFace_013 implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Integer mc_id;
	private String mc_name;// 车型
	private String phone_num;// 车型
	private double latitude;
	private double longitude;
	private double star;
	private double price;
	private Integer bid_id;// 任务编号
	
	public InterFace_013() {
	}

	/**
	 * 技工信息（id,name,lat,lon,star,price,bid_id）
	 * @param mc_id
	 * @param mc_name
	 * @param latitude
	 * @param longitude
	 * @param star
	 * @param price
	 * @param bid_id
	 */
	public InterFace_013(Integer mc_id,String mc_name,String phone_num, double latitude, double longitude,double star,double price,Integer bid_id) {
		this.mc_id = mc_id;
		this.mc_name = mc_name;
		this.phone_num = phone_num;
		this.latitude = latitude;
		this.longitude = longitude;
		this.star = star;
		this.price = price;
		this.bid_id = bid_id;
	}

	public Integer getMc_id() {
		return mc_id;
	}

	public void setMc_id(Integer mc_id) {
		this.mc_id = mc_id;
	}

	public String getMc_name() {
		return mc_name;
	}

	public void setMc_name(String mc_name) {
		this.mc_name = mc_name;
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

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getBid_id() {
		return bid_id;
	}

	public void setBid_id(Integer bid_id) {
		this.bid_id = bid_id;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	
	
}
