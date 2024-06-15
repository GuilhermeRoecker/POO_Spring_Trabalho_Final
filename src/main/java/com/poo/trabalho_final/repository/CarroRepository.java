package com.poo.trabalho_final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.trabalho_final.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer> {

    public Carro findByPlaca(String placa);
    public List<Carro> findByModelo(String modelo);
    public Carro findBynomeMotorista(String nomeMotorista);
}
