package br.com.agi.demo.mapper;

import br.com.agi.demo.dto.requests.CriarCompromissoRequest;
import br.com.agi.demo.entity.Compromisso;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CompromissoMapper {
    public static Compromisso map(final CriarCompromissoRequest request){
        Compromisso compromisso = new Compromisso();
        compromisso.setNome(request.nome());
        compromisso.setDescricao(request.descricao());
        compromisso.setInicio(request.inicio());
        compromisso.setFim(request.fim());

        compromisso.setDataCriacao(LocalDateTime.now());

        return compromisso;
    }
}
