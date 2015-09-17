package com.paysecure.bcc.client.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paysecure.bcc.client.AbstractRest;
import com.paysecure.bcc.client.UsuarioClientRest;
import com.paysecure.bcc.dto.Cartao;
import com.paysecure.bcc.dto.Cliente;
import com.paysecure.bcc.dto.Funcionalidade;
import com.paysecure.bcc.dto.Perfil;
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
		//RestTemplate rest = getRestTemplate();
		try{
			//String url = getUrl(UrlEnum.USUARIO_URL.getUrl(), cpf, senha);
			//Usuario usuario = rest.getForObject(url, Usuario.class);
			return getUser(cpf, senha);
		}catch(Exception ex){
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}
	
	private Usuario getUser(String cpf, String senha){
		Usuario u = new Usuario();
		
		u.setNome("ALEXANDRE DIAS BRIGIDO");
		u.setCpf("123");
		u.setSenha("123");
		
		List<Cartao> cartoes = new ArrayList<Cartao>();
		Cartao c1 = new Cartao();
		c1.setNumero("6042201000123456");
		c1.setCvv(245);
		c1.setDataValidade(new Date());

		Cartao c2 = new Cartao();
		c2.setNumero("4052201000142230");
		c2.setCvv(255);
		c2.setDataValidade(new Date());
		cartoes.add(c1);
		cartoes.add(c2);
		
		u.setCartoes(cartoes);
		
		Perfil p = new Perfil();
		p.setId(1);
		p.setDescricao("ADMIN");
		
		Funcionalidade f = new Funcionalidade();
		f.setId(1);
		f.setDescricao("INTERNO");
		List<Funcionalidade> funs = new ArrayList<Funcionalidade>();
		funs.add(f);
		p.setFuncionalidades(funs);
		
		u.setPerfil(p);
		if(u.getCpf().equals(cpf) && u.getSenha().equals(senha)){
			return u;
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
			rest.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            rest.getMessageConverters().add(new StringHttpMessageConverter());
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

	public boolean excluir(Usuario usuario) {
		return true;
	}

}
