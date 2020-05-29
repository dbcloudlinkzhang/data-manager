package com.boot.security.server.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
 * @author Administrator
 *
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
 
	private static final Logger logger = LoggerFactory.getLogger(DynamicRoutingDataSource.class);
	
	@Override
	protected Object determineCurrentLookupKey() {
		logger.info("current datasource is : {}",DynamicDataSourceContextHolder.getDataSourceKey());
		return DynamicDataSourceContextHolder.getDataSourceKey();
	}
 
}