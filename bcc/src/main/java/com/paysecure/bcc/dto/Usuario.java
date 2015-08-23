package com.paysecure.bcc.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 3651368666907404913L;
	
	@Id
	private UsuarioPK id;
	private Long idPerfil;
	private String nome;
	private String cpf;
	private Date dataUltimoAcesso;
	private Integer status;
	private Date dataCanelado;
	private String senha;
	private Date dataTrocaSenha;
	
	public Usuario(){
		
	}
	
	public UsuarioPK getId() {
		return id;
	}

	public void setId(UsuarioPK id) {
		this.id = id;
	}

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(Date dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getDataCanelado() {
		return dataCanelado;
	}

	public void setDataCanelado(Date dataCanelado) {
		this.dataCanelado = dataCanelado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataTrocaSenha() {
		return dataTrocaSenha;
	}

	public void setDataTrocaSenha(Date dataTrocaSenha) {
		this.dataTrocaSenha = dataTrocaSenha;
	}
	
	public String getSequenceName() {
		return "SEQUENCE_USUARIO";
	}
	
}
