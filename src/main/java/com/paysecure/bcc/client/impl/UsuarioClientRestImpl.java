package com.paysecure.bcc.client.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paysecure.bcc.client.AbstractRestClient;
import com.paysecure.bcc.client.UsuarioClientRest;
import com.paysecure.bcc.dto.Cartao;
import com.paysecure.bcc.dto.Usuario;
import com.paysecure.bcc.enums.UrlEnum;

@Service("usuarioClienteRest")
public class UsuarioClientRestImpl extends AbstractRestClient implements UsuarioClientRest {

	Logger log = Logger.getLogger(UsuarioClientRestImpl.class);
	
	@Override
	public Usuario autenticar(String cpf, String senha){
		//RestTemplate rest = getRestTemplate();
		try{
			//String url = getUrl(UrlEnum.USUARIO_URL.getUrl(), cpf, senha);
			//Usuario usuario = rest.getForObject(url, Usuario.class);
			return getUser();
		}catch(Exception ex){
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}
	
	private Usuario getUser(){
		Usuario u = new Usuario();
		
		u.setCpf("01205720103");
		u.setNome("ALEXANDRE DIAS BRIGIDO");
		u.setSenha("12345");
		
		List<Cartao> cartoes = new ArrayList<Cartao>();
		Cartao c1 = new Cartao();
		c1.setNumero("6042201000123456");
		c1.setCvv(245);
		c1.setDataValidade(new Date());

		Cartao c2 = new Cartao();
		c2.setNumero("4052201000123450");
		c2.setCvv(255);
		c2.setDataValidade(new Date());
		cartoes.add(c1);
		cartoes.add(c2);
		
		u.setCartoes(cartoes);
		
		return u;
	}

}
