package com.jmontiel.banking.core.movimientos;

import com.jmontiel.banking.core.movimientos.usercase.CreateMovimientoUseCase;
import com.jmontiel.banking.core.movimientos.usercase.ListMovimientosUseCase;
import com.jmontiel.banking.data.request.ListMovimientoRequest;
import com.jmontiel.banking.data.request.MovimientoRequest;
import com.jmontiel.banking.data.response.MovimientoResponse;
import com.jmontiel.banking.data.response.MovimientosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientosService implements MovimientosHandler{

    @Autowired
    private CreateMovimientoUseCase createMovimientoUseCase;

    @Autowired
    private ListMovimientosUseCase listMovimientosUseCase ;

    @Override
    public MovimientoResponse createMovimiento(final String clienteId, final String cuentaId, final MovimientoRequest request) {
        return this.createMovimientoUseCase.create(clienteId, cuentaId, request);
    }

    @Override
    public MovimientosResponse list(final String clienteId, final ListMovimientoRequest filterParams) {
        return this.listMovimientosUseCase.list(clienteId, filterParams);
    }
}
