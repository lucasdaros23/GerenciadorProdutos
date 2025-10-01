package br.com.agi.demo.controller.restController;

import br.com.agi.demo.dto.requests.CriarCompromissoWishlistRequest;
import br.com.agi.demo.dto.response.BaseResponse;
import br.com.agi.demo.service.CompromissoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompromissosWishlistController {

    private final CompromissoService compromissoService;

    public CompromissosWishlistController(CompromissoService compromissoService) {
        this.compromissoService = compromissoService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> criarCompromisso(@RequestBody @Valid final CriarCompromissoWishlistRequest request){
        BaseResponse response = compromissoService.criarCompromissoWishlist(request);
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
