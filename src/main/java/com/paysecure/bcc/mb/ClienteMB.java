package com.paysecure.bcc.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import lombok.Getter;
import lombok.Setter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.paysecure.bcc.client.impl.ClienteRestImpl;
import com.paysecure.bcc.dto.Cliente;
import com.paysecure.bcc.enums.StatusClienteEnum;
import com.paysecure.bcc.util.JsfUtil;

@Controller
@ManagedBean(name="clienteMB")
//@Scope("view")
public class ClienteMB {

	Logger log = Logger.getLogger(ClienteMB.class);
	
	private @Getter @Setter Cliente cliente;
	private @Getter @Setter List<Cliente> clientes;
	
	@Autowired private ClienteRestImpl service;
	
	private @Getter @Setter SelectItem[] status = new SelectItem[StatusClienteEnum.values().length];
	
	{
		int i = 0;
		for(StatusClienteEnum s : StatusClienteEnum.values()){
			status[i++] = new SelectItem(s, s.getDescricao());
		}
	}
	
	
	public void buscar(){
		log.info("Buscando clientes...");
		clientes = service.buscar();
		JsfUtil.redirecionarUsuario("/clientes.xhtml");
	}
	
	public void novo(){
		cliente = new Cliente();
		JsfUtil.redirecionarUsuario("/clienteEdit.xhtml");
	}
	
	public void selecionar(){
		if(cliente != null){
			JsfUtil.redirecionarUsuario("/clienteEdit.xhtml");
		}
	}
	
	public void cadastrar(){
		if(service.cadastrar(cliente)){
			JsfUtil.addMsgGrowlSucesso("Cadastro Realizado com Sucesso!", null);
		}else{
			JsfUtil.addMsgGrowlError("Não foi possível realizar o cadastro", null);
		}
	}
	
	public void alterar(){
		
	}
	
	public void excluir(){
		
	}
	
	
}
