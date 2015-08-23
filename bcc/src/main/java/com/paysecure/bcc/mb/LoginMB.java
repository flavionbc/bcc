package com.paysecure.bcc.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.paysecure.bcc.client.UsuarioClientRest;
import com.paysecure.bcc.dto.Usuario;
import com.paysecure.bcc.util.JsfUtil;
import com.paysecure.bcc.util.SessaoUtil;

@Controller
@ManagedBean(name="loginMB")
@Scope("view")
public class LoginMB implements Serializable{
	
	private static final long serialVersionUID = 3898173124729955356L;

	@Autowired
	private UsuarioClientRest usuarioClienteRest;
	
	private Logger log = Logger.getLogger(LoginMB.class.getName());
	
	private String cpf;
	private String senha;
	
	public void loginIn(){
		Usuario usuario = usuarioClienteRest.autenticar(getCpf(), getSenha());
		if(usuario != null){
			SessaoUtil.adicionarLoginSessao(usuario);
			log.warn("Usuario logado: "+usuario.getNome());
			JsfUtil.redirecionarUsuario("/index.html");	
		}
		
		// informar erro login.
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
