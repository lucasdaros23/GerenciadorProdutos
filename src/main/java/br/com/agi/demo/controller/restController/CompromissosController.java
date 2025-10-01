package br.com.agi.demo.controller.restController;

import br.com.agi.demo.dto.requests.CriarCompromissoRequest;
import br.com.agi.demo.dto.requests.CriarCompromissoWishlistRequest;
import br.com.agi.demo.dto.response.BaseResponse;
import br.com.agi.demo.service.CompromissoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compromisso")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompromissosController {

    private final CompromissoService compromissoService;

    public CompromissosController(CompromissoService compromissoService) {
        this.compromissoService = compromissoService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> criarCompromisso(@RequestBody @Valid final CriarCompromissoRequest request){
        BaseResponse response = compromissoService.criarCompromisso(request);
        return ResponseEntity.status(response.status()).body(response);
    }

    @GetMapping("/compromisso")
    public ResponseEntity<BaseResponse> listarCompromissos(){
        BaseResponse response = compromissoService.listarCompromissos();
        return ResponseEntity.status(response.status()).body(response);
    }

    @DeleteMapping("/compromisso/{id}")
    public ResponseEntity<BaseResponse> deletarCompromisso(@PathVariable String id){
        BaseResponse response = compromissoService.deletarCompromisso(id);
        return ResponseEntity.status(response.status()).body(response);
    }
}
