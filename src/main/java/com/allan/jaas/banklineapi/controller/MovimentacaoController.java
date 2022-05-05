package com.allan.jaas.banklineapi.controller;

import com.allan.jaas.banklineapi.dtos.MovimentacaoDTO;
import com.allan.jaas.banklineapi.model.Movimentacao;
import com.allan.jaas.banklineapi.repository.MovimentacaoRepository;
import com.allan.jaas.banklineapi.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping
    public List<Movimentacao> findAll(){
        return movimentacaoRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody MovimentacaoDTO movimentacaoDTO){
        movimentacaoService.save(movimentacaoDTO);

    }


}
