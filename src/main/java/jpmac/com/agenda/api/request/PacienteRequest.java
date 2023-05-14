package jpmac.com.agenda.api.request;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Nome do paciente é obrigatório")
    private String nome;
    @NotBlank(message = "Sobrenome do paciente é obrigatório")
    private String sobrenome;
    private String email;
    @NotBlank(message = "CPF do paciente é obrigatório")
    private String cpf;
}
