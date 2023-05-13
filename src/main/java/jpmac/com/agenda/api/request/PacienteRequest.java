package jpmac.com.agenda.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteRequest {
    //nao precisa mandar o id na request
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
}
