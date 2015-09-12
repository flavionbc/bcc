package com.paysecure.bcc.client.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paysecure.bcc.client.AbstractRestClient;
import com.paysecure.bcc.dto.Cliente;
import com.paysecure.bcc.enums.StatusClienteEnum;
import com.paysecure.bcc.enums.UrlEnum;

@Service
public class ClienteRestImpl extends AbstractRestClient {

	Logger log = Logger.getLogger(ClienteRestImpl.class);
	
	public boolean cadastrar(Cliente cliente){
		log.info("Cadastrando clinte...");
		
		try{
			RestTemplate rest = getRestTemplate();
			String url = getUrl(UrlEnum.CLIENTE_URL.getUrl(), "inserir");
			rest.postForObject(url, cliente, Cliente.class);
			log.info("Cadastro realizado");
			return true;
		}catch(Exception ex){
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
		return false;	
	}
	
	public List<Cliente> buscar(){
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		Cliente cliente = new Cliente();
		cliente.setNomeFantasia("BANCO ALEXANDRE SA");
		cliente.setId(1L);
		cliente.setUf("DF");
		cliente.setStatusCliente(StatusClienteEnum.ATIVO);

		Cliente cliente2 = new Cliente();
		cliente2.setNomeFantasia("ITAU UNIBANCO SA");
		cliente2.setId(2L);
		cliente2.setUf("SP");
		cliente2.setStatusCliente(StatusClienteEnum.INADIMPLENTE);
		
		Cliente cliente3 = new Cliente();
		cliente3.setNomeFantasia("BRADESCO SA");
		cliente3.setId(3L);
		cliente3.setUf("RJ");
		cliente3.setStatusCliente(StatusClienteEnum.BLOQUEADO);
		
		clientes.add(cliente);
		clientes.add(cliente2);
		clientes.add(cliente3);
		
		return clientes;
	}
}
