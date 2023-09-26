package com.crudcompleto.crudfeito.repository;

import com.crudcompleto.crudfeito.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
