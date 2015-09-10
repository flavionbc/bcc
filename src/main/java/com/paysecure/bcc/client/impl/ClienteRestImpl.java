package com.paysecure.bcc.client.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paysecure.bcc.client.AbstractRestClient;
import com.paysecure.bcc.dto.Cliente;
import com.paysecure.bcc.enums.UrlEnum;

@Service
public class ClienteRestImpl extends AbstractRestClient {

	Logger log = Logger.getLogger(ClienteRestImpl.class);
	
	public boolean cadastrar(Cliente cliente){
		log.info("Cadastrando clinte...");
		
		try{
			RestTemplate rest = getRestTemplate();
			String url = getUrl(UrlEnum.CLIENTE_URL.getUrl(), "inserir");
			rest.postForObject(url, cliente, Cliente.class);
			log.info("Cadastro realizado");
			return true;
		}catch(Exception ex){
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
		return false;	
	}
}
