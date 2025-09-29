package br.com.agi.demo.service;


import br.com.agi.demo.dto.requests.CriarUsuarioRequest;
import br.com.agi.demo.dto.response.BaseResponse;
import br.com.agi.demo.entity.Usuario;
import br.com.agi.demo.mapper.UsuarioMapper;
import br.com.agi.demo.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Service
public class UsuarioService {


    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
    }

    public BaseResponse criarUsuario(CriarUsuarioRequest request){
        if (Objects.isNull(request)) {
            return new BaseResponse("Request está nulo.", HttpStatus.NO_CONTENT, null);
        }
        Usuario novoUsuario = UsuarioMapper.map(request);
        usuarioRepository.save(novoUsuario);
        return new BaseResponse("Usuario criado com sucesso", HttpStatus.CREATED, novoUsuario);
    }


}
