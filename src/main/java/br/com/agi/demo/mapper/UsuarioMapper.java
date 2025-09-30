package br.com.agi.demo.mapper;

import br.com.agi.demo.dto.requests.CriarUsuarioRequest;
import br.com.agi.demo.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public static Usuario map(final CriarUsuarioRequest request){
        return new Usuario(request.nome(), request.senha());
    }
}
