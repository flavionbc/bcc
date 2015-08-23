package com.paysecure.bcc.client.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paysecure.bcc.client.AbstractRestClient;
import com.paysecure.bcc.client.UsuarioClientRest;
import com.paysecure.bcc.dto.Usuario;

import br.paysecure.bcc.enums.UrlEnum;

@Service("usuarioClienteRest")
public class UsuarioClientRestImpl extends AbstractRestClient implements UsuarioClientRest {

	@Override
	public Usuario autenticar(String cpf, String senha){
		RestTemplate rest = getRestTemplate();
		String url = getUrl(UrlEnum.USUARIO_URL.getUrl(), cpf, senha);
		Usuario usuario = rest.getForObject(url, Usuario.class);
		return usuario;
	}

}
