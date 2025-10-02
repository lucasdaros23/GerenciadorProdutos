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
    private String id;
    @NotBlank
    private String nome;
    @NotBlank
    private String senha;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "calendario_id", referencedColumnName = "id")
    @JsonIgnoreProperties("usuario")
    private Calendario calendario;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "wishlist_id", referencedColumnName = "id")
    @JsonIgnoreProperties("usuario")
    private Wishlist wishlist;

    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }
}
