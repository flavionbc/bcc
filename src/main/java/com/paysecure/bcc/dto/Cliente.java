package com.paysecure.bcc.dto;

import java.util.List;

import lombok.Data;

import com.paysecure.bcc.enums.StatusClienteEnum;

@Data
public class Cliente {
	
	private Long id;
	private String cnpj;
	private String nroEmissor;
	private String nomeFantasia;
	private StatusClienteEnum statusCliente;
	private String cidade;
	private String uf;
	private String endereco;
	private String cep;
	private List<Usuario> listaUsuarios;
	
}
