package com.jmontiel.banking.core.movimientos.usercase;

import com.jmontiel.banking.data.entities.Cliente;
import com.jmontiel.banking.data.entities.Cuenta;
import com.jmontiel.banking.data.entities.Movimiento;
import com.jmontiel.banking.data.request.MovimientoRequest;
import com.jmontiel.banking.data.response.MovimientoResponse;
import com.jmontiel.banking.data.respository.ClienteRepository;
import com.jmontiel.banking.data.respository.CuentaRepository;
import com.jmontiel.banking.data.respository.MovimientoRepository;
import com.jmontiel.banking.enums.TipoCuenta;
import com.jmontiel.banking.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CreateMovimientoUseCase {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    public MovimientoResponse create(final String clienteId, final String cuentaId, MovimientoRequest request) {
        final Cliente cliente = clienteRepository.getValidCliente(clienteId);

        final Optional<Cuenta> optionalCuenta = cuentaRepository.getByPublicIdAndClienteId(cuentaId, cliente.getId());
        if (optionalCuenta.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "No la cuenta existe");
        }
        final Cuenta cuenta = optionalCuenta.get();


         BigDecimal saldoActual= movimientoRepository.findTopByCuentaIdOrderByIdDesc(cuenta.getId()).getSaldo();
        if (TipoCuenta.CORRIENTE.equals(cuenta.getTipo())) {


            if( saldoActual.doubleValue() == 0){
                throw new CustomException(HttpStatus.PRECONDITION_FAILED, "Saldo no disponible");
            }

            if (request.getValor().doubleValue()   <0  ) {
                if(saldoActual.doubleValue() < request.getValor().abs().doubleValue() ){
                    throw new CustomException(HttpStatus.PRECONDITION_FAILED, "Saldo insuficiente para esta operación");
                }
                saldoActual= new BigDecimal(saldoActual.doubleValue() - request.getValor().abs().doubleValue());
            }else{
                saldoActual= new BigDecimal(saldoActual.doubleValue() + request.getValor().abs().doubleValue());
            }
        }

        final Movimiento movimiento = new Movimiento();
        movimiento.setValor(request.getValor());
        movimiento.setTipo(request.getTipo());
        movimiento.setCuentaId(cuenta.getId());
        movimiento.setFecha(request.getFecha());
        movimiento.setSaldo(saldoActual);
        this.movimientoRepository.save(movimiento);
        return new MovimientoResponse(movimiento);
    }

}
