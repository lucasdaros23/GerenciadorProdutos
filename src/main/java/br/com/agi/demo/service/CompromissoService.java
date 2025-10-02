package br.com.agi.demo.service;

import br.com.agi.demo.dto.requests.CriarCompromissoRequest;
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

import java.util.List;
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

        boolean hasCalendarioId = request.calendarioId() != null && !request.calendarioId().isBlank();
        boolean hasWishlistId = request.wishlistId() != null && !request.wishlistId().isBlank();

        if (hasCalendarioId && hasWishlistId) {
            return new BaseResponse("Um compromisso deve pertencer a um Calendário OU a uma Wishlist, não a ambos.", HttpStatus.BAD_REQUEST, null);
        }
        if (!hasCalendarioId && !hasWishlistId) {
            return new BaseResponse("É necessário fornecer o ID do Calendário ou da Wishlist.", HttpStatus.BAD_REQUEST, null);
        }

        if (hasCalendarioId) {
            Optional<Calendario> calendarioOptional = calendarioRepository.findById(request.calendarioId());
            if (calendarioOptional.isEmpty()) {
                return new BaseResponse("Calendário com o ID fornecido não encontrado.", HttpStatus.NOT_FOUND, null);
            }
            novoCompromisso.setCalendario(calendarioOptional.get());
        }else {
            Optional<Wishlist> wishlistOptional = wishlistRepository.findById(request.wishlistId());

            if (wishlistOptional.isEmpty()) {
                return new BaseResponse("Wishlist com o ID fornecido não encontrada.", HttpStatus.NOT_FOUND, null);
            }
            novoCompromisso.setWishlist(wishlistOptional.get());
        }
        Compromisso compromissoSalvo = compromissoRepository.save(novoCompromisso);

        return new BaseResponse("Compromisso criado com sucesso", HttpStatus.CREATED, novoCompromisso);
    }

    public List<Compromisso> listarCompromissosPorCalendario(String calendarioId) {
        return compromissoRepository.findByCalendarioId(calendarioId);
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
        return new BaseResponse("Compromisso deletado com sucesso", HttpStatus.OK,null);
    }


    public List<Compromisso> listarPreviaCompromissosPorCalendario(String calendarioId) {
        return compromissoRepository.findFirst3ByCalendarioIdOrderByInicioAsc(calendarioId);
    }


}
