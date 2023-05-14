package jpmac.com.agenda.domain.service;

import jpmac.com.agenda.domain.entity.Agenda;
import jpmac.com.agenda.domain.repository.AgendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AgendaService {
    private final AgendaRepository repository;

    public List<Agenda> listarTodos(){
        return repository.findAll();
    }
    public Optional<Agenda>buscarPorId(Long id){
        return repository.findById(id);
    }
    public Agenda salvar(Agenda agenda){
        return repository.save(agenda);
    }
}
