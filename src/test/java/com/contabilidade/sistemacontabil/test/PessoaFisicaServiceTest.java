package com.contabilidade.sistemacontabil.test;

import com.contabilidade.sistemacontabil.model.PessoaFisica;
import com.contabilidade.sistemacontabil.repository.PessoaFisicaRepository;
import com.contabilidade.sistemacontabil.service.PessoaFisicaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaFisicaServiceTest {

    @Mock
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    @InjectMocks
    private PessoaFisicaService pessoaFisicaService;

    @Test
    public void deveSalvarPessoaFisica() {
        PessoaFisicaRepository mockRepository = mock(PessoaFisicaRepository.class);
        PessoaFisicaService service = new PessoaFisicaService(mockRepository);

        PessoaFisica pessoa = new PessoaFisica();
        pessoa.setNome("Maria");
        pessoa.setCpf("002.333.789-00");
        pessoa.setSalario(3000.00);

        when(mockRepository.save(pessoa)).thenReturn(pessoa);

        PessoaFisica pessoaSalva = service.salvar(pessoa);

        assertEquals(pessoa, pessoaSalva);
    }

    @Test
    public void deveBuscarTodasPessoas() {
        PessoaFisicaRepository mockRepository = mock(PessoaFisicaRepository.class);
        PessoaFisicaService service = new PessoaFisicaService(mockRepository);

        List<PessoaFisica> pessoas = new ArrayList<>();

        PessoaFisica pessoa1 = new PessoaFisica();
        pessoa1.setId(1L);
        pessoa1.setNome("Maria");
        pessoa1.setCpf("002.333.789-00");
        pessoa1.setSalario(3000.00);

        PessoaFisica pessoa2 = new PessoaFisica();
        pessoa2.setId(2L);
        pessoa2.setNome("Mariana");
        pessoa2.setCpf("333.555.8888-00");
        pessoa2.setSalario(2000.00);

        pessoas.add(pessoa1);
        pessoas.add(pessoa2);

        when(mockRepository.findAll()).thenReturn(pessoas);

        List<PessoaFisica> pessoasSalvas = service.buscarTodasPessoas();

        assertEquals(pessoas, pessoasSalvas);
    }


    @Test
    public void calcularImpostoRendaIsencao() {
        PessoaFisica pessoaFisica = new PessoaFisica();
        Double salario = 1000.0;

        Double imposto = pessoaFisicaService.calcularImpostoDeRendaPessoaFisica(pessoaFisica, salario);

        assertEquals(Double.valueOf(0), imposto);
    }

    @Test
    void deveCalcularContribuicaoInss() {
        PessoaFisica pessoaFisica = new PessoaFisica();
        Double salario = 2000.00;
        Double contribuicaoAPagar = salario * (11/100);

        Double contribuicao = pessoaFisicaService.calcularContribuicaoInss(pessoaFisica, salario);

        assertEquals(contribuicaoAPagar, contribuicao, 0.001);
        assertEquals(contribuicaoAPagar, pessoaFisica.getContribuicaoAPagar(), 0.001);
    }
}
