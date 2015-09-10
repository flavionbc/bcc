package com.paysecure.bcc.client;

import com.paysecure.bcc.dto.Usuario;

public interface UsuarioClientRest {
	
	public Usuario autenticar(String cpf, String senha);
	
	/*public Usuario autenticar(String cpf, String senha){
		RestTemplate rest = getRestTemplate();
		String url = getUrl(UrlEnum.USUARIO_URL.getUrl(), cpf, senha);
		Usuario usuario = rest.getForObject(url, Usuario.class);
		return usuario;
	}*/
	
}
