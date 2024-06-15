package com.poo.trabalho_final.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull(message = "Infração não pode estar vazio")
    private String infracao;

    @Column
    @NotNull(message = "Valor não pod estar vazio")
    private Double valor;
    
    @ManyToOne
    @NotNull(message = "Id do carro não pode estar vazio")
    private Carro carro;

    @Override
    public String toString() {
        return "Multa" + 
        "\nId: " + id + 
        "\nInfracao: " + infracao + 
        "\nValor: " + valor + 
        "\nCarro: " + carro + "\n\n";
    }
}
