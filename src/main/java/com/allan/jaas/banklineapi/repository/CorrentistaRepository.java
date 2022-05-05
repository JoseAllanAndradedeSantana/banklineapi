package com.allan.jaas.banklineapi.repository;

import com.allan.jaas.banklineapi.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<Correntista,Integer> {
}
