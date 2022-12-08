package com.jmontiel.banking.data.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jmontiel.banking.data.JsonModel;
import com.jmontiel.banking.data.entities.Cuenta;


public class CuentaResponse extends Cuenta implements JsonModel {

    public CuentaResponse(final Cuenta cuenta) {
        super(cuenta);
    }

    @JsonIgnore
    @Override
    public Integer getClienteId() {
        return super.getClienteId();
    }
}
