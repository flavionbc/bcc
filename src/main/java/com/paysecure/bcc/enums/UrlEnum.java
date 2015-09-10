package com.paysecure.bcc.enums;

public enum UrlEnum {
	
	USUARIO_URL(1, "http://localhost:8080/bcc-services/api/usuario"),
	//USUARIO_URL(1, "http://localhost:8080/bcc-services/api/v1/usuario");
	
	CLIENTE_URL(2, "http://45.33.115.18/bcc-services/rest/api/v1/cliente");
	
	private Integer codigo;
	private String url;
	
	private UrlEnum(Integer codigo, String url){
		this.codigo = codigo;
		this.url = url;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
