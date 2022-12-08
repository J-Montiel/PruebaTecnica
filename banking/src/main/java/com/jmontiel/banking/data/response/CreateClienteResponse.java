package com.jmontiel.banking.data.response;


import com.jmontiel.banking.data.JsonModel;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateClienteResponse implements JsonModel{

    private ClienteResponse cliente;

    private UserResponse user;
}
