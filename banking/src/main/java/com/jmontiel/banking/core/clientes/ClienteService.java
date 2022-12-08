package com.jmontiel.banking.core.clientes;

import com.jmontiel.banking.core.clientes.usecase.CreateClienteUseCase;
import com.jmontiel.banking.core.clientes.usecase.DeleteClienteUseCase;
import com.jmontiel.banking.core.clientes.usecase.UpdateClienteUseCase;
import com.jmontiel.banking.data.request.ClienteRequest;
import com.jmontiel.banking.data.response.CreateClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements ClienteHandler {

    @Autowired
    private CreateClienteUseCase createClienteUseCase;

    @Autowired
    private UpdateClienteUseCase updateClienteUseCase;

    @Autowired
    private DeleteClienteUseCase deleteClienteUseCase;

    @Override
    public CreateClienteResponse createCliente(final ClienteRequest request) {
        return this.createClienteUseCase.createCliente(request);
    }

    @Override
    public CreateClienteResponse updateCliente(final String clienteId, final ClienteRequest request) {
        return this.updateClienteUseCase.updateCliente(clienteId, request);
    }

    @Override
    public void delete(final String clienteId) {
        this.deleteClienteUseCase.deleteCliente(clienteId);
    }
}
