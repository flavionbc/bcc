package com.paysecure.bcc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Usuario implements Serializable {

	private static final long serialVersionUID = 4467118608241157679L;
	
	private UsuarioPK id;
	private Long idPerfil;
	private String nome;
	private String cpf;
	private String senha;
	private Integer status;
	private Date dataCriacao;
	private Date dataCanelado;
	private Date dataTrocaSenha;
	private Date dataUltimoAcesso;
	private List<Cartao> cartoes;
	
}
