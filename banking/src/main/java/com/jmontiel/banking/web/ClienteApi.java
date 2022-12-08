package com.jmontiel.banking.web;

import com.jmontiel.banking.core.clientes.ClienteHandler;
import com.jmontiel.banking.data.request.ClienteRequest;
import com.jmontiel.banking.data.response.CreateClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteApi {

    @Autowired
    private ClienteHandler clienteHandler;

    @PostMapping
    public ResponseEntity<CreateClienteResponse> createUser(@RequestBody  @Valid ClienteRequest request){
       final CreateClienteResponse response = this.clienteHandler.createCliente(request);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{clienteId}")
    public ResponseEntity<CreateClienteResponse> updateUser(@PathVariable final String clienteId,
                                                            @RequestBody  @Valid final ClienteRequest request){
        final CreateClienteResponse response = this.clienteHandler.updateCliente(clienteId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> delete(@PathVariable final String clienteId){
        this.clienteHandler.delete(clienteId);
        return ResponseEntity.noContent().build();
    }
}
