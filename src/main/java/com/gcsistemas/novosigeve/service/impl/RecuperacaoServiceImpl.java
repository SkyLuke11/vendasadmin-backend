package com.gcsistemas.novosigeve.service.impl;

import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcsistemas.novosigeve.model.entity.Recuperacao;
import com.gcsistemas.novosigeve.model.repository.RecuperacaoRepository;
import com.gcsistemas.novosigeve.service.RecuperacaoService;

@Service
public class RecuperacaoServiceImpl implements RecuperacaoService {

  @Autowired
  private RecuperacaoRepository repository;

  @Override
  public Optional<Recuperacao> findById(Long id) {
    return repository.findById(id);
  }

  @Override
  public Optional<Recuperacao> findByCodigo(String codigo) {
    return repository.findByCodigo(codigo);
  }

  @Override
  @Transactional
  public Recuperacao salvar(Recuperacao recuperacao) {
    return repository.save(recuperacao);
  }

  @Override
  @Transactional
  public void excluir(Recuperacao recuperacao) {
    Objects.requireNonNull(recuperacao.getId());
    repository.delete(recuperacao);
  }

}
