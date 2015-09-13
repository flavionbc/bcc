package com.paysecure.bcc.dto;

import java.util.List;

import lombok.Data;

@Data
public class Perfil {

	private Integer id;
	private String descricao;
	private List<Funcionalidade> funcionalidades;
}
