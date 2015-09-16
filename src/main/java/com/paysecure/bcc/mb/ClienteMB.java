package com.paysecure.bcc.mb;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import lombok.Getter;
import lombok.Setter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.paysecure.bcc.client.impl.ClienteRestImpl;
import com.paysecure.bcc.dto.Cliente;
import com.paysecure.bcc.enums.StatusClienteEnum;
import com.paysecure.bcc.util.JsfUtil;

@ViewScoped
@Controller
@ManagedBean(name="clienteMB")
public class ClienteMB {

	Logger log = Logger.getLogger(ClienteMB.class);
	
	private @Getter @Setter Cliente cliente;
	private @Getter @Setter List<Cliente> clientes;
	private @Getter @Setter List<StatusClienteEnum> status;
	
	@Autowired private ClienteRestImpl service;	
	
	{
		status = Arrays.asList(StatusClienteEnum.values());
	}
	
	
	public void buscar(){
		log.info("Buscando clientes...");
		clientes = service.buscar();
		JsfUtil.redirecionarUsuario("/interno/clientes.xhtml");
	}
	
	public void novo(){
		cliente = new Cliente();
		JsfUtil.redirecionarUsuario("/interno/clienteEdit.xhtml");
	}
	
	public void selecionar(){
		if(cliente != null){
			JsfUtil.redirecionarUsuario("/interno/clienteEdit.xhtml");
		}
	}
	
	public void cadastrar(){
		if(service.cadastrar(cliente)){
			JsfUtil.addMsgGrowlSucesso("Cadastro realizado com Sucesso!", null);
		}else{
			JsfUtil.addMsgGrowlError("Não foi possível realizar o cadastro", null);
		}
	}
	
	public void alterar(){
		if(service.alterar(cliente)){
			JsfUtil.addMsgGrowlSucesso("Cadastro atualizado com Sucesso!", null);
		}else{
			JsfUtil.addMsgGrowlError("Não foi possível atualizar o cadastro", null);
		}
	
	}
	
	public void excluir(){
		if(service.excluir(cliente)){
			JsfUtil.addMsgGrowlSucesso("Cadastro excluído com Sucesso!", null);
		}else{
			JsfUtil.addMsgGrowlError("Não foi possível excluir o cadastro", null);
		}
	
	}
	
	
}
