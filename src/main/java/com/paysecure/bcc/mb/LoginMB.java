package com.paysecure.bcc.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import lombok.Getter;
import lombok.Setter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.paysecure.bcc.client.UsuarioClientRest;
import com.paysecure.bcc.dto.Usuario;
import com.paysecure.bcc.util.JsfUtil;
import com.paysecure.bcc.util.SessaoUtil;

@Controller
@ManagedBean(name="loginMB")
@ViewScoped
public class LoginMB {

	@Autowired
	private UsuarioClientRest usuarioClienteRest;
	
	private Logger log = Logger.getLogger(LoginMB.class);
	
	private @Getter @Setter String cpf;
	private @Getter @Setter String senha;
	
	public void loginIn(){
		Usuario usuario = usuarioClienteRest.autenticar(getCpf(), getSenha());
		if(usuario != null){
			SessaoUtil.adicionarLoginSessao(usuario);
			log.info("Usuario logado: "+usuario.getNome());
			JsfUtil.redirecionarUsuario("/index.xhtml");	
		}else{
			JsfUtil.addMsgGrowlError("Usuário/Senha inválidos.", null);
		}
	}


}
