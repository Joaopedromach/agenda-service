package jpmac.com.agenda.api.controller;

import jpmac.com.agenda.api.request.AgendaRequest;
import jpmac.com.agenda.api.response.AgendaResponse;
import jpmac.com.agenda.domain.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/agenda")
public class AgendaController {

    private final AgendaService service;
    @GetMapping
    public ResponseEntity<List<AgendaResponse>> buscarTodos(){

    }
    @GetMapping("/{id}")
    public ResponseEntity<AgendaResponse> buscarPorId(@PathVariable Long id){

    }
    @PostMapping
    public ResponseEntity<AgendaResponse> salvar(@RequestBody AgendaRequest request){

    }
}
