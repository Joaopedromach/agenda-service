package jpmac.com.agenda.domain.service;

import java.util.List;
import java.util.Optional;
import jpmac.com.agenda.domain.entity.Paciente;
import jpmac.com.agenda.domain.repository.PacienteRepository;
import jpmac.com.agenda.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PacienteService {
  // puxar o repository para passar o controle para o spring para nao passar o new eu dou o @Auto
  // final depois que coloco ele nao pode receber outra por cima
  private final PacienteRepository repository;

  public Paciente salvar(Paciente paciente) {
    boolean existeCpf = false;

    Optional<Paciente> optPaciente = repository.findByCpf(paciente.getCpf());

    if (optPaciente.isPresent()) {
      if (!optPaciente.get().getId().equals(paciente.getId())) {
        existeCpf = true;
      }
    }
    if (existeCpf) {
      throw new BusinessException("Cpf já cadastrado!");
    }
    return repository.save(paciente);
  }

  public List<Paciente> listarTodos() {
    return repository.findAll();
  }
  // para buscar por Id eu dou um optional e retorno a classe
  public Optional<Paciente> buscarPorId(Long id) {
    return repository.findById(id);
  }

  public void deletar(Long id) {
    repository.deleteById(id);
  }

  public Paciente alterar(Long id, Paciente paciente) {
    Optional<Paciente> optPaciente = this.buscarPorId(id);

    if (optPaciente.isEmpty()) {
      throw new BusinessException("Paciente nao cadastrado");
    }
    paciente.setId(id);
    return salvar(paciente);
  }
}
