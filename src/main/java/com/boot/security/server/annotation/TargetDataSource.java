package com.boot.security.server.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.boot.security.server.constant.DataSourceKey;

/**
 * 自定义直接
 * @author Administrator
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
	
	DataSourceKey value() default DataSourceKey.CONVERT;

}