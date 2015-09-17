package com.paysecure.bcc.util;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import com.paysecure.bcc.dto.Cartao;

@ManagedBean
public class Formatador {
	
	public String mascararCartao(String cartao){
		return cartao.substring(0, 4) + ".****.****." + cartao.substring(12);
	}
	
	public String mascararCartao(Cartao cartao){
		return cartao.getNumero().substring(0, 4) + ".****.****." + cartao.getNumero().substring(12);
	}

	public Date dia(){
		return new Date();
	}
}
