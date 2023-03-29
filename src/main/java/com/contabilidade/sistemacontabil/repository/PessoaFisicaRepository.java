package com.contabilidade.sistemacontabil.repository;

import com.contabilidade.sistemacontabil.model.PessoaFisica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PessoaFisicaRepository extends CrudRepository<PessoaFisica, Long> {
    public BigDecimal calcularImpostoDeRendaPessoaFisica(BigDecimal salarioAnual, BigDecimal despesaDedutivel);
}



