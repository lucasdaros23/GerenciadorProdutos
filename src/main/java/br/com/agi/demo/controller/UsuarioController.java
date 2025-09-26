package br.com.agi.demo.controller;

import br.com.agi.demo.dto.requests.CriarUsuarioRequest;
import br.com.agi.demo.dto.response.BaseResponse;
import br.com.agi.demo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> criarUsuarios(@RequestBody @Valid final CriarUsuarioRequest request){
        BaseResponse response = usuarioService.criarUsuario(request);
        return ResponseEntity.status(response.status()).body(response);
    }




}