package jpmac.com.agenda.api.response;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgendaResponse {

  private Long id;
  private String descricao;
  private LocalDateTime horario;
  private LocalDateTime dataCriacao;
  private PacienteResponse paciente;
}