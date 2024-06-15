package com.poo.trabalho_final.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull(message = "Nome não pode ser vazio")
    private String nomeMotorista;
    
    @Column(length = 7)
    @Size(max = 7)
    @NotNull(message = "Placa não pode estar vazio")
    private String placa;
    
    @Column
    @NotNull(message = "Modelo não pode estar vazio")
    private String modelo;

    @Column
    @NotNull(message = "Cor não pode estar vazio")
    private String cor;

    @Override
    public String toString() {
        return 
        "id: " + id 
        + "\nMotorista: " + nomeMotorista 
        + "\nplaca: " + placa 
        + "\nModelo: " + modelo
        + "\nCor: " + cor + "\n\n";
    }
}
