package br.com.agi.demo.mapper;

import br.com.agi.demo.dto.requests.CriarCompromissosRequest;
import br.com.agi.demo.entity.Compromissos;
import org.springframework.stereotype.Component;

@Component
public class CompromissosMapper {
    public static Compromissos map(final CriarCompromissosRequest request){
        return new Compromissos();
    }
    public Compromissos toEntity(Compromissos compromissos) {
        return compromissos;
    }
}
