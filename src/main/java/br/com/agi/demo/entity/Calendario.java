package br.com.agi.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Calendario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank
    private String id;

    @OneToOne
    @JsonIgnoreProperties("calendario")
    private Usuario usuario;

    @OneToMany(mappedBy = "calendario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("calendario")
    private List<Compromissos> compromissos = new ArrayList<>();

}
