package com.paysecure.bcc.enums;

import lombok.Getter;
import lombok.Setter;

public enum StatusUsuarioEnum {

	ATIVO(1),
	BLOQUEADO(2);
	
	private @Getter @Setter int codigo;
	
	private StatusUsuarioEnum(int codigo){
		this.codigo = codigo;
	}
}
