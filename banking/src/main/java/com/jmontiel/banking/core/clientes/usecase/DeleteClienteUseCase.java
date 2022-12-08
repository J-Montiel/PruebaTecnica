package com.jmontiel.banking.core.clientes.usecase;

import com.jmontiel.banking.data.entities.Cliente;
import com.jmontiel.banking.data.respository.ClienteRepository;
import com.jmontiel.banking.data.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteClienteUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public void deleteCliente(final String clienteId) {
        final Cliente cliente = clienteRepository.getValidCliente(clienteId);
        clienteRepository.delete(cliente);
        userRepository.deleteById(cliente.getUserId());
    }
}
