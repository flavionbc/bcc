package com.paysecure.bcc.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import lombok.Getter;
import lombok.Setter;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
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
	
	private ClienteRestImpl service;
	
	public void buscar(){
		log.info("Buscando clientes...");
		cliente = new Cliente();
		cliente.setNomeFantasia("BANCO ALEXANDRE SA");
		cliente.setId(1L);
		cliente.setUf("DF");
		cliente.setStatusCliente(StatusClienteEnum.ATIVO);
		clientes = new ArrayList<Cliente>();
		clientes.add(cliente);
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
