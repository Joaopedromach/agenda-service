CREATE TABLE agenda(
	id serial PRIMARY KEY,
	descricao VARCHAR(255),
	data_hota TIMESTAMP,
	data_criacao timestamp,
	paciente_id integer,
	CONSTRAINT fk_agenda_paciente FOREIGN KEY(paciente_id) REFERENCES paciente(id)
);