package jpmac.com.agenda.api.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgendaRequest {
    @NotBlank
    private String descricao;
    @NotNull
    @Future
    private LocalDateTime horario;
    @NotNull
    private Long pacienteId;
}
