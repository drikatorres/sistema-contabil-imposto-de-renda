package com.contabilidade.sistemacontabil.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

public class PessoaJuridica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nomeDaEmpresa;
    @Column
    private String cnpj;
    @Column
    private Double faturamentoAnual;
    @Column
    private Double impostoAPagar;

    public PessoaJuridica() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Double getFaturamentoAnual() {
        return faturamentoAnual;
    }

    public void setFaturamentoAnual(Double faturamentoAnual) {
        this.faturamentoAnual = faturamentoAnual;
    }

    public Double getImpostoAPagar() {
        return impostoAPagar;
    }

    public void setImpostoAPagar(Double impostoAPagar) {
        this.impostoAPagar = impostoAPagar;
    }
}
