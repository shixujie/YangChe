package com.fengyangapp.utils;

import net.sf.json.JSONObject;

public class DataUtil {
	private  JSONObject requestJson;
	private static ThreadLocal<JSONObject> tl = new ThreadLocal<JSONObject>();
	
	public JSONObject getRequestJson() {
		return requestJson;
	}
	public void setRequestJson(JSONObject requestJson) {
		this.requestJson = requestJson;
	}
	public ThreadLocal<JSONObject> getTl() {
		return tl;
	}
	public void setTl(ThreadLocal<JSONObject> tl) {
		this.tl = tl;
	}
	
}
