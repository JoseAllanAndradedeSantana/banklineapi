package com.allan.jaas.banklineapi.repository;

import com.allan.jaas.banklineapi.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao,Integer> {
}
