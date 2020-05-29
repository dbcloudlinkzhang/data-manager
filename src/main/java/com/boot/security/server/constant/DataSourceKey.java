package com.boot.security.server.constant;


/**
 * 主数据数据库
 * @author Administrator
 *
 */
public enum DataSourceKey {
	CONVERT("convert"),//主数据库，转换数据库
	RILL("rill"),      //rill数据库
	ZWPT("zwpt");      //上报数据库
	
	private String name;
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	private DataSourceKey(String name) {
		this.name = name;
	}
}