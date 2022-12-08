package com.jmontiel.banking.core.movimientos.usercase;

import com.jmontiel.banking.data.request.ListMovimientoRequest;
import com.jmontiel.banking.data.response.MovimientoCuentaResponse;
import com.jmontiel.banking.data.response.MovimientosResponse;
import com.jmontiel.banking.data.respository.ClienteRepository;
import com.jmontiel.banking.data.respository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListMovimientosUseCase {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    public MovimientosResponse list(final String clienteId, final ListMovimientoRequest filterRequest) {
        this.clienteRepository.getValidCliente(clienteId);
       final List<MovimientoCuentaResponse> movimientos = movimientoRepository.getReporte(clienteId,
               filterRequest.getFechaInicial(),
                filterRequest.getFechaFinal());
        return new MovimientosResponse(movimientos, (long) movimientos.size());
    }

}
