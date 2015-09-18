package com.paysecure.bcc.client;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class AbstractRest {
	
	private static final String PARENTESES = "/";
	
	public RestTemplate getRestTemplate(){
		RestTemplate rest = new RestTemplate();
		rest.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        rest.getMessageConverters().add(new StringHttpMessageConverter());
		return rest;
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
