package com.jmontiel.banking.core.clientes;


import com.jmontiel.banking.data.request.ClienteRequest;
import com.jmontiel.banking.data.response.CreateClienteResponse;

public interface ClienteHandler {
    CreateClienteResponse createCliente(ClienteRequest request);

    CreateClienteResponse updateCliente(String clienteId, ClienteRequest request);

    void delete(String clienteId);
}
