package jpmac.com.agenda.domain.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "agenda")
public class Agenda {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "descricao")
  private String descricao;

  @Column(name = "data_hora")
  private LocalDateTime horario;

  @Column(name = "data_criacao")
  private LocalDateTime dataCriacao;

  @ManyToOne private Paciente paciente;
}
