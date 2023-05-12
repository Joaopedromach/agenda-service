package agenda.com.agenda.api;

import agenda.com.agenda.domain.entity.Paciente;
import agenda.com.agenda.domain.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/paciente")
public class PacienteController {
    
    private final PacienteService service;
    @PostMapping
    public ResponseEntity <Paciente> salvar(@RequestBody Paciente paciente){
        Paciente pacienteSalvo = service.salvar(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);

    }
    @GetMapping
    public ResponseEntity <List<Paciente>> listarTodos(){
        List<Paciente> pacientes = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(pacientes);
    }
}
