package com.fengyangapp.entity;

import java.io.Serializable;

/**
 * @context 描述：InterFaceName_028--基本信息获取 --用到
 * @author 史旭杰
 * @version 创建时间：2015年4月21日 上午11:58:45
 */
public class MechModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer mc_id;
	private String mc_name;
	private String phone_num;
	private String pic_url;
	private String mc_type;
	private String rescue_type;

	public MechModel() {
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

	public String getMc_type() {
		return mc_type;
	}

	public void setMc_type(String mc_type) {
		this.mc_type = mc_type;
	}

	public String getRescue_type() {
		return rescue_type;
	}

	public void setRescue_type(String rescue_type) {
		this.rescue_type = rescue_type;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

}
