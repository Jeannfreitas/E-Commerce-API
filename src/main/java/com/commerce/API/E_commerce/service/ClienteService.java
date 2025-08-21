package com.commerce.API.E_commerce.service;

import com.commerce.API.E_commerce.exception.DuplicateResourceException;
import com.commerce.API.E_commerce.exception.ResourceNotFoundException;
import com.commerce.API.E_commerce.model.Cliente;
import com.commerce.API.E_commerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
    }

    public Cliente salvar(Cliente cliente) {
        if (cliente.getId() == null && clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new DuplicateResourceException("E-mail já cadastrado");
        }
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
