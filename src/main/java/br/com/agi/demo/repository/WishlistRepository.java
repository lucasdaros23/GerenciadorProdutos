package br.com.agi.demo.repository;

import br.com.agi.demo.entity.Calendario;
import br.com.agi.demo.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist,String> {
    Wishlist findByUsuarioId(String usuarioId);
}
