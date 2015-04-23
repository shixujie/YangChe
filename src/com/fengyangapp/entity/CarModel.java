package com.fengyangapp.entity;

import java.io.Serializable;

/**
 * @context 描述：
 * @author 史旭杰
 * @version 创建时间：2015年4月21日 下午3:21:48
 */
public class CarModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer series_id;
	private String series_name;// 车系
	private String pic_url;// 车的图片

	public CarModel() {
	}

	public Integer getSeries_id() {
		return series_id;
	}

	public void setSeries_id(Integer series_id) {
		this.series_id = series_id;
	}

	public String getSeries_name() {
		return series_name;
	}

	public void setSeries_name(String series_name) {
		this.series_name = series_name;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

}
