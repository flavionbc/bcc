package com.paysecure.bcc.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import lombok.Getter;
import lombok.Setter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paysecure.bcc.client.impl.ClienteRestImpl;
import com.paysecure.bcc.dto.Cliente;


@Controller
@ManagedBean(name="clienteMB")
@Scope("view")
public class ClienteMB {

	private @Getter @Setter Cliente cliente;
	private @Getter @Setter List<Cliente> clientes;
	
	private ClienteRestImpl service;
	
	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public void buscar(){
		cliente = new Cliente();
		cliente.setNomeFantasia("BANCO ALEXANDRE SA");
		cliente.setId(1L);
		clientes = new ArrayList<Cliente>();
		clientes.add(cliente);
	}
	
	public void cadastrar(){
		service.cadastrar(cliente);
	}
	
	public void alterar(){
		
	}
	
	public void excluir(){
		
	}
	
	
}
