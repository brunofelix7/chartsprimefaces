CREATE TABLE users(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    login VARCHAR(45) NOT NULL,
    senha VARCHAR(45) NOT NULL,
    CONSTRAINT pk_users
    PRIMARY KEY(id)
);

INSERT INTO users(nome, login, senha) VALUES ("Bruno", "bruno_kim", "123456");
INSERT INTO users(nome, login, senha) VALUES ("Emerson", "lemos", "admin");
INSERT INTO users(nome, login, senha) VALUES ("João", "jm", "sougay");

SELECT * FROM users;
SELECT nome, id FROM users;