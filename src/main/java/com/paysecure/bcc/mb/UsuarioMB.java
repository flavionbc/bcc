package com.paysecure.bcc.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import lombok.Getter;
import lombok.Setter;

import com.paysecure.bcc.dto.Usuario;
import com.paysecure.bcc.util.SessaoUtil;

@ManagedBean
@ViewScoped
public class UsuarioMB {

	private @Getter @Setter Usuario usuario;
	
	{
		usuario = SessaoUtil.getUsuarioSessao();
	}
	
}
