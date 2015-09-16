package com.paysecure.bcc.dto;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.paysecure.bcc.enums.StatusUsuarioEnum;

import lombok.Data;

@Data
public class Usuario implements UserDetails {
	
	private Long id;
	private Perfil perfil;
	private String login;
	private String nome;
	private String cpf;
	private String senha;
	private StatusUsuarioEnum status;
	private Date dataCriacao;
	private Date dataCanelado;
	private Date dataTrocaSenha;
	private Date dataUltimoAcesso;
	private List<Cartao> cartoes;
	private Cliente cliente;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getPerfil().getFuncionalidades();
	}
	@Override
	public String getPassword() {
		return getSenha();
	}
	@Override
	public String getUsername() {
		return getLogin();
	}
	@Override
	public boolean isAccountNonExpired() {
		return getStatus().equals(StatusUsuarioEnum.ATIVO);
	}
	@Override
	public boolean isAccountNonLocked() {
		return getStatus().equals(StatusUsuarioEnum.ATIVO);
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}
	@Override
	public boolean isEnabled() {
		return getStatus().equals(StatusUsuarioEnum.ATIVO);
	}
	
}
