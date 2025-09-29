package br.com.agi.demo.repository;

import br.com.agi.demo.entity.Compromisso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompromissoRepository extends JpaRepository<Compromisso,String> {
}
