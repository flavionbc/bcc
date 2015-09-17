package com.paysecure.bcc.client.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paysecure.bcc.client.AbstractRest;
import com.paysecure.bcc.dto.Perfil;
import com.paysecure.bcc.enums.Metodo;
import com.paysecure.bcc.enums.UrlEnum;

@Service
public class PerfilRestImpl extends AbstractRest {

	Logger log = Logger.getLogger(PerfilRestImpl.class);
	
	public List<Perfil> buscarPerfis() {
		
		Perfil p = new Perfil();
		p.setId(1);
		p.setDescricao("USUARIO");
		List<Perfil> perfis = new ArrayList<Perfil>();
		perfis.add(p);
		
		return perfis;
	}
	
	public boolean cadastrar(Perfil perfil){
		
		try{
			RestTemplate rt = getRestTemplate();
			rt.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            rt.getMessageConverters().add(new StringHttpMessageConverter());
			String url = getUrl(UrlEnum.PERFIL_URL.getUrl(), Metodo.INSERIR.getValor());
			rt.postForObject(url, perfil, Perfil.class);
			return true;
		}catch(Exception ex){
			log.error(ex.getMessage());
			return false;
		}
	}
	
}
