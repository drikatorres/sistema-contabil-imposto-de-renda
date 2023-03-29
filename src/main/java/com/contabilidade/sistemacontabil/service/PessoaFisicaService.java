package com.contabilidade.sistemacontabil.service;


import com.contabilidade.sistemacontabil.model.PessoaFisica;
import com.contabilidade.sistemacontabil.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaFisicaService {
    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    public PessoaFisica salvar(PessoaFisica pessoaFisica) {
        return pessoaFisicaRepository.save(pessoaFisica);
    }

    public Optional<PessoaFisica> buscarPorId(Long id) {
        return pessoaFisicaRepository.findById(id);
    }

    public List<PessoaFisica> buscarTodos() {
        return (List<PessoaFisica>) pessoaFisicaRepository.findAll();
    }

    public void excluirPorId(Long id) {
        pessoaFisicaRepository.deleteById(id);
    }

    public Double calcularImpostoDeRendaPessoaFisica(PessoaFisica pessoaFisica, Double salario){
        Double imposto = null;
        if (salario <= 1903.98) {
            imposto = Double.valueOf(0);
            pessoaFisica.setImpostoAPagar(imposto);
            return imposto;
        } else if (salario > 1903.98 && salario <= 2826.65) {
            Double parcelaADeduzir = 142.80;
            Double aliquota = 7.5 / 100;
            imposto = (salario * (aliquota) - parcelaADeduzir);
            pessoaFisica.setImpostoAPagar(imposto);
            return imposto;
        } else if (salario > 2826.65 && salario <= 3751.05) {
            Double aliquota;
            Double parcelaADeduzir;
            parcelaADeduzir = 354.80;
            aliquota = Double.valueOf(15 / 100);
            imposto = (salario * (aliquota) - parcelaADeduzir);
            pessoaFisica.setImpostoAPagar(imposto);
            return imposto;
        } else if (salario > 3751.05 && salario <= 4664.68) {
            Double aliquota;
            Double parcelaADeduzir;
            parcelaADeduzir = 636.13;
            aliquota = Double.valueOf(22.5 / 100);
            imposto = (salario * (aliquota) - parcelaADeduzir);
            pessoaFisica.setImpostoAPagar(imposto);
            return imposto;
        } else if (salario > 4664.68) {
            Double aliquota;
            Double parcelaADeduzir;
            parcelaADeduzir = 869.36;
            aliquota = Double.valueOf(27.5 / 100);
            imposto = (salario * (aliquota) - parcelaADeduzir);
            pessoaFisica.setImpostoAPagar(imposto);
            return imposto;
        }
        
        return imposto;
    }



}
