CREATE TABLE pedido (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        cliente_id BIGINT NOT NULL,
                        total DECIMAL(10,2) DEFAULT 0,
                        data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        CONSTRAINT fk_pedido_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);
