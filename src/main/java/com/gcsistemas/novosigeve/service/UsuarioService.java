package com.gcsistemas.novosigeve.service;

import java.util.Optional;

import com.gcsistemas.novosigeve.model.entity.Usuario;

public interface UsuarioService {

		Optional<Usuario> findById(Long id);
	
		Usuario autenticar(String email, String senha);
		
		Usuario salvarUsuario(Usuario usuario);
		
		Usuario alterarSenha(Usuario usuario);
		
}