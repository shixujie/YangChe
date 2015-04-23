package com.fengyangapp.entity;

import java.io.Serializable;

/**
 * @context 描述：用户的基本信息
 * @author 史旭杰
 * @version 创建时间：2015年4月19日 下午11:08:09
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer user_id;
	private String user_name;// 车型
	private Integer task_id;// 任务编号
	private String phone;// 
	private String home_address;// 
	private String photo;// 
	
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
	public Integer getTask_id() {
		return task_id;
	}
	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHome_address() {
		return home_address;
	}
	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
