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
    public String paginaInicial(Model model) {
        model.addAttribute("nomeUsuario", "Dev");

        String calendarioIdPrincipal = "e2e5ec95-0ec7-46f1-be99-7ec0a004f52c";

        List<Compromisso> compromissos = compromissoService.listarCompromissosPorCalendario(calendarioIdPrincipal);

        model.addAttribute("compromisso", compromissos.stream().findFirst());
        model.addAttribute("idCalendario", calendarioIdPrincipal);

        return "index";
    }

    @GetMapping("/calendario/{calendarioId}")
    public String paginaCalendario(@PathVariable String calendarioId, Model model) {

        List<Compromisso> compromissos = compromissoRepository.findByCalendarioId(calendarioId);

        model.addAttribute("listaDeCompromissos", compromissos);
        model.addAttribute("idDoCalendario", calendarioId); // Também envia o ID para a página

        return "index";
    }
}