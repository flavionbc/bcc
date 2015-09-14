package com.paysecure.bcc.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Usuario {
	
	private Long id;
	private Perfil perfil;
	private String nome;
	private String cpf;
	private String senha;
	private Integer status;
	private Date dataCriacao;
	private Date dataCanelado;
	private Date dataTrocaSenha;
	private Date dataUltimoAcesso;
	private List<Cartao> cartoes;
	private Cliente cliente;
	
}
