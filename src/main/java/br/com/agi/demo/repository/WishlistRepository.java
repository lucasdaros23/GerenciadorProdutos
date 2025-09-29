package br.com.agi.demo.repository;

import br.com.agi.demo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Usuario,String> {
}
