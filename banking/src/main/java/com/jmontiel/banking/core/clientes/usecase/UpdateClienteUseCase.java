package com.jmontiel.banking.core.clientes.usecase;

import com.jmontiel.banking.data.entities.Cliente;
import com.jmontiel.banking.data.entities.User;
import com.jmontiel.banking.data.request.ClienteRequest;
import com.jmontiel.banking.data.response.ClienteResponse;
import com.jmontiel.banking.data.response.CreateClienteResponse;
import com.jmontiel.banking.data.response.UserResponse;
import com.jmontiel.banking.data.respository.ClienteRepository;
import com.jmontiel.banking.data.respository.UserRepository;
import com.jmontiel.banking.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UpdateClienteUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public CreateClienteResponse updateCliente(final String clienteId, final ClienteRequest request) {

        final Cliente cliente = clienteRepository.getValidCliente(clienteId);
        cliente.setContrasena(request.getConstrasena());
        cliente.setEstado(request.isEstado());
        this.clienteRepository.save(cliente);

        final User user = userRepository.getById(cliente.getUserId());
        user.setDireccion(request.getDireccion());
        user.setEdad(request.getEdad());
        user.setGenero(request.getGenero());
        user.setIndentificacion(request.getIdentificacion());
        user.setNombre(request.getNombre());
        user.setTelefono(request.getTelefono());
        this.userRepository.save(user);
        return CreateClienteResponse.builder().cliente(new ClienteResponse(cliente))//
                .user(new UserResponse(user)).build();
    }
}
