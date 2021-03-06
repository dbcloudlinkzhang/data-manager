package com.boot.security.server.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.boot.security.server.annotation.TargetDataSource;
import com.boot.security.server.config.DynamicDataSourceContextHolder;

/**
 * 使用AOP，以自定义注解注解在的方法为切点，动态切换数据源
 * @author Administrator
 *
 */
@Aspect
@Component
public class DynamicDataSourceAspect {
 
	private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);
	
	@Before("@annotation(targetDataSource))")
	public void switchDataSource(JoinPoint joinPoint,TargetDataSource targetDataSource){
		if ( !DynamicDataSourceContextHolder.containDataSourceKey( targetDataSource.value().getName() ) ) {
			logger.error("DataSource [{}] doesn't exist, use default DataSource [{}]", targetDataSource.value());
        } else {
            DynamicDataSourceContextHolder.setDataSourceKey( targetDataSource.value().getName() );
            logger.info("Switch DataSource to [{}] in Method [{}]",
                    DynamicDataSourceContextHolder.getDataSourceKey(), joinPoint.getSignature());
        }
	}
	
	@After("@annotation(targetDataSource))")
	public void restoreDataSource(JoinPoint joinPoint,TargetDataSource targetDataSource){
        DynamicDataSourceContextHolder.clearDataSourceKey();
        logger.info("Restore DataSource to [{}] in Method [{}]",
                DynamicDataSourceContextHolder.getDataSourceKey(), joinPoint.getSignature());
	}
	
}