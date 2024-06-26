package com.gcsistemas.vendasadmin.service.impl;

import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gcsistemas.vendasadmin.exception.ErroAutenticacao;
import com.gcsistemas.vendasadmin.exception.RegraNegocioException;
import com.gcsistemas.vendasadmin.model.entity.Usuario;
import com.gcsistemas.vendasadmin.model.repository.UsuarioRepository;
import com.gcsistemas.vendasadmin.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

  @Autowired
  private UsuarioRepository repository;

  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Override
  public Optional<Usuario> findById(Long id) {
    return repository.findById(id);
  }

  @Override
  public Optional<Usuario> findByEmail(String email) {
    return repository.findByEmail(email);
  }

  @Override
  public Usuario autenticar(String email, String senha) {
    Optional<Usuario> usuario = repository.findByEmail(email);

    if (!usuario.isPresent() || !passwordEncoder.matches(senha, usuario.get().getSenha())) {
      throw new ErroAutenticacao("Dados inválidos.");
    }

    return usuario.get();
  }

  @Override
  @Transactional
  public Usuario salvarUsuario(Usuario usuario) {
    validarEmail(usuario.getEmail());
    return repository.save(usuario);
  }

  private void validarEmail(String email) {
    boolean existe = repository.existsByEmail(email);

    if (existe)
      throw new RegraNegocioException("Já existe um usuário cadastrado com esse email.");
  }

  @Override
  @Transactional
  public Usuario alterarSenha(Usuario usuario) {
    Objects.requireNonNull(usuario.getId());
    return repository.save(usuario);
  }

}
