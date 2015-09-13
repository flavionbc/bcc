package com.paysecure.bcc.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Cartao {

	private String numero;
	private Integer cvv;
	private Date dataValidade;
	private Usuario usuario;
	
}
