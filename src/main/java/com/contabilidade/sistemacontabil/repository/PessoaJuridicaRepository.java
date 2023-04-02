package com.contabilidade.sistemacontabil.repository;

import com.contabilidade.sistemacontabil.model.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {
    public Double calcularImpostoDeRendaPessoaJuridica(Double faturamentoAnual, Double despesaDedutivel);
}