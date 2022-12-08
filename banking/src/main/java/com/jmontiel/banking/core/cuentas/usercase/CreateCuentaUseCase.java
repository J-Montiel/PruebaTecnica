package com.jmontiel.banking.core.cuentas.usercase;

import com.jmontiel.banking.data.entities.Cliente;
import com.jmontiel.banking.data.entities.Cuenta;
import com.jmontiel.banking.data.entities.Movimiento;
import com.jmontiel.banking.data.request.CuentaRequest;
import com.jmontiel.banking.data.response.CuentaResponse;
import com.jmontiel.banking.data.respository.ClienteRepository;
import com.jmontiel.banking.data.respository.CuentaRepository;
import com.jmontiel.banking.data.respository.MovimientoRepository;
import com.jmontiel.banking.enums.TipoMovimiento;
import com.jmontiel.banking.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Service
public class CreateCuentaUseCase {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    public CuentaResponse create(final String clienteId, CuentaRequest request) {
        final Cliente cliente = clienteRepository.getValidCliente(clienteId);

        final Optional<Cuenta> optionalCuenta = cuentaRepository.getByNumero(request.getNumero());
        if (optionalCuenta.isPresent()) {
            throw new CustomException(HttpStatus.NOT_FOUND, String.format("Ya existe una cuentra con el número " +
                    "ingresado :%s", request.getNumero()));
        }

        Cuenta cuenta = new Cuenta();
        cuenta.setTipo(request.getTipo());
        cuenta.setEstado(request.isEstado());
        cuenta.setSaldoInicial(request.getSaldoInicial());
        cuenta.setNumero(request.getNumero());
        cuenta.setClienteId(cliente.getId());
        cuentaRepository.save(cuenta);


        final Movimiento movimiento = new Movimiento();
        movimiento.setValor(BigDecimal.ZERO);
        movimiento.setTipo(TipoMovimiento.CORRIENTE.name().equals(cuenta.getTipo().name()) ? TipoMovimiento.CORRIENTE
                : TipoMovimiento.AHORRO);
        movimiento.setCuentaId(cuenta.getId());
        movimiento.setFecha(new Date());
        movimiento.setSaldo(cuenta.getSaldoInicial());
        this.movimientoRepository.save(movimiento);
        return new CuentaResponse(cuenta);
    }

}
