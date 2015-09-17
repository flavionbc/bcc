package com.paysecure.bcc.mb;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import lombok.Getter;
import lombok.Setter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.paysecure.bcc.client.UsuarioClientRest;
import com.paysecure.bcc.dto.Usuario;
import com.paysecure.bcc.util.JsfUtil;
import com.paysecure.bcc.util.SessaoUtil;

@ViewScoped
@Controller
@ManagedBean(name="loginMB")
public class LoginMB implements AuthenticationProvider {

	@Autowired
	private UsuarioClientRest usuarioClienteRest;
	
	private Logger log = Logger.getLogger(LoginMB.class);
	
	private @Getter @Setter String cpf;
	private @Getter @Setter String senha;
	private @Getter @Setter Usuario usuario;
	
	public void loginIn(){
		usuario = usuarioClienteRest.autenticar(getCpf(), getSenha());
		if(usuario != null){
			usuario.setDataUltimoAcesso(new Date());
			SessaoUtil.adicionarLoginSessao(usuario);
			loginSpring(usuario);
			log.info("Usuario logado: "+usuario.getNome());
			JsfUtil.redirecionarUsuario("/interno/index.xhtml");	
		}else{
			JsfUtil.addMsgGrowlError("Usuário/Senha inválidos.", null);
		}
	}
	
	public void logout(){
		SessaoUtil.encerrarSessao();
		logoutSpring();
		JsfUtil.redirecionarUsuario("/login.xhtml");
	}

	@Override
	public Authentication authenticate(Authentication arg0)
			throws AuthenticationException {
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	private void loginSpring(Usuario usuario){
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(usuario.getLogin(), usuario.getSenha(), usuario.getPerfil().getFuncionalidades());
		token.setDetails(usuario);
        SecurityContextHolder.createEmptyContext();
        SecurityContextHolder.getContext().setAuthentication(token);
	}

	private void logoutSpring(){
		// Limpa o contexto do usuário spring:
		SecurityContextHolder.clearContext();
		// Limpa os dados de login:
		senha = null;
		cpf = null;
		usuario = null;
	}
}
