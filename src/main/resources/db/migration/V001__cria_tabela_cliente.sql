
CREATE SEQUENCE IF NOT EXISTS cidade_id_seq
	INCREMENT 1
	MINVALUE 1
	MAXVALUE 9999999999999
	START 1
	CACHE 1; 
	
CREATE TABLE cidades (
	id_cidade 	 			BIGINT DEFAULT NEXTVAL('cidade_id_seq'),
	nome					VARCHAR(200)  NOT NULL,
	uf		 				VARCHAR(2),
	
	PRIMARY KEY (id_cidade)
);	


CREATE SEQUENCE IF NOT EXISTS endereco_id_seq
	INCREMENT 1
	MINVALUE 1
	MAXVALUE 9999999999999
	START 1
	CACHE 1;

CREATE TABLE enderecos (
	id_endereco	 			BIGINT DEFAULT NEXTVAL('endereco_id_seq'),
	logradouro				VARCHAR(200)  NOT NULL,
	tipo_de_rua				SMALLINT,
	numero	 				VARCHAR(20)   UNIQUE NOT NULL,
	bairro					VARCHAR(200)  UNIQUE NOT NULL,	
	cep						VARCHAR(20)   UNIQUE NOT NULL,
	cidade_id				BIGINT NOT NULL,
	
	PRIMARY KEY (id_endereco),
	FOREIGN KEY (cidade_id) REFERENCES cidades(id_cidade)
);


CREATE SEQUENCE IF NOT EXISTS contato_id_seq
	INCREMENT 1
	MINVALUE 1
	MAXVALUE 9999999999999
	START 1
	CACHE 1;

CREATE TABLE contatos (
	id_contato	 			BIGINT DEFAULT NEXTVAL('contato_id_seq'),
	celular					VARCHAR(15),  
	email					VARCHAR(60),
	instagram 				VARCHAR(60),
	tem_whatsapp			SMALLINT,	
	
	PRIMARY KEY (id_contato)
);

CREATE SEQUENCE IF NOT EXISTS perfil_id_seq
	INCREMENT 1
	MINVALUE 1
	MAXVALUE 9999999999999
	START 1
	CACHE 1;

CREATE TABLE perfis (
	id_perfil	 			BIGINT DEFAULT NEXTVAL('perfil_id_seq'),
	diretorio				VARCHAR(200),
	
	PRIMARY KEY (id_perfil)
);


CREATE SEQUENCE IF NOT EXISTS usuario_id_seq
	INCREMENT 1
	MINVALUE 1
	MAXVALUE 9999999999999
	START 1
	CACHE 1;

CREATE TABLE usuarios (
	id_usuario	 			BIGINT DEFAULT NEXTVAL('usuario_id_seq'),
	user_name				VARCHAR(60),
	senha					VARCHAR(15),
	celular					VARCHAR(15),  
	email					VARCHAR(60),
	ativo					SMALLINT,
	permissao				SMALLINT,
	perfil_id				BIGINT,
	
	PRIMARY KEY (id_usuario),
	FOREIGN KEY (perfil_id) REFERENCES perfis(id_perfil)
);


CREATE SEQUENCE IF NOT EXISTS cliente_id_seq
	INCREMENT 1
	MINVALUE 1
	MAXVALUE 9999999999999
	START 1
	CACHE 1;

CREATE TABLE clientes (
	id_cliente	 			BIGINT DEFAULT NEXTVAL('cliente_id_seq'),
	contato_id				BIGINT,
	endereco_id				BIGINT,
	nome					VARCHAR(300)  NOT NULL,
	cpf		 				VARCHAR(15),
	rg						VARCHAR(20),	
	emitido_por				VARCHAR(20),
	nascido_em				DATE,
	usuario_id				BIGINT NOT NULL,
	
	PRIMARY KEY(id_cliente),
	FOREIGN KEY(contato_id) REFERENCES contatos(id_contato),
	FOREIGN KEY(endereco_id) REFERENCES enderecos(id_endereco),
	FOREIGN KEY(usuario_id) REFERENCES usuarios(id_usuario)
);
