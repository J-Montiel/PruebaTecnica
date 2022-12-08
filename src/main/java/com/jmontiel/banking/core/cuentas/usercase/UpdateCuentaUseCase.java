package com.jmontiel.banking.core.cuentas.usercase;

import com.jmontiel.banking.data.entities.Cliente;
import com.jmontiel.banking.data.entities.Cuenta;
import com.jmontiel.banking.data.request.CuentaRequest;
import com.jmontiel.banking.data.response.CuentaResponse;
import com.jmontiel.banking.data.respository.ClienteRepository;
import com.jmontiel.banking.data.respository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UpdateCuentaUseCase {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Transactional
    public CuentaResponse update(final String clienteId,final String cuentaId, CuentaRequest request) {
        final Cliente cliente = clienteRepository.getValidCliente(clienteId);

        final Optional<Cuenta> optionalCuenta = cuentaRepository.getByPublicIdAndClienteId(cuentaId, cliente.getId());
        if (optionalCuenta.isEmpty()) {
            throw new RuntimeException("la cuenta no ya existe");
        }

        final Cuenta cuenta = optionalCuenta.get();
        cuenta.setTipo(request.getTipo());
        cuenta.setEstado(request.isEstado());
        cuenta.setSaldoInicial(request.getSaldoInicial());
        cuenta.setNumero(request.getNumero());
        cuenta.setClienteId(cliente.getId());
        cuentaRepository.save(cuenta);
        return new CuentaResponse(cuenta);
    }

}
