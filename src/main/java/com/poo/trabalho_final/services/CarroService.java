package com.poo.trabalho_final.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.trabalho_final.model.Carro;
import com.poo.trabalho_final.repository.CarroRepository;

@Service
public class CarroService {

    @Autowired
    CarroRepository repository;

    public Carro insereCarro(Carro c){
        return repository.save(c);
    }
    
    public Carro alteraCarro(Carro c){
        return repository.save(c);
    }

    public Carro findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public void excluiCarro(Carro c){
        repository.delete(c);
    }

    public List<Carro> listAll(){
        return repository.findAll();
    }

    public Carro findByPlaca(String placa){
            return repository.findByPlaca(placa);
    }

    public List<Carro> findByModelo(String modelo){
        return repository.findByModelo(modelo);
    }

    public Carro findByMotorista(String nomeMotorista){
        return repository.findBynomeMotorista(nomeMotorista);
    }
}
