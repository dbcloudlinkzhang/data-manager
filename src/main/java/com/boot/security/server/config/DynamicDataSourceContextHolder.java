package com.boot.security.server.config;

import java.util.ArrayList;
import java.util.List;
import com.boot.security.server.constant.DataSourceKey;

public class DynamicDataSourceContextHolder {
	
	private static ThreadLocal<Object> CONTEXT_HOLDER = ThreadLocal.withInitial(() -> DataSourceKey.CONVERT.getName());
	
	public static List<Object> dataSourceKeys = new ArrayList<Object>();
	
	public static void setDataSourceKey(String key){
		CONTEXT_HOLDER.set(key);
		
	}
	
	public static Object getDataSourceKey(){
		return CONTEXT_HOLDER.get();
	}
	
	public static void clearDataSourceKey(){
		CONTEXT_HOLDER.remove();
	}
	
	public static Boolean containDataSourceKey(String key){
		return dataSourceKeys.contains(key);
	}
}