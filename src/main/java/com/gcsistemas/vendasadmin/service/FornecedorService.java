package com.gcsistemas.vendasadmin.service;

import java.util.List;
import java.util.Optional;

import com.gcsistemas.vendasadmin.model.entity.Fornecedor;

public interface FornecedorService {

  List<Fornecedor> buscaTodosRegistros();

  Optional<Fornecedor> buscaRegistro(Long id);

  List<Fornecedor> buscar(Fornecedor filtro);

  Fornecedor salvar(Fornecedor fornecedor);

  Fornecedor atualizar(Fornecedor fornecedor);

  void excluir(Fornecedor fornecedor);

}
