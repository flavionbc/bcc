package com.paysecure.bcc.dto;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class Funcionalidade implements GrantedAuthority {

	private Integer id;
	private String descricao;
	
	@Override
	public String getAuthority() {
		return descricao;
	}
	
}
