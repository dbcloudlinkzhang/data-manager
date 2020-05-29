package com.boot.security.server.page;

import java.util.HashMap;
import java.util.List;

/**
 * 二次封装分页公共类
 * @ClassName: PageModel 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author genqiangzhang 
 * @date 2019年9月15日 下午7:22:10
 */
public class PageModel  extends HashMap<String, Object> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7256311511582649175L;

	public static PageModel data(Integer count,List<?> data){
		PageModel r = new PageModel();
		r.put("code", 0);
		r.put("msg", "");
		r.put("count", count);
		r.put("data", data);
		return r;
	}
}
