package com.paysecure.bcc.client;

import org.springframework.web.client.RestTemplate;

public class AbstractRest {
	
	private static final String PARENTESES = "/";
	
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	public String getUrl(String url, String... parametros){
		StringBuffer sb = new StringBuffer();
		sb.append(url);
		for(String param: parametros){
			sb.append(PARENTESES);
			sb.append(param);
		}
		return sb.toString();
	}
	
}
