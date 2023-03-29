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
    private Double salario;
    private Double impostoAPagar;

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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salarioAnual) {
        this.salario = salario;
    }

    public Double getImpostoAPagar() {
        return impostoAPagar;
    }

    public void setImpostoAPagar(Double impostoAPagar) {
        this.impostoAPagar = impostoAPagar;
    }
}
