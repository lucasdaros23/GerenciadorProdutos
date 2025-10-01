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

    @GetMapping("/{wishlistId}/compromisso")
    public ResponseEntity<BaseResponse> listarCompromissosPorWishlist(@PathVariable String wishlistId){
        BaseResponse response = compromissoService.listarCompromissosPorWishlist(wishlistId);
        return ResponseEntity.status(response.status()).body(response);
    }

    @DeleteMapping("/{wishlistId}/compromisso/{id}")
    public ResponseEntity<BaseResponse> deletarUsuario(@PathVariable String wishlistId, @PathVariable String id){
        BaseResponse response = compromissoService.deletarCompromisso(id, wishlistId);
        return ResponseEntity.status(response.status()).body(response);
    }
}
