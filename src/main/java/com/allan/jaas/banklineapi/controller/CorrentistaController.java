package com.allan.jaas.banklineapi.controller;

import com.allan.jaas.banklineapi.dtos.CorrentistaDTO;
import com.allan.jaas.banklineapi.model.Correntista;
import com.allan.jaas.banklineapi.repository.CorrentistaRepository;
import com.allan.jaas.banklineapi.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntista")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Autowired
    private CorrentistaService correntistaService;

    @GetMapping
    public List<Correntista> findAll(){
        return correntistaRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody CorrentistaDTO correntistaDTO){
        correntistaService.save(correntistaDTO);

    }
}
