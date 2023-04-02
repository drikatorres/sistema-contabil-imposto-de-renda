package com.contabilidade.sistemacontabil.repository;

import com.contabilidade.sistemacontabil.model.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
    public Double calcularImpostoDeRendaPessoaFisica(PessoaFisica pessoaFisica, Double salario);
    public Double calcularContribuicaoInss (PessoaFisica pessoaFisica, Double salario);
}



