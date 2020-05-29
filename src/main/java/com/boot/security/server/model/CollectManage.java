package com.boot.security.server.model;



public class CollectManage extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String collectName;
	private String collectCode;
	private String collectAddress;
	private String collectAccount;
	private String collectPassword;
	private String collectIsAuth;
	private String collectApi;
	private String collectData;
	private String collectState;

	public String getCollectName() {
		return collectName;
	}
	public void setCollectName(String collectName) {
		this.collectName = collectName;
	}
	public String getCollectCode() {
		return collectCode;
	}
	public void setCollectCode(String collectCode) {
		this.collectCode = collectCode;
	}
	public String getCollectAddress() {
		return collectAddress;
	}
	public void setCollectAddress(String collectAddress) {
		this.collectAddress = collectAddress;
	}
	public String getCollectAccount() {
		return collectAccount;
	}
	public void setCollectAccount(String collectAccount) {
		this.collectAccount = collectAccount;
	}
	public String getCollectPassword() {
		return collectPassword;
	}
	public void setCollectPassword(String collectPassword) {
		this.collectPassword = collectPassword;
	}
	public String getCollectIsAuth() {
		return collectIsAuth;
	}
	public void setCollectIsAuth(String collectIsAuth) {
		this.collectIsAuth = collectIsAuth;
	}
	public String getCollectApi() {
		return collectApi;
	}
	public void setCollectApi(String collectApi) {
		this.collectApi = collectApi;
	}
	public String getCollectData() {
		return collectData;
	}
	public void setCollectData(String collectData) {
		this.collectData = collectData;
	}
	public String getCollectState() {
		return collectState;
	}
	public void setCollectState(String collectState) {
		this.collectState = collectState;
	}

}
