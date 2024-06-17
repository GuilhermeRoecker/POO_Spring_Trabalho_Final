package com.poo.trabalho_final.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.poo.trabalho_final.services.CarroService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/carro")
public class CarroResource {

    @Autowired
    CarroService service;

    @GetMapping
    public String listAll() {
        List<Carro> carro = service.listAll();
        if (carro.isEmpty()) {
            return "Nenhum carro cadastrado";
        }
        return carro.stream().map(Carro::toString).collect(Collectors.joining(""));
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable String id) {
        try {
            Integer carroId = Integer.parseInt(id);
            Carro carro = service.findById(carroId);
            if (carro == null) {
                return "Nenhum carro encontrado com o id: " + id;
            } else {
                return carro.toString();
            }
        } catch (NumberFormatException e) {
            return "O id informado não é válido. Por favor, insira um número válido. ";
        }

    }

    @GetMapping("/modelo/{modelo}")
    public String listByModelo(@PathVariable String modelo) {
        List<Carro> carro = service.findByModelo(modelo);
        if (carro.isEmpty()) {
            return "Não encontrado nenhum carro do modelo: " + modelo;
        }
        return carro.stream().map(Carro::toString).collect(Collectors.joining(""));
    }

    @GetMapping("/placa/{placa}")
    public String findByPlaca(@PathVariable String placa) {
        Carro carro = service.findByPlaca(placa);
        if (placa.length() < 7 || placa.length() > 7) {
            return "Placa " + placa + " Invalida";
        }
        if (carro == null) {
            return "Não encatrando nenhum carro com a placa: " + placa;
        }
        return carro.toString();
    }


    @GetMapping("/motorista")
    public String findByMotorista(@RequestParam String nomeMotorista) {
        List<Carro> carro = service.findByMotorista(nomeMotorista);
        if (carro != null) {
            return carro.stream().map(Carro::toString).collect(Collectors.joining(""));
        }
        return "Não encontrado nenhum motorista com o nome: " + nomeMotorista;
    }
    

    @PostMapping
    public String cadastraCarro(@Valid @RequestBody Carro c) {
        try {
            service.insereCarro(c);
            return c.toString();
        } catch (ConstraintViolationException e) {
            return "Erro de validação" + e.getMessage();
        }
    }

    @PutMapping("/{id}")
    public String alteraCarro(@PathVariable String id, @RequestBody Carro c) {
        try {
            Integer carroId = Integer.parseInt(id);
            Carro antigo = service.findById(carroId);
            if (antigo != null) {
                if(c.getNomeMotorista() != null){
                    antigo.setNomeMotorista(c.getNomeMotorista());
                }
                if(c.getModelo() != null ){
                    antigo.setModelo(c.getModelo());
                }
                if(c.getPlaca() != null){
                    antigo.setPlaca(c.getPlaca());
                }
                if(c.getCor() != null){
                    antigo.setCor(c.getCor());
                }
                return service.alteraCarro(antigo).toString();
            } else {
                return "Não encontrado nenhum carro com o id:  " + id;
            }
        } catch (NumberFormatException e) {
            return "O id informado não é válido. Por favor, insira um número válido.";
        }catch(ConstraintViolationException e){
            return "A placa deve estar no formato abc-123";
        }
    }

    @DeleteMapping("/{id}")
    public String excluiCarro(@PathVariable String id) {
        try {
            Integer carroId = Integer.parseInt(id);
            Carro carro = service.findById(carroId);
            if (carro != null) {
                service.excluiCarro(carro);
                return "Carro com o id: " + carroId + " foi apagado com sucesso";
            } else {
                return "Não foi possível encontrar e apagar nenhum carro com o id: " + carroId;
            }
        } catch (NumberFormatException e) {
            return "O id informado não é válido. Por favor, insira um número válido.";
        }
    }
}
