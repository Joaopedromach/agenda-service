package jpmac.com.agenda.api.controller;

import jpmac.com.agenda.api.mapper.PacienteMapper;
import jpmac.com.agenda.api.request.PacienteRequest;
import jpmac.com.agenda.api.response.PacienteResponse;
import jpmac.com.agenda.domain.entity.Paciente;
import jpmac.com.agenda.domain.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/paciente")
public class PacienteController {
    
    private final PacienteService service;
    @PostMapping
    public ResponseEntity<Paciente> salvar(@RequestBody PacienteRequest request){
        Paciente paciente = PacienteMapper.toPaciente(request);
        Paciente pacienteSalvo = service.salvar(paciente);
        PacienteResponse pacienteResponse = PacienteMapper.toPacienteResponse(pacienteSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);
    }
    @GetMapping
    public ResponseEntity <List<Paciente>> listarTodos(){
        List<Paciente> pacientes = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(pacientes);
    }
    @GetMapping("/{id}")
    public ResponseEntity <Paciente> buscarPorId(@PathVariable Long id){
        Optional<Paciente> optPacientes = service.buscarporId(id);
        if (optPacientes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(optPacientes.get());
    }
    @PutMapping
    public ResponseEntity<Paciente> alterar(@RequestBody Paciente paciente){
        Paciente pacienteSalvo = service.salvar(paciente);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteSalvo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
