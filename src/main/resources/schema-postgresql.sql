CREATE TABLE IF NOT EXISTS camisetas (
    id             UUID PRIMARY KEY,
    nome_time      VARCHAR(100) NOT NULL,
    liga           VARCHAR(100) NOT NULL,
    ano_camiseta   INTEGER NOT NULL,
    nome_jogador   VARCHAR(100),
    preco          NUMERIC(10,2) NOT NULL
);
