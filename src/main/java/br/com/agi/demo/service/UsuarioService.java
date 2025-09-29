package br.com.agi.demo.service;


import br.com.agi.demo.dto.requests.CriarUsuarioRequest;
import br.com.agi.demo.dto.response.BaseResponse;
import br.com.agi.demo.entity.Calendario;
import br.com.agi.demo.entity.Usuario;
import br.com.agi.demo.entity.Wishlist;
import br.com.agi.demo.mapper.CalendarioMapper;
import br.com.agi.demo.mapper.UsuarioMapper;
import br.com.agi.demo.repository.CalendarioRepository;
import br.com.agi.demo.repository.UsuarioRepository;
import br.com.agi.demo.repository.WishlistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class UsuarioService {


    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;
    private final CalendarioRepository calendarioRepository;
    private final WishlistRepository wishlistRepository;

    public UsuarioService(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository, CalendarioRepository calendarioRepository, WishlistRepository wishlistRepository) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
        this.calendarioRepository = calendarioRepository;
        this.wishlistRepository = wishlistRepository;
    }

    public BaseResponse criarUsuario(CriarUsuarioRequest request){
        /// cria usuario
        Usuario novoUsuario = UsuarioMapper.map(request);
        usuarioRepository.save(novoUsuario);

        /// cria calendario
        Calendario novoCalendario = new Calendario();
        calendarioRepository.save(novoCalendario);
        Wishlist novoWishlist = new Wishlist();
        wishlistRepository.save(novoWishlist);

        novoCalendario.setUsuario(novoUsuario);
        novoWishlist.setUsuario(novoUsuario);
        novoUsuario.setCalendario(novoCalendario);
        novoUsuario.setWishlist(novoWishlist);

        return new BaseResponse("Usuario criado com sucesso", HttpStatus.CREATED, novoUsuario);
    }


}
