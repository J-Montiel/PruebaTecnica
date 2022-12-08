package com.jmontiel.banking.web;

import com.jmontiel.banking.core.cuentas.CuentaHandler;
import com.jmontiel.banking.data.request.CuentaRequest;
import com.jmontiel.banking.data.response.CuentaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/{clienteId}/cuentas")
public class CuentaApi {

    @Autowired
    private CuentaHandler cuentaHandler;

    @PostMapping
    public ResponseEntity<CuentaResponse> createCuenta(@PathVariable final String clienteId,
                                                       @RequestBody @Valid CuentaRequest request) {
        final CuentaResponse response = this.cuentaHandler.createCuenta(clienteId, request);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{cuentaId}")
    public ResponseEntity<CuentaResponse> updateUser(@PathVariable final String clienteId,
                                                     @PathVariable final String cuentaId,
                                                     @RequestBody @Valid final CuentaRequest request) {
        final CuentaResponse response = this.cuentaHandler.updateCuenta(clienteId, cuentaId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{cuentaId}")
    public ResponseEntity<Void> delete(@PathVariable final String clienteId, @PathVariable final String cuentaId) {
        this.cuentaHandler.delete(clienteId, cuentaId);
        return ResponseEntity.noContent().build();
    }


}