package br.com.agi.demo.service;

import br.com.agi.demo.dto.response.BaseResponse;
import br.com.agi.demo.repository.CalendarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CalendarioService {

    private final CalendarioRepository calendarioRepository;
    public CalendarioService(CalendarioRepository calendarioRepository){
        this.calendarioRepository = calendarioRepository;
    }

    public BaseResponse listarCalendariosPorUsuario(String usuarioId){
        return new BaseResponse("Carteiras cadastradas encontradas.", HttpStatus.OK, calendarioRepository.findByUsuarioId(usuarioId));
}



}
