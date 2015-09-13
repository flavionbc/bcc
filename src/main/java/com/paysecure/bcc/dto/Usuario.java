package com.paysecure.bcc.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Usuario {

	private UsuarioPK id;
	private Long idPerfil;
	private String nome;
	private String cpf;
	private Date dataUltimoAcesso;
	private Integer status;
	private Date dataCanelado;
	private String senha;
	private Date dataTrocaSenha;
	private List<Cartao> cartoes;
	
}
