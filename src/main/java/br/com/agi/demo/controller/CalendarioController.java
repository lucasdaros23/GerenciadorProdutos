package br.com.agi.demo.controller;


import br.com.agi.demo.dto.response.BaseResponse;
import br.com.agi.demo.service.CalendarioService;
import br.com.agi.demo.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calendario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CalendarioController {

    private final CalendarioService calendarioService;

    public CalendarioController(CalendarioService calendarioService) {
        this.calendarioService = calendarioService;
    }
/*
    @GetMapping("/usuario/${id}")
    public ResponseEntity<BaseResponse> listarUsuarios(@PathVariable String id){
        BaseResponse response = calendarioService.listarCalendariosPorUsuario(id);
        return ResponseEntity.status(response.status()).body(response);

    }

 */


}
