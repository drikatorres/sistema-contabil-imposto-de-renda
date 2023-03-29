package com.contabilidade.sistemacontabil.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class PessoaFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private BigDecimal salarioAnual;
    @Column
    private BigDecimal despesaDedutivel;
    private BigDecimal impostoAPagar;

    public PessoaFisica() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getSalarioAnual() {
        return salarioAnual;
    }

    public void setSalarioAnual(BigDecimal salarioAnual) {
        this.salarioAnual = salarioAnual;
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
