package com.jmontiel.banking.data.response;

import com.jmontiel.banking.data.JsonModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovimientosResponse implements JsonModel {


    private List<MovimientoCuentaResponse> movimientos;
    private Long total;

}
