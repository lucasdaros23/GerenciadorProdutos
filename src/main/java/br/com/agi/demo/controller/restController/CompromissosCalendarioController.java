package br.com.agi.demo.controller.restController;

import br.com.agi.demo.dto.requests.CriarCompromissoCalendarioRequest;
import br.com.agi.demo.dto.response.BaseResponse;
import br.com.agi.demo.service.CompromissoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calendario/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompromissosCalendarioController {

    private final CompromissoService compromissoService;

    public CompromissosCalendarioController(CompromissoService compromissoService) {
        this.compromissoService = compromissoService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> criarCompromisso(@RequestBody @Valid final CriarCompromissoCalendarioRequest request){
        BaseResponse response = compromissoService.criarCompromissoCalendario(request);
        return ResponseEntity.status(response.status()).body(response);
    }

    @GetMapping("/{calendarioId}/compromisso")
    public ResponseEntity<BaseResponse> listarCompromissosPorCalendario(@PathVariable String calendarioId){
        BaseResponse response = compromissoService.listarCompromissosPorCalendario(calendarioId);
        return ResponseEntity.status(response.status()).body(response);
    }

    @DeleteMapping("/{calendarioId}/{id}")
    public ResponseEntity<BaseResponse> deletarUsuario(@PathVariable String calendarioId,@PathVariable String id){
        BaseResponse response = compromissoService.deletarCompromisso(id, calendarioId);
        return ResponseEntity.status(response.status()).body(response);
    }
}
