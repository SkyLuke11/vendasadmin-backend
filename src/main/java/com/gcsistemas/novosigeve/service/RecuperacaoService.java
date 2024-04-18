package com.gcsistemas.novosigeve.service;

import java.util.Optional;

import com.gcsistemas.novosigeve.model.entity.Recuperacao;

public interface RecuperacaoService {

  Optional<Recuperacao> findById(Long id);

  Optional<Recuperacao> findByCodigo(String codigo);

  Recuperacao salvar(Recuperacao recuperacao);

  void excluir(Recuperacao recuperacao);

}
