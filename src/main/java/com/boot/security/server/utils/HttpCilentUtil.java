package com.boot.security.server.utils;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 模拟请求登录
 * @author zhanggenqiang
 *
 */
public class HttpCilentUtil 
{
	
	public static CloseableHttpClient httpClient = HttpClients.createDefault();
	
	//通过上面的token登录信息
	private static String accessToken ="";
	//野鸡登录请求
	/**
	 * 调用httpclient 判断get请求，并且返回数据结构
	 * 
	 * @param url get请求地址
	 * @param params 参数
	 * @return HttpEntity
	 */
	public static String getMethod(String url, Map<String, String> params) 
	{		   
		HttpGet httpGet = null;
		CloseableHttpResponse response =null;
		String body="";
		try
		{
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(60000).setConnectTimeout(60000).build();
			String ps = "";
			for (String pKey : params.keySet())
			{
				if (!"".equals(ps)) {
					ps = ps + "&";
				}
				ps = pKey + "=" + (String)params.get(pKey);
			}
			if (!"".equals(ps)) {
				url = url + "?" + ps;
			}
			httpGet = new HttpGet(url);
			httpGet.setConfig(requestConfig);
			addHeader(httpGet);
		    response = httpClient.execute(httpGet);
			HttpEntity httpEntity = response.getEntity();
			if (httpEntity != null) {  
				body = EntityUtils.toString(httpEntity, "utf-8");  
			}  
		}
		catch (ClientProtocolException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
		}
		finally {
			try {
				if(response!=null)
				{
				response.close();
				}
			} catch (IOException e) {
			}  
		}
		return body;
	}
	/**
	 * 向httpget中增加cookses等信息
	 */
	public static void addHeader(HttpGet httpget)
	{
		httpget.addHeader("X-Requested-With", "XMLHttpRequest");
		httpget.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36");
		httpget.addHeader("Connection", "keep-alive");
		httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
		httpget.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
		if(!"".equals(accessToken))
		{
			httpget.addHeader("accessToken", accessToken);
		}
		
 	}
}
