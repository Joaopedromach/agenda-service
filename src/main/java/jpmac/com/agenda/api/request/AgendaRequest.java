package jpmac.com.agenda.api.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgendaRequest {
  @NotBlank private String descricao;
  @NotNull @Future @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
  private LocalDateTime horario;
  @NotNull private Long pacienteId;
}
