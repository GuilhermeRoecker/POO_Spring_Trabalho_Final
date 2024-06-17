package com.poo.trabalho_final.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poo.trabalho_final.model.Carro;
import com.poo.trabalho_final.model.Multa;

import com.poo.trabalho_final.services.MultaService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/multa")
public class MultaResource {

    @Autowired
    MultaService service;

    @GetMapping
    public String listAll() {
        List<Multa> multa = service.listAll();
        if (multa.isEmpty()) {
            return "Não encontrada nenhuma multa";
        }
        return multa.stream().map(Multa::toString).collect(Collectors.joining(""));
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable String id) {
        try {
            Integer multaId = Integer.parseInt(id);
            Multa multa = service.findById(multaId);
            if (multa == null) {
                return "Nenhuma multa com o id " + id + " encontrada";
            } else {
                return multa.toString();
            }
        } catch (NumberFormatException e) {
            return "O id informado não é valido. Por favor insira um número";
        }
    }

    @GetMapping("/infracao")
    public String findByInfracao(@RequestParam String infracao) {
        List<Multa> multas = service.findByInfracao(infracao);
        if (multas.isEmpty()) {
            return "Não encontrada nenhuma multa cadastrada com a infração: " + infracao;
        }
        return multas.stream().map(Multa::toString).collect(Collectors.joining("\n"));
    }
    

    public ResponseEntity<Multa> findByCarro(Carro carro) {
        try {
            Multa multa = service.findByCarro(carro);
            return ResponseEntity.ok(multa);
        } catch (ObjectNotFoundException e) {
            if (carro == null) {
                return ResponseEntity.notFound().header("messagem", "Carro não encontrado").build();
            }
            return ResponseEntity.notFound().header("messagem", "Carro não encontrado").build();
        }
    }

    @PostMapping
    public String cadastraMulta(@Valid @RequestBody Multa m) {
        try {
            service.insereMulta(m);
            return m.toString();
        } catch (ConstraintViolationException e) {
            return "Erro de validação" + e.getMessage();
        }

    }

    @PutMapping("/{id}")
    public String alteraMulta(@PathVariable String id, @RequestBody Multa m) {
        try {
            Integer multaId = Integer.parseInt(id);
            Multa antiga = service.findById(multaId);
            if (antiga != null) {
                if(m.getCarro() != null){
                    antiga.setCarro(m.getCarro());
                }
                if(m.getInfracao() !=  null){
                    antiga.setInfracao(m.getInfracao());
                }
               if(m.getValor() !=  null){
                antiga.setValor(m.getValor());
               }
                return service.alteraMulta(antiga).toString();
            } else {
                return "Não encontrada nenhuma multa com o id " + id;
            }
        } catch (NumberFormatException e) {
            return "O id informado não é válido. Por favor, insira um número válido.";
        }

    }

    @DeleteMapping("/{id}")
    public String excluiMulta(@PathVariable String id) {
        try {
            Integer multaId = Integer.parseInt(id);
            Multa multa = service.findById(multaId);
            if (multa != null) {
                service.excluiMulta(multa);
                return "Multa com o Id " + id + " apagada com sucesso";
            } else {
                return "Não foi possivel encontrar nenhuma multa com o id " + id;
            }
        } catch (NumberFormatException e) {
            return "O id informado não é válido. Por favor, insira um número válido.";
        }

    }

}
