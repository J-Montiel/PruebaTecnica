package com.jmontiel.banking.web;

import com.jmontiel.banking.core.movimientos.MovimientosHandler;
import com.jmontiel.banking.data.request.ListMovimientoRequest;
import com.jmontiel.banking.data.request.MovimientoRequest;
import com.jmontiel.banking.data.response.MovimientoResponse;
import com.jmontiel.banking.data.response.MovimientosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/{clienteId}")
public class MovimientoApi {
    @Autowired
    private MovimientosHandler movimientosHandler;

    @PostMapping("/cuentas/{cuentaId}/movimientos")
    public ResponseEntity<MovimientoResponse> createCuenta(@PathVariable final String clienteId,
                                                           @PathVariable final String cuentaId,
                                                           @RequestBody @Valid MovimientoRequest request) {
        final MovimientoResponse response = this.movimientosHandler.createMovimiento(clienteId,cuentaId, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/reportes")
    public ResponseEntity<MovimientosResponse> list(@PathVariable final String clienteId,
                                                    ListMovimientoRequest filterParams) {
        final MovimientosResponse response = this.movimientosHandler.list(clienteId,filterParams);
        return ResponseEntity.ok(response);
    }
}