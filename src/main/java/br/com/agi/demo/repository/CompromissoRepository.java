package br.com.agi.demo.repository;

import br.com.agi.demo.entity.Calendario;
import br.com.agi.demo.entity.Compromisso;
import br.com.agi.demo.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompromissoRepository extends JpaRepository<Compromisso,String> {
    List<Compromisso> findByCalendarioId(String compromissoId);
    List<Compromisso> findByWishlistId(String compromissoId);

    List<Compromisso> findFirst3ByCalendarioIdOrderByInicioAsc(String calendarioId);
}
