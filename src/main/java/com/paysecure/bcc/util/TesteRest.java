package com.paysecure.bcc.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.paysecure.bcc.client.AbstractRest;
import com.paysecure.bcc.dto.Funcionalidade;
import com.paysecure.bcc.dto.Perfil;
import com.paysecure.bcc.dto.Usuario;
import com.paysecure.bcc.enums.StatusUsuarioEnum;
import com.paysecure.bcc.enums.UrlEnum;

public class TesteRest extends AbstractRest {
	
	public static void main(String[] args) {
		new TesteRest().cadastrar();
	}
	
	private void cadastrar(){
	
		try{
			Usuario c= new Usuario();
			c.setNome("ALEXANDRE DIAS");
			c.setDataCriacao(new Date());;
			c.setSenha("123");
			c.setCpf("123");
			c.setStatus(StatusUsuarioEnum.ATIVO);;
			c.setLogin("alexandre.dias");
			c.setPerfil(getPerfis());
			Map<String, String> vars = new HashMap<String, String>();
	        vars.put("id", "JS01");
	        
			RestTemplate rt = getRestTemplate();
			String url = getUrl(UrlEnum.USUARIO_URL.getUrl(), "insert");
			rt.postForObject(url, c, Usuario.class);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private Perfil getPerfis(){
		Funcionalidade f = new Funcionalidade();
		f.setDescricao("TUDO");
		f.setId(1);
		Perfil p = new Perfil();
		p.setDescricao("ADMIN");
		p.setId(1);
		p.setFuncionalidades(new ArrayList<Funcionalidade>(Arrays.asList(f)));
		List<Perfil> per = new ArrayList<Perfil>();
		per.add(p);
		
		return p;
	}
}
