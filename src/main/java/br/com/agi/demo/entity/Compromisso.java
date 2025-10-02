package br.com.agi.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Compromisso {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotBlank
    private String nome;

    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    @ManyToOne
    @JsonIgnoreProperties("compromissos")
    private Calendario calendario;

    @ManyToOne
    @JsonIgnoreProperties("compromissos")
    private Wishlist wishlist;

    public Compromisso(String nome){
        this.nome = nome;
    }

}
