package com.paysecure.bcc.enums;

public enum StatusClienteEnum {
	
	ATIVO (1, "ATIVADO"),
	INADIMPLENTE(2, "INADIMPLENTE"),
	BLOQUEADO(3, "BLOQUEADO");
	
	private Integer codigo;
	private String descricao;
	
	private StatusClienteEnum(Integer codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
