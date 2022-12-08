package com.jmontiel.banking.core.clientes.usecase;

import com.jmontiel.banking.data.entities.Cliente;
import com.jmontiel.banking.data.entities.User;
import com.jmontiel.banking.data.request.ClienteRequest;
import com.jmontiel.banking.data.response.ClienteResponse;
import com.jmontiel.banking.data.response.CreateClienteResponse;
import com.jmontiel.banking.data.response.UserResponse;
import com.jmontiel.banking.data.respository.ClienteRepository;
import com.jmontiel.banking.data.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateClienteUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public CreateClienteResponse createCliente(final ClienteRequest request) {
        final User user = new User();
        user.setDireccion(request.getDireccion());
        user.setEdad(request.getEdad());
        user.setGenero(request.getGenero());
        user.setIndentificacion(request.getIdentificacion());
        user.setNombre(request.getNombre());
        user.setTelefono(request.getTelefono());
        this.userRepository.save(user);

        final Cliente cliente = new Cliente();
        cliente.setContrasena(request.getConstrasena());
        cliente.setEstado(request.isEstado());
        cliente.setUserId(user.getId());
        this.clienteRepository.save(cliente);
        return CreateClienteResponse.builder().cliente(new ClienteResponse(cliente))//
                .user(new UserResponse(user)).build();
    }
}
