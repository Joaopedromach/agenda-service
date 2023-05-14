package jpmac.com.agenda.api.mapper;

import jpmac.com.agenda.api.request.PacienteRequest;
import jpmac.com.agenda.api.response.PacienteResponse;
import jpmac.com.agenda.domain.entity.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteMapper {
    public static Paciente toPaciente(PacienteRequest request){
        Paciente paciente = new Paciente();
        paciente.setNome(request.getNome());
        paciente.setSobrenome(request.getSobrenome());
        paciente.setEmail(request.getEmail());
        paciente.setCpf(request.getCpf());
        return paciente;
    }
    public static PacienteResponse toPacienteResponse(Paciente paciente){
        PacienteResponse response = new PacienteResponse();
        response.setId(paciente.getId());
        response.setNome(paciente.getNome());
        response.setSobrenome(paciente.getSobrenome());
        response.setEmail(paciente.getEmail());
        response.setCpf(paciente.getCpf());
        return response;
    }

    public static List<PacienteResponse> toPacienteResponseList(List<Paciente> pacientes) {
       List<PacienteResponse> responses = new ArrayList<>();
       for (Paciente paciente : pacientes){
           responses.add(toPacienteResponse(paciente));
       }
       return responses;
    }
}