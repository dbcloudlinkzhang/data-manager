package com.boot.security.server.utils;

import com.alibaba.druid.pool.DruidDataSource;
import java.util.Properties;
import javax.sql.DataSource;

/**
 * 公共连接资源池
 * @author Administrator
 *
 */
public class AbstractDbConfig {
	public AbstractDbConfig() {
	}

	public DataSource datasource(String driverClassName, String dbUrl, String username, String password) {
		DruidDataSource datasource = new DruidDataSource();
		datasource.setUrl(dbUrl);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.setDriverClassName(driverClassName);
		datasource.setInitialSize(5);
		datasource.setMinIdle(5);
		datasource.setMaxActive(20);
		datasource.setMaxWait(120000L);
		Properties properties = new Properties();
		datasource.setConnectProperties(properties);
		return datasource;
	}
}
