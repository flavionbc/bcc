package com.paysecure.bcc.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Cartao implements Serializable {

	private static final long serialVersionUID = -7965842047305445802L;
	
	private String numero;
	private Integer cvv;
	private Date dataValidade;
	
}
