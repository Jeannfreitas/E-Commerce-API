package com.commerce.API.E_commerce.repository;


import com.commerce.API.E_commerce.model.Cliente;
import com.commerce.API.E_commerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {}