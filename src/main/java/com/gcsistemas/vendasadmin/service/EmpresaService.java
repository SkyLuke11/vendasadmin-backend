package com.gcsistemas.vendasadmin.service;

import java.util.List;
import java.util.Optional;

import com.gcsistemas.vendasadmin.model.entity.Empresa;

public interface EmpresaService {

  List<Empresa> buscaTodosRegistros();

  Optional<Empresa> buscaRegistro(Long id);

  List<Empresa> buscar(Empresa filtro);

  Empresa salvar(Empresa empresa);

  Empresa atualizar(Empresa empresa);

  void excluir(Empresa empresa);

}
