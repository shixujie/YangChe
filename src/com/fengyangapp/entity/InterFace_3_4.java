package com.fengyangapp.entity;

import java.io.Serializable;
/**
 * mc_id--mc_name--latitude--longitude
 * @author fengyang
 *
 */
public class InterFace_3_4 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer mc_id;
	private String mc_name;
	private double latitude;
	private double longitude;

	public InterFace_3_4() {
	}

	public InterFace_3_4(Integer mc_id, double latitude, double longitude,String mc_name) {
		this.mc_name = mc_name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.mc_id = mc_id;
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

	
}
