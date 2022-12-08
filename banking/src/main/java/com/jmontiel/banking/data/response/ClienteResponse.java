package com.jmontiel.banking.data.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jmontiel.banking.data.JsonModel;
import com.jmontiel.banking.data.entities.Cliente;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClienteResponse extends Cliente implements JsonModel {

    public ClienteResponse(Cliente cliente){
        super(cliente);
    }

    @JsonIgnore
    @Override
    public Integer getUserId() {
        return super.getUserId();
    }

    @JsonIgnore
    @Override
    public String getContrasena() {
        return super.getContrasena();
    }
}
