package jpmac.com.agenda.api.mapper;

import java.util.List;
import java.util.stream.Collectors;
import jpmac.com.agenda.api.request.AgendaRequest;
import jpmac.com.agenda.api.response.AgendaResponse;
import jpmac.com.agenda.domain.entity.Agenda;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgendaMapper {
  private final ModelMapper mapper;

  public Agenda toAgenda(AgendaRequest request) {
    return mapper.map(request, Agenda.class);
  }

  public AgendaResponse toAgendaResponse(Agenda agenda) {
    return mapper.map(agenda, AgendaResponse.class);
  }

  public List<AgendaResponse> toAgendaResponseList(List<Agenda> agendas) {
    return agendas.stream().map(this::toAgendaResponse).collect(Collectors.toList());
  }
}
