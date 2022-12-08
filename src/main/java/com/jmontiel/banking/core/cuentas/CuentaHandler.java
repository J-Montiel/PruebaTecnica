package com.jmontiel.banking.core.cuentas;


import com.jmontiel.banking.data.request.CuentaRequest;
import com.jmontiel.banking.data.response.CuentaResponse;

public interface CuentaHandler {

    CuentaResponse createCuenta(String clienteId, CuentaRequest request);

    CuentaResponse updateCuenta(String clienteId, final String cuentaId, CuentaRequest request);

    void delete(String clienteId, String cuentaId);
}
