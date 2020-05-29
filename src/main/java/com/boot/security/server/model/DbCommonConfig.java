package com.boot.security.server.model;

/**
 * 公共数据库连接
 * @author Administrator
 *
 */
public class DbCommonConfig {

	private String uniname;
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    public DbCommonConfig() {
    }

    public DbCommonConfig(String uniname, String url, String username, String password, String driverClassName) {
        this.uniname = uniname;
        this.url = url;
        this.username = username;
        this.password = password;
        this.driverClassName = driverClassName;
    }

    public String getUniname() {
        return uniname;
    }

    public void setUniname(String uniname) {
        this.uniname = uniname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}