package com.boot.security.server.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.boot.security.server.constant.DataSourceKey;


/**
 * 数据源配置类
 * 在该类中生成多个数据源实例并将其注入到 ApplicationContext 中
 * 2019年6月4日 上午10:06:54
 */
@Configuration
public class DataSourceConfigurer {
 
    /**
     * 配置数据源
     * @return
     */
    @Bean(name = "convert")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.convert")
    public DataSource CONVERT() {
    	return DruidDataSourceBuilder.create().build();
    }
    
    /**
     * 配置数据源
     * @return
     */
    @Bean(name = "rill")
    @ConfigurationProperties(prefix = "spring.datasource.rill")
    public DataSource RILL() {
    	return DruidDataSourceBuilder.create().build();
    }
    /**
     * 配置数据源
     * @return
     */
    @Bean(name = "zwpt")
    @ConfigurationProperties(prefix = "spring.datasource.zwpt")
    public DataSource ZWPT() {
    	return DruidDataSourceBuilder.create().build();
    }
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource(){
    	DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
    	
    	Map<Object, Object> dataSourceMap = new HashMap<Object, Object>(2);
    	dataSourceMap.put(DataSourceKey.CONVERT.getName(),CONVERT());
    	dataSourceMap.put(DataSourceKey.RILL.getName(),RILL());
    	dataSourceMap.put(DataSourceKey.ZWPT.getName(),ZWPT());
    	
    	dynamicRoutingDataSource.setDefaultTargetDataSource(CONVERT());
    	dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);
    	
    	DynamicDataSourceContextHolder.dataSourceKeys.addAll(dataSourceMap.keySet());
    
    	return dynamicRoutingDataSource;
    }
    
    @Bean
    @ConfigurationProperties(prefix = "mybatis")
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception{
    	SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    	
    	org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
    	configuration.setMapUnderscoreToCamelCase(true); //下划线转骆驼
//    	sqlSessionFactoryBean.setConfigLocation(res);
    	
    	PathMatchingResourcePatternResolver resolver = new  PathMatchingResourcePatternResolver();
    	sqlSessionFactoryBean.setTypeAliasesPackage("com.boot.security.server.model");
    	sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/mybatis-mappers/*.xml"));
    	sqlSessionFactoryBean.setDataSource(dynamicDataSource());
    	sqlSessionFactoryBean.setConfiguration(configuration);
    	
    	return sqlSessionFactoryBean;
    }
    
    /**
     * 事务
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(){
    	return new DataSourceTransactionManager(dynamicDataSource());
    }
	
}