package com.poo.trabalho_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poo.trabalho_final.model.Carro;
import com.poo.trabalho_final.model.Multa;

public interface MultaRepository extends JpaRepository<Multa, Integer> {
    @Query("SELECT m FROM Multa m WHERE m.infracao LIKE %:infracao%")
    public List<Multa> findByInfracao(String infracao);
    public Multa findByCarro(Carro carro);
}
