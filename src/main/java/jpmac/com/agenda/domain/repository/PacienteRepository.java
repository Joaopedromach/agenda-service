package jpmac.com.agenda.domain.repository;

import java.util.Optional;
import jpmac.com.agenda.domain.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

  Optional<Paciente> findByCpf(String cpf);
}
