package com.paysecure.bcc.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import lombok.Getter;
import lombok.Setter;

import com.paysecure.bcc.dto.Usuario;
import com.paysecure.bcc.enums.StatusUsuarioEnum;
import com.paysecure.bcc.util.JsfUtil;
import com.paysecure.bcc.util.SessaoUtil;

@ManagedBean
@ViewScoped
public class UsuarioMB {

	private @Getter @Setter Usuario usuario;
	private @Getter @Setter SelectItem[] status = new SelectItem[StatusUsuarioEnum.values().length];
	
	{
		usuario = SessaoUtil.getUsuarioSessao();
		int i = 0;
		for(StatusUsuarioEnum s : StatusUsuarioEnum.values()){
			status[i++] = new SelectItem(s, s.toString());
		}
	}
	
	
	public void selecionar(){
		if(usuario != null){
			JsfUtil.redirecionarUsuario("/usuarioEdit.xhtml");
		}
	}
	
	public void cadastrar(){
		
	}
	
	public void excluir(){
		
	}
	
	public void buscar(){
		
	}
}
