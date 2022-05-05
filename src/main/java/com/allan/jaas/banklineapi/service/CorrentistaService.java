package com.allan.jaas.banklineapi.service;

import com.allan.jaas.banklineapi.dtos.CorrentistaDTO;
import com.allan.jaas.banklineapi.model.Conta;
import com.allan.jaas.banklineapi.model.Correntista;
import com.allan.jaas.banklineapi.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {
    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(CorrentistaDTO novoCorrentista){
        Correntista correntista = new Correntista();
        Conta conta = new Conta();
        correntista.setNome(novoCorrentista.getNome());
        correntista.setCpf(novoCorrentista.getCpf());
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());
        correntista.setConta(conta);
        correntistaRepository.save(correntista);

    }
}
