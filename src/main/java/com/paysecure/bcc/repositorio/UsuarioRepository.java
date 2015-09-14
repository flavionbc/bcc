package com.paysecure.bcc.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paysecure.bcc.dto.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
