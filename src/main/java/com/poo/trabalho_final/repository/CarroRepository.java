package com.poo.trabalho_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poo.trabalho_final.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer> {

    public Carro findByPlaca(String placa);
    public List<Carro> findByModelo(String modelo);

    @Query("SELECT c FROM Carro c WHERE c.nomeMotorista LIKE %:nomeMotorista%")
    public List<Carro> findBynomeMotorista(String nomeMotorista);
}
