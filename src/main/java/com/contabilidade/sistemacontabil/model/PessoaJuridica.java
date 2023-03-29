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
    private BigDecimal faturamentoAnual;
    @Column
    private BigDecimal despesaDedutivel;
    @Column
    private BigDecimal impostoAPagar;

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

    public BigDecimal getFaturamentoAnual() {
        return faturamentoAnual;
    }

    public void setFaturamentoAnual(BigDecimal faturamentoAnual) {
        this.faturamentoAnual = faturamentoAnual;
    }

    public BigDecimal getDespesaDedutivel() {
        return despesaDedutivel;
    }

    public void setDespesaDedutivel(BigDecimal despesaDedutivel) {
        this.despesaDedutivel = despesaDedutivel;
    }

    public BigDecimal getImpostoAPagar() {
        return impostoAPagar;
    }

    public void setImpostoAPagar(BigDecimal impostoAPagar) {
        this.impostoAPagar = impostoAPagar;
    }
}
