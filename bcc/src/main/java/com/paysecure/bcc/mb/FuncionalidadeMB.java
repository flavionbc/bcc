package com.paysecure.bcc.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name="funcionalidadeMB")
@Scope("view")
public class FuncionalidadeMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7082520241948359L;
	private String label;
	private String url;
	
	public void cadastrar(){
		System.out.println("Funcionalidade pega: " + getLabel()  + " URL: " +  getUrl());
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
