package com.jmontiel.banking.core.cuentas.usercase;

import com.jmontiel.banking.data.entities.Cliente;
import com.jmontiel.banking.data.entities.Cuenta;
import com.jmontiel.banking.data.respository.ClienteRepository;
import com.jmontiel.banking.data.respository.CuentaRepository;
import com.jmontiel.banking.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DeleteCuentaUseCase {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Transactional
    public void delete(final String clienteId, final String cuentaID) {

        final Cliente cliente = clienteRepository.getValidCliente(clienteId);

        final Optional<Cuenta> optionalCuenta = this.cuentaRepository.getByPublicIdAndClienteId(cuentaID, cliente.getId());

        if (optionalCuenta.isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND, "No se encontró la cuenta que desea eliminar");
        }
        this.cuentaRepository.delete(optionalCuenta.get());
    }
}
