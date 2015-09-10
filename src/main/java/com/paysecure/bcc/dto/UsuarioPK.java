package com.paysecure.bcc.dto;

import java.io.Serializable;

public class UsuarioPK implements Serializable{

	private static final long serialVersionUID = -7564669046415548102L;
	
	private Long id;
	private Long idCliente;
	
	public UsuarioPK(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
}
