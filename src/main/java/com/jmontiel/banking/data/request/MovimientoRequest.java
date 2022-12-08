package com.jmontiel.banking.data.request;

import com.jmontiel.banking.enums.TipoMovimiento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class MovimientoRequest {

    @NotNull
    private Date fecha;

    @NotNull
    private TipoMovimiento tipo;

    @NotNull
    private BigDecimal valor;

}
