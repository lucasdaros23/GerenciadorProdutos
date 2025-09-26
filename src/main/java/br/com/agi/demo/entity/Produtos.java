package br.com.agi.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank
    private String id;
    @NotBlank
    private String nome;

    @ManyToOne
    @JsonIgnoreProperties("produtos")
    private Usuario usuario;

    @ManyToOne
    @JsonIgnoreProperties("produtos")
    private Estoque estoque;

    public Produtos(String nome){
        this.nome = nome;
    }

}
