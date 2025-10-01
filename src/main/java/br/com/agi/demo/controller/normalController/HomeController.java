package br.com.agi.demo.controller.normalController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Este método irá responder a requisições na URL raiz (ex: http://localhost:8080/)
    @GetMapping("/")
    public String paginaInicial(Model model) {
        model.addAttribute("nomeUsuario", "Dev");

        return "index";
    }
}