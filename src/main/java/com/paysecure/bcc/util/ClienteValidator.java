package com.paysecure.bcc.util;

import org.springframework.stereotype.Service;

import com.paysecure.bcc.dto.Cliente;

@Service
public class ClienteValidator {

	
	public String validarDados(Cliente cliente){
		
		if(cliente == null){
			return "Cliente n�o configurado.";
		}
		if(cliente.getNomeFantasia() == null || cliente.getNomeFantasia().trim().isEmpty()){
			return "Nome Fantasia deve ser preenchido.";
		}
		if(cliente.getNroEmissor() == null || cliente.getNroEmissor().trim().isEmpty()){
			return "N�mero do clinte deve ser preenchido.";
		}
		if(cliente.getCnpj() == null || cliente.getCnpj().trim().isEmpty()){
			return "CNPJ deve ser preenchido.";
		}
		if(cliente.getCnpj().length() != 14){
			return "CNPJ deve possuir 14 d�gitos.";
		}
		
		return null;
	}
}
