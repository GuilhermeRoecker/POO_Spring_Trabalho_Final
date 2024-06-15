package com.poo.trabalho_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.trabalho_final.model.Carro;
import com.poo.trabalho_final.model.Multa;

public interface MultaRepository extends JpaRepository<Multa, Integer> {
    public List<Multa> findByInfracao(String infracao);
    public Multa findByCarro(Carro carro);
}
