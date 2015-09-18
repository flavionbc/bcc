package com.paysecure.bcc.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.paysecure.bcc.client.AbstractRest;
import com.paysecure.bcc.dto.Cliente;
import com.paysecure.bcc.enums.StatusClienteEnum;
import com.paysecure.bcc.enums.UrlEnum;

public class TesteRest extends AbstractRest {

	
	public static void main(String[] args) {
		new TesteRest().cadastrar();
	}
	
	private void cadastrar(){
	
		try{
			Cliente c= new Cliente();
			c.setNomeFantasia("BANCO ALEXANDRE SA");
			c.setCep("70000000");
			c.setNroEmissor("999");
			c.setStatusCliente(StatusClienteEnum.ATIVO);
			c.setUf("DF");
			
			Map<String, String> vars = new HashMap<String, String>();
	        vars.put("id", "JS01");
	        
			RestTemplate rt = getRestTemplate();
			rt.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            rt.getMessageConverters().add(new StringHttpMessageConverter());
			String url = getUrl(UrlEnum.CLIENTE_URL.getUrl(), "insert");
			rt.postForObject(url, c, Cliente.class);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
