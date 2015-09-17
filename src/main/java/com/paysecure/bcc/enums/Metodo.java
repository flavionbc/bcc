package com.paysecure.bcc.enums;

public enum Metodo {

	INSERIR("insert"),
	ALTERAR("update"),
	EXCLUIR("delete");
	
	private String valor;
	
	private Metodo(String valor){
		this.valor = valor;
	}
	
	public String getValor(){
		return valor;
	}
	
	public void setValor(String vv){
		valor = vv;
	}
}
