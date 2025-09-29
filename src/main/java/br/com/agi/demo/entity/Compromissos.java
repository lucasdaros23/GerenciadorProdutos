package br.com.agi.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Compromissos {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank
    private String id;

    @NotBlank
    private String nome;

    private String desc;

    private Color cor;

    private LocalDateTime horarioData;

    @ManyToOne
    @JsonIgnoreProperties("compromissos")
    private Calendario calendario;

    @ManyToOne
    @JsonIgnoreProperties("compromissos")
    private Wishlist wishlist;

    public Compromissos(String nome, String desc, Color cor){
        this.nome = nome;
        this.desc = desc;
        this.cor = cor;
    }
}
