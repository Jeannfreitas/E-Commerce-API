CREATE TABLE item_pedido (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             pedido_id BIGINT NOT NULL,
                             produto_id BIGINT NOT NULL,
                             quantidade INT NOT NULL,
                             preco_unitario DECIMAL(10,2) NOT NULL,
                             CONSTRAINT fk_itempedido_pedido FOREIGN KEY (pedido_id) REFERENCES pedido(id),
                             CONSTRAINT fk_itempedido_produto FOREIGN KEY (produto_id) REFERENCES produto(id)
);
