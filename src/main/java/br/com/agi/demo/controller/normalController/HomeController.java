package br.com.agi.demo.controller.normalController;

import br.com.agi.demo.dto.response.BaseResponse; // Importe BaseResponse
import br.com.agi.demo.entity.Compromisso; // Importe Compromisso
import br.com.agi.demo.repository.CompromissoRepository;
import br.com.agi.demo.service.CompromissoService; // Importe o Service
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // Importe PathVariable
import org.springframework.web.bind.annotation.RestController;

import java.util.List; // Importe List

@Controller
public class HomeController {

    // Injeção de dependência para podermos usar o service
    private final CompromissoService compromissoService;
    private final CompromissoRepository compromissoRepository;

    public HomeController(CompromissoService compromissoService,CompromissoRepository compromissoRepository) {
        this.compromissoService = compromissoService;
        this.compromissoRepository = compromissoRepository;
    }

    @GetMapping("/")
    public String paginaInicial() {
        return "index";
    }


}