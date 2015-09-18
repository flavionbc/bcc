package com.paysecure.bcc.mb;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;

import com.paysecure.bcc.client.impl.PerfilRestImpl;
import com.paysecure.bcc.client.impl.UsuarioClientRestImpl;
import com.paysecure.bcc.dto.Perfil;
import com.paysecure.bcc.dto.Usuario;
import com.paysecure.bcc.enums.StatusUsuarioEnum;
import com.paysecure.bcc.util.JsfUtil;
import com.paysecure.bcc.util.SessaoUtil;

@ViewScoped
@Controller
@ManagedBean
public class UsuarioMB {

	private @Getter @Setter Usuario usuario;
	private @Getter @Setter List<Perfil> perfis;
	private @Getter @Setter List<StatusUsuarioEnum> status;
	
	@Autowired private UsuarioClientRestImpl service;
	@Autowired private PerfilRestImpl servicePerfil;
	
	{
		status = Arrays.asList(StatusUsuarioEnum.values());
	}
	
	private void carregarPerfis(){
		perfis = servicePerfil.buscarPerfis();
	}
	
	public void carregarFuncionalidadesPorPerfil(){
		
	}
	
	public void criarNovo(){
		carregarPerfis();
		usuario = new Usuario();
	}
	
	public void selecionar(){
		usuario = SessaoUtil.getUsuarioSessao();
		if(usuario != null){
			JsfUtil.redirecionarUsuario("/interno/usuarioEdit.xhtml");
		}
	}
	
	public void cadastrar(){
		if(service.cadastrar(usuario)){
			JsfUtil.addMsgGrowlSucesso("Usuário cadastrado com sucesso!", null);
		}else{
			JsfUtil.addMsgGrowlError("Não foi possível cadastrar o usuário", null);
		}
	}
	
	public void alterar(){
		if(service.alterar(usuario)){
			JsfUtil.addMsgGrowlSucesso("Usuário alterado com sucesso!", null);
		}else{
			JsfUtil.addMsgGrowlError("Não foi possível alterar o usuário", null);
		}
	
	}
	
	public void buscar(){
		
	}
	
	/** 
	 * Busca os cartoes do usuario que esta logado
	 * e redireciona para a pagina de cartoes
	 *  */
	public void buscarCartaoLogado(){
		usuario = SessaoUtil.getUsuarioSessao();
		JsfUtil.redirecionarUsuario("/interno/cartoes.xhtml");
	}
}
