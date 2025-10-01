package br.com.agi.demo.service;

import br.com.agi.demo.dto.requests.CriarCompromissoCalendarioRequest;
import br.com.agi.demo.dto.requests.CriarCompromissoRequest;
import br.com.agi.demo.dto.requests.CriarCompromissoWishlistRequest;
import br.com.agi.demo.dto.response.BaseResponse;
import br.com.agi.demo.entity.Calendario;
import br.com.agi.demo.entity.Compromisso;
import br.com.agi.demo.entity.Wishlist;
import br.com.agi.demo.mapper.CompromissoMapper;
import br.com.agi.demo.repository.CalendarioRepository;
import br.com.agi.demo.repository.CompromissoRepository;
import br.com.agi.demo.repository.WishlistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CompromissoService {
    private final CompromissoMapper compromissoMapper;
    private final CompromissoRepository compromissoRepository;
    private final CalendarioRepository calendarioRepository;
    private final WishlistRepository wishlistRepository;

    public CompromissoService(CompromissoMapper compromissoMapper, CompromissoRepository compromissoRepository, CalendarioRepository calendarioRepository, WishlistRepository wishlistRepository) {
        this.compromissoMapper = compromissoMapper;
        this.compromissoRepository = compromissoRepository;
        this.calendarioRepository = calendarioRepository;
        this.wishlistRepository = wishlistRepository;
    }

    public BaseResponse criarCompromisso(CriarCompromissoRequest request){
        Compromisso novoCompromisso = CompromissoMapper.map(request);
        /// ADICIONAR OBJETO CALENDARIO OU WISHLIST COM SET CONTA ALGUM BGL ASSIM SLA
        if(request.calendarioId().isBlank() && request.wishlistId().isBlank()){
            return new BaseResponse("Id de calendario/wishlist nao inserido", HttpStatus.NOT_FOUND, null);
        }
        if(calendarioRepository.findById(request.calendarioId()).isEmpty() && wishlistRepository.findById(request.wishlistId()).isEmpty()){
            return new BaseResponse("Calendario/Wishlist nao encontrado", HttpStatus.NOT_FOUND, null);
        }

        novoCompromisso.setCalendario(calendarioRepository.findByUsuarioId(request.calendarioId()));
        novoCompromisso.setWishlist(wishlistRepository.findByUsuarioId(request.wishlistId()));


        calendarioRepository.findById(request.calendarioId()).setUsuario = novoUsuario;
        compromissoRepository.save(novoCompromisso);
        return new BaseResponse("Compromisso criado com sucesso", HttpStatus.CREATED, novoCompromisso);
    }
    /*
    public BaseResponse criarCompromissoCalendario(CriarCompromissoCalendarioRequest request) {

        Optional<Calendario> calendarioOptional = calendarioRepository.findById(request.calendarioId());
        if (calendarioOptional.isEmpty()) {
            return new BaseResponse("Calendario não encontrado.", HttpStatus.BAD_REQUEST, null);
        }

        if (Objects.isNull(request)) {
            return new BaseResponse("Request está nulo.", HttpStatus.NO_CONTENT, null);
        }

        Compromisso novoCompromisso = CompromissoMapper.mapCalendario(request);
        novoCompromisso.setCalendario(calendarioOptional.get());
        compromissoRepository.save(novoCompromisso);

        return new BaseResponse("Compromisso criada com sucesso!", HttpStatus.CREATED, novoCompromisso);
    }


    public BaseResponse criarCompromissoWishlist(CriarCompromissoWishlistRequest request) {

        Optional<Wishlist> wishlistOptional = wishlistRepository.findById(request.wishlistId());
        if (wishlistOptional.isEmpty()) {
            return new BaseResponse("Wishlist não encontrada.", HttpStatus.BAD_REQUEST, null);
        }

        if (Objects.isNull(request)) {
            return new BaseResponse("Request está nulo.", HttpStatus.NO_CONTENT, null);
        }

        Compromisso novoCompromisso = CompromissoMapper.mapWishlist(request);
        novoCompromisso.setWishlist(wishlistOptional.get());
        compromissoRepository.save(novoCompromisso);

        return new BaseResponse("Compromisso criada com sucesso!", HttpStatus.CREATED, novoCompromisso);
    }



     */
    public BaseResponse listarCompromissosPorCalendario(String calendarioId) {
        if (compromissoRepository.findByCalendarioId(calendarioId).isEmpty()) {
            return new BaseResponse("Nenhum compromisso cadastrado.", HttpStatus.NOT_FOUND, null);
        }
        return new BaseResponse("Compromissos criados encontrados.", HttpStatus.OK, compromissoRepository.findByCalendarioId(calendarioId));
    }


    public BaseResponse listarCompromissosPorWishlist(String wishlistId) {
        if (compromissoRepository.findByWishlistId(wishlistId).isEmpty()) {
            return new BaseResponse("Nenhum compromisso cadastrado.", HttpStatus.NOT_FOUND, null);
        }
        return new BaseResponse("Compromissos criados encontrados.", HttpStatus.OK, compromissoRepository.findByWishlistId(wishlistId));
    }

    public BaseResponse listarCompromissos() {
        if (compromissoRepository.findAll().isEmpty()) {
            return new BaseResponse("Nenhum compromisso cadastrado.", HttpStatus.NOT_FOUND, null);
        }
        return new BaseResponse("Compromissos criados encontrados.", HttpStatus.OK, compromissoRepository.findAll());
    }


    public BaseResponse deletarCompromisso(String id) {
        Optional<Compromisso> checkId = compromissoRepository.findById(id);
        if (checkId.isEmpty()) {
            return new BaseResponse("Não foi possivel encontrar um compromisso com esse id", HttpStatus.NOT_FOUND,null);
        }
        compromissoRepository.deleteById(id);
        return new BaseResponse("Usuario deletado com sucesso", HttpStatus.OK,compromissoRepository.findAll());
    }



}
