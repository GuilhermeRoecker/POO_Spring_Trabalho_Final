package com.poo.trabalho_final.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.trabalho_final.model.Carro;
import com.poo.trabalho_final.model.Multa;
import com.poo.trabalho_final.repository.MultaRepository;

@Service
public class MultaService {
    
    @Autowired
    MultaRepository repository;

    public Multa insereMulta(Multa m){
        return repository.save(m);
    }

    public Multa alteraMulta(Multa m){
        return repository.save(m);
    }

    public void excluiMulta(Multa multa){
        repository.delete(multa);
    }

    public List<Multa> listAll(){
        return repository.findAll();
    }

    public Multa findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public List<Multa> findByInfracao(String infracao){
        return repository.findByInfracao(infracao);
    }

    public Multa findByCarro(Carro carro){
        return repository.findByCarro(carro);
    }
}
