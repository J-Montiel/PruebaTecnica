package com.jmontiel.banking.data.request;


import com.jmontiel.banking.enums.TipoCuenta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CuentaRequest {

    @Min(6)
    @NotBlank
    private String numero;

    @NotNull
    private TipoCuenta tipo;

    @Min(8)
    @NotNull
    private BigDecimal saldoInicial;

    @NotNull
    private boolean estado;

}
