package com.paysecure.bcc.client.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paysecure.bcc.client.AbstractRestClient;
import com.paysecure.bcc.dto.Cliente;
import com.paysecure.bcc.enums.StatusClienteEnum;
import com.paysecure.bcc.enums.UrlEnum;
import com.paysecure.bcc.util.ClienteValidator;
import com.paysecure.bcc.util.JsfUtil;

@Service
public class ClienteRestImpl extends AbstractRestClient {

	Logger log = Logger.getLogger(ClienteRestImpl.class);
	
	@Autowired private ClienteValidator validador;
	
	public boolean cadastrar(Cliente cliente){
		log.info("Cadastrando clinte...");
		String mensagem = validador.validarDados(cliente);
		
		if(mensagem != null){
			JsfUtil.addMsgGrowlError(mensagem, null);
			return false;
		}
		
		try{
			RestTemplate rest = getRestTemplate();
			rest.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            rest.getMessageConverters().add(new StringHttpMessageConverter());
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

	public boolean alterar(Cliente cliente) {
		return true;
	}

	public boolean excluir(Cliente cliente) {
		return true;
	}
}
