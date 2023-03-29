package com.contabilidade.sistemacontabil.repository;

import com.contabilidade.sistemacontabil.model.PessoaJuridica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PessoaJuridicaRepository extends CrudRepository<PessoaJuridica, Long> {
    public Double calcularImpostoDeRendaPessoaJuridica(Double faturamentoAnual, Double despesaDedutivel);
}