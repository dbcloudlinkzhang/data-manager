package com.boot.security.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动类
* @ClassName: SecurityApplication 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author genqiangzhang 
* @date 2019年9月14日 下午4:50:13
 */

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SecurityApplication {
	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
}
