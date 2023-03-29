package com.contabilidade.sistemacontabil.service;

import com.contabilidade.sistemacontabil.model.PessoaJuridica;
import com.contabilidade.sistemacontabil.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaJuridicaService {
    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    public PessoaJuridica salvar(PessoaJuridica pessoaJuridica) {
        return pessoaJuridicaRepository.save(pessoaJuridica);
    }

    public Optional<PessoaJuridica> buscarPorId(Long id) {
        return pessoaJuridicaRepository.findById(id);
    }

    public List<PessoaJuridica> buscarTodos() {
        return (List<PessoaJuridica>) pessoaJuridicaRepository.findAll();
    }

    public void excluirPorId(Long id) {
        pessoaJuridicaRepository.deleteById(id);
    }
}
