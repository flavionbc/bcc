package com.paysecure.bcc.client.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.paysecure.bcc.dto.Perfil;

@Service
public class PerfilRestImpl {

	public List<Perfil> buscarPerfis() {
		
		Perfil p = new Perfil();
		p.setId(1);
		p.setDescricao("USUARIO");
		List<Perfil> perfis = new ArrayList<Perfil>();
		perfis.add(p);
		
		return perfis;
	}

	
}
