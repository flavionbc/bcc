package com.paysecure.bcc.enums;

public enum UrlEnum {
	
	USUARIO_URL(1, "http://localhost:8080/bcc-services/api/v1/usuario");
	//USUARIO_URL(1, "http://localhost:8080/bcc-services/api/v1/usuario");
	
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
