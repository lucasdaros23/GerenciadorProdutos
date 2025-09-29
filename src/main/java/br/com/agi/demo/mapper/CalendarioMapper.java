package br.com.agi.demo.mapper;

import br.com.agi.demo.dto.requests.CriarCalendarioRequest;
import br.com.agi.demo.entity.Calendario;
import org.springframework.stereotype.Component;

@Component
public class CalendarioMapper {
    public static Calendario map(final CriarCalendarioRequest request){
        return new Calendario();
    }
    public Calendario toEntity(Calendario calendario) {
        return calendario;
    }
}
