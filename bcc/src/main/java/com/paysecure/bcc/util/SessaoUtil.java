package com.paysecure.bcc.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.paysecure.bcc.dto.Usuario;

public class SessaoUtil {

	public static Usuario getUsuarioSessao() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) contexto.getExternalContext()
				.getSession(true);
		return (Usuario) sessao.getAttribute("usuarioSessao");
	}
	
	public static void encerrarSessao() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession) ctx.getExternalContext()
				.getSession(true);
		httpSession = (HttpSession) ctx.getExternalContext().getSession(false);
		httpSession.setAttribute("usuarioSessao", null);
	}

	public static void adicionarLoginSessao(Usuario usu) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession) ctx.getExternalContext()
				.getSession(true);
		httpSession = (HttpSession) ctx.getExternalContext().getSession(false);
		httpSession.setAttribute("usuarioSessao", usu);
	}
}
