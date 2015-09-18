package com.paysecure.bcc.client.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paysecure.bcc.client.AbstractRest;
import com.paysecure.bcc.client.UsuarioClientRest;
import com.paysecure.bcc.dto.Usuario;
import com.paysecure.bcc.enums.Metodo;
import com.paysecure.bcc.enums.UrlEnum;
import com.paysecure.bcc.util.JsfUtil;
import com.paysecure.bcc.util.UsuarioValidator;

@Service("usuarioClienteRest")
public class UsuarioClientRestImpl extends AbstractRest implements UsuarioClientRest {

	Logger log = Logger.getLogger(UsuarioClientRestImpl.class);
	@Autowired private UsuarioValidator validador;
	
	@Override
	public Usuario autenticar(String cpf, String senha){
		RestTemplate rest = getRestTemplate();
		try{
			String url = getUrl(UrlEnum.USUARIO_URL.getUrl(), cpf, senha);
			Usuario usuario = rest.getForObject(url, Usuario.class);
			return usuario;
		}catch(Exception ex){
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}

	public boolean cadastrar(Usuario usuario) {
		log.info("Cadastrando usuario...");
		String mensagem = validador.validarDados(usuario);
		
		if(mensagem != null){
			JsfUtil.addMsgGrowlError(mensagem, null);
			return false;
		}
		
		try{
			RestTemplate rest = getRestTemplate();
			String url = getUrl(UrlEnum.USUARIO_URL.getUrl(), Metodo.INSERIR.getValor());
			rest.postForObject(url, usuario, Usuario.class);
			log.info("Cadastro realizado");
			return true;
		}catch(Exception ex){
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
		return false;	
	}

	public boolean alterar(Usuario usuario) {
		return true;
	}

}
