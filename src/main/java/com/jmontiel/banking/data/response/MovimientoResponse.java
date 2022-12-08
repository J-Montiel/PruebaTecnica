package com.jmontiel.banking.data.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jmontiel.banking.data.JsonModel;
import com.jmontiel.banking.data.entities.Movimiento;

public class MovimientoResponse extends Movimiento implements JsonModel {

   public MovimientoResponse(Movimiento movimiento){
        super(movimiento);
    }

    @JsonIgnore
    @Override
    public Integer getCuentaId() {
        return super.getCuentaId();
    }
}
