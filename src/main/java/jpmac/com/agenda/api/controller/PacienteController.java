package jpmac.com.agenda.api.controller;

import jakarta.validation.Valid;
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
    private final PacienteMapper mapper;
    @PostMapping
    public ResponseEntity<Paciente> salvar(@Valid @RequestBody PacienteRequest request){
        Paciente paciente = mapper.toPaciente(request);
        Paciente pacienteSalvo = service.salvar(paciente);
        PacienteResponse pacienteResponse = mapper.toPacienteResponse(pacienteSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);
    }
    @GetMapping
    public ResponseEntity<List<PacienteResponse>> listarTodos(){
        List<Paciente> pacientes = service.listarTodos();
        List<PacienteResponse> pacienteResponses = mapper.toPacienteResponseList(pacientes);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteResponses);
    }
    @GetMapping("/{id}")
    public ResponseEntity <PacienteResponse> buscarPorId(@PathVariable Long id){
        Optional<Paciente> optPacientes = service.buscarporId(id);
        if (optPacientes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toPacienteResponse(optPacientes.get()));
    }
    @PutMapping
    public ResponseEntity<PacienteResponse> alterar(@PathVariable Long id,@RequestBody PacienteRequest request){
        Paciente paciente = mapper.toPaciente(request);
        Paciente pacienteSalvo = service.alterar(id, paciente);
        PacienteResponse pacienteResponse = mapper.toPacienteResponse(pacienteSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
