package com.paysecure.bcc.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import lombok.Getter;
import lombok.Setter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.paysecure.bcc.client.impl.ClienteRestImpl;
import com.paysecure.bcc.dto.Cliente;
import com.paysecure.bcc.util.JsfUtil;

@Controller
@ManagedBean(name="clienteMB")
//@Scope("view")
public class ClienteMB {

	Logger log = Logger.getLogger(ClienteMB.class);
	
	private @Getter @Setter Cliente cliente;
	private @Getter @Setter List<Cliente> clientes;
	
	@Autowired
	private ClienteRestImpl service;
	
	public void buscar(){
		log.info("Buscando clientes...");
		clientes = service.buscar();
		JsfUtil.redirecionarUsuario("/clientes.xhtml");
	}
	
	public void cadastrar(){
		service.cadastrar(cliente);
	}
	
	public void alterar(){
		
	}
	
	public void excluir(){
		
	}
	
	
}
