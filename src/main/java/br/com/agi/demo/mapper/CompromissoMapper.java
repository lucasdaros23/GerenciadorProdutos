package br.com.agi.demo.mapper;

import br.com.agi.demo.dto.requests.CriarCompromissoCalendarioRequest;
import br.com.agi.demo.dto.requests.CriarCompromissoWishlistRequest;
import br.com.agi.demo.entity.Compromisso;
import org.springframework.stereotype.Component;

@Component
public class CompromissoMapper {
    public static Compromisso mapCalendario(final CriarCompromissoCalendarioRequest request){
        return new Compromisso(request.nome());
    }
    public static Compromisso mapWishlist(final CriarCompromissoWishlistRequest request){
        return new Compromisso(request.nome());
    }
}
