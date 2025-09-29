package br.com.agi.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank
    private String id;
    @NotBlank
    private String nome;

    @OneToOne
    @JsonIgnoreProperties("usuario")
    private Calendario calendario;
    @OneToOne

    @JsonIgnoreProperties("usuario")
    private Wishlist wishlist;


    public Usuario(String nome){
        this.nome = nome;
    }
}
