package com.contabilidade.sistemacontabil.test;

import com.contabilidade.sistemacontabil.model.PessoaJuridica;
import com.contabilidade.sistemacontabil.repository.PessoaFisicaRepository;
import com.contabilidade.sistemacontabil.repository.PessoaJuridicaRepository;
import com.contabilidade.sistemacontabil.service.PessoaFisicaService;
import com.contabilidade.sistemacontabil.service.PessoaJuridicaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class PessoaJuridicaServiceTest {

    @Mock
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    @InjectMocks
    private PessoaJuridicaService pessoaJuridicaService;

    @Test
    public void deveSalvar() {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        Mockito.when(pessoaJuridicaRepository.save(pessoaJuridica)).thenReturn(pessoaJuridica);

        PessoaJuridica pessoaSalva = pessoaJuridicaService.salvar(pessoaJuridica);

        assertNotNull(pessoaSalva);
        assertEquals(pessoaJuridica, pessoaSalva);
    }

    @Test
    public void deveBuscarPorId() {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        Long id = 1L;
        pessoaJuridica.setId(id);
        Mockito.when(pessoaJuridicaRepository.findById(id)).thenReturn(Optional.of(pessoaJuridica));

        Optional<PessoaJuridica> idPessoaJuridica = pessoaJuridicaService.buscarPorId(id);

        assertTrue(idPessoaJuridica.isPresent());
        assertEquals(pessoaJuridica, idPessoaJuridica.get());
    }

    @Test
    public void deveBuscarListaPessoaJuridica() {
        List<PessoaJuridica> listaPessoasJuridicas = Arrays.asList(new PessoaJuridica(), new PessoaJuridica());
        Mockito.when(pessoaJuridicaRepository.findAll()).thenReturn(listaPessoasJuridicas);

        List<PessoaJuridica> listaPessoasJuridicasAdicionadas = pessoaJuridicaService.buscarTodos();

        assertNotNull(listaPessoasJuridicasAdicionadas);
        assertEquals(listaPessoasJuridicas, listaPessoasJuridicasAdicionadas);
    }


    @Test
    public void deveCalcularImpostoDeRendaPessoaJuridicaFaturamentoAte20000() {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        Double faturamentoMensal = 15000.0;
        Double aliquota = 0.15;
        Double impostoAPagar = faturamentoMensal * aliquota;

        Double imposto = pessoaJuridicaService.calcularImpostoDeRendaPessoaJuridica(pessoaJuridica, faturamentoMensal);

        assertEquals(impostoAPagar, imposto);
    }

    @Test
    public void deveCalcularImpostoDeRendaPessoaJuridicaFaturamentoMaiorQue20000() {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        Double faturamentoMensal = 25000.0;
        Double aliquota = 0.25;
        Double impostoAPagar = faturamentoMensal * aliquota;
        pessoaJuridica.setImpostoAPagar(impostoAPagar);

        Double imposto = pessoaJuridicaService.calcularImpostoDeRendaPessoaJuridica(pessoaJuridica, faturamentoMensal);

        assertEquals(impostoAPagar, imposto);
    }
}

