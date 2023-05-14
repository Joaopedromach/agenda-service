package jpmac.com.agenda.domain.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import jpmac.com.agenda.domain.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
  Optional<Agenda> findByHorario(LocalDateTime horario);
}
