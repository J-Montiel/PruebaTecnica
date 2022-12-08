package com.jmontiel.banking.core.movimientos;


import com.jmontiel.banking.data.request.ListMovimientoRequest;
import com.jmontiel.banking.data.request.MovimientoRequest;
import com.jmontiel.banking.data.response.MovimientoResponse;
import com.jmontiel.banking.data.response.MovimientosResponse;

public interface MovimientosHandler {

    MovimientoResponse createMovimiento(String clienteId, String cuentaId, MovimientoRequest request);

    MovimientosResponse list(String clienteId, ListMovimientoRequest filterParams);
}
