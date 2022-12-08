package com.jmontiel.banking.core.cuentas;


import com.jmontiel.banking.core.cuentas.usercase.CreateCuentaUseCase;
import com.jmontiel.banking.core.cuentas.usercase.DeleteCuentaUseCase;
import com.jmontiel.banking.core.cuentas.usercase.UpdateCuentaUseCase;
import com.jmontiel.banking.data.request.CuentaRequest;
import com.jmontiel.banking.data.response.CuentaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaService implements CuentaHandler{

    @Autowired
    private CreateCuentaUseCase createCuentaUseCase;

    @Autowired
    private DeleteCuentaUseCase deleteCuentaUseCase;

    @Autowired
    private UpdateCuentaUseCase updateCuentaUseCase;

    @Override
    public CuentaResponse createCuenta(final String clienteId, final CuentaRequest request) {
        return createCuentaUseCase.create(clienteId, request);
    }

    @Override
    public CuentaResponse updateCuenta(final String clienteId, final String cuentaId, final CuentaRequest request) {
        return updateCuentaUseCase.update(clienteId, cuentaId, request);
    }

    @Override
    public void delete(final String clienteId, final String cuentaId) {
        deleteCuentaUseCase.delete(clienteId, cuentaId);
    }
}
