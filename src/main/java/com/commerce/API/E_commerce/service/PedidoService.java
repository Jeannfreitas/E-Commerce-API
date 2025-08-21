package com.commerce.API.E_commerce.service;

import com.commerce.API.E_commerce.exception.ResourceNotFoundException;
import com.commerce.API.E_commerce.model.Pedido;
import com.commerce.API.E_commerce.model.ItemPedido;
import com.commerce.API.E_commerce.repository.ItemPedidoRepository;
import com.commerce.API.E_commerce.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository, ItemPedidoRepository itemPedidoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));
    }

    public Pedido salvar(Pedido pedido) {
        // Calcula total e salva itens
        double total = 0;
        for (ItemPedido item : pedido.getItens()) {
            item.setPedido(pedido); // associa item ao pedido
            itemPedidoRepository.save(item);
            total += item.getPrecoUnitario() * item.getQuantidade();
        }
        pedido.setTotal(total);
        return pedidoRepository.save(pedido);
    }

    public void deletar(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pedido não encontrado");
        }
        pedidoRepository.deleteById(id);
    }
}
