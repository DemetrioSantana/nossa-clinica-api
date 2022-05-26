
CREATE SEQUENCE IF NOT EXISTS especialidade_id_seq
	INCREMENT 1
	MINVALUE 1
	MAXVALUE 9999999999999
	START 1
	CACHE 1; 
	
CREATE TABLE especialidades (
	id_especialidade 	 			BIGINT DEFAULT NEXTVAL('especialidade_id_seq'),
	nome							VARCHAR(60) UNIQUE NOT NULL,
	valor_da_consulta 				DECIMAL,
	
	PRIMARY KEY (id_especialidade)
);	


CREATE SEQUENCE IF NOT EXISTS medico_id_seq
	INCREMENT 1
	MINVALUE 1
	MAXVALUE 9999999999999
	START 1
	CACHE 1;

CREATE TABLE medicos (
	id_medico	 			BIGINT DEFAULT NEXTVAL('medico_id_seq'),
	nome					VARCHAR(200)  NOT NULL,
	registro				VARCHAR(30),
	perfil_id 				BIGINT,
		
	PRIMARY KEY (id_medico),
	FOREIGN KEY (perfil_id) REFERENCES perfis(id_perfil)
);


CREATE TABLE medico_especialidade (
	medico_id	 			BIGINT,
	especialista_id			BIGINT,
	
	FOREIGN KEY (medico_id) REFERENCES medicos(id_medico),
	FOREIGN KEY (especialista_id) REFERENCES especialidades(id_especialidade)
);


CREATE SEQUENCE IF NOT EXISTS data_de_atendimento_id_seq
	INCREMENT 1
	MINVALUE 1
	MAXVALUE 9999999999999
	START 1
	CACHE 1;

CREATE TABLE datas_de_atendimento (
	id_data_atendimento	 	BIGINT DEFAULT NEXTVAL('data_de_atendimento_id_seq'),
	dia						DATE,
	a_partir_de				DATE,  
	medico_id				BIGINT,
	
	PRIMARY KEY (id_data_atendimento),
	FOREIGN KEY (medico_id) REFERENCES medicos(id_medico)
);

