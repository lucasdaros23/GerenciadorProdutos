package br.com.agi.demo.mapper;

import br.com.agi.demo.dto.requests.CriarCalendarioRequest;
import br.com.agi.demo.dto.requests.CriarCompromissoRequest;
import br.com.agi.demo.entity.Calendario;
import br.com.agi.demo.entity.Compromisso;
import org.springframework.stereotype.Component;

@Component
public class CompromissoMapper {
    public static Compromisso map(final CriarCompromissoRequest request){
        return new Compromisso(request.nome());
    }
}
