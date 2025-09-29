package br.com.agi.demo.repository;

import br.com.agi.demo.entity.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarioRepository extends JpaRepository<Calendario,String> {
}
