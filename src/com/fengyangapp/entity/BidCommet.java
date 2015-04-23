package com.fengyangapp.entity;

import java.io.Serializable;

/**
 * @context 描述：用户的评论
 * @author 史旭杰
 * @version 创建时间：2015年4月20日 下午6:09:12
 */
public class BidCommet implements Serializable {

	private static final long serialVersionUID = 1L;

	private double star;
	private String date;
	private String comment;

	public BidCommet() {
	}

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
