package com.allan.jaas.banklineapi.service;

import com.allan.jaas.banklineapi.dtos.MovimentacaoDTO;
import com.allan.jaas.banklineapi.enums.MovimentacaoTipo;
import com.allan.jaas.banklineapi.model.Correntista;
import com.allan.jaas.banklineapi.model.Movimentacao;
import com.allan.jaas.banklineapi.repository.CorrentistaRepository;
import com.allan.jaas.banklineapi.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(MovimentacaoDTO movimentacaoDTO){
        Movimentacao movimentacao = new Movimentacao();

        Double valor = movimentacaoDTO.getTipo() == MovimentacaoTipo.RECEITA
                ? movimentacaoDTO.getValor() : movimentacaoDTO.getValor() * -1;
        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(movimentacaoDTO.getDescricao());
        movimentacao.setIdConta(movimentacaoDTO.getIdConta());
        movimentacao.setTipo(movimentacaoDTO.getTipo());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.findById(movimentacaoDTO.getIdConta()).orElse(null);
        if(correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        movimentacaoRepository.save(movimentacao);
    }
}
