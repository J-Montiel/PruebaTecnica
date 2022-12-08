package com.jmontiel.banking.data.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jmontiel.banking.data.JsonModel;
import com.jmontiel.banking.enums.TipoCuenta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class MovimientoCuentaResponse implements JsonModel {

    @JsonIgnore
    private Integer id;

    private Date fecha;

    private String cliente;

    private String numeroCuenta;

    private TipoCuenta tipo;

    private BigDecimal saldoInicial;

    private Boolean estado;

    private BigDecimal movimiento;

    private BigDecimal saldodisponible;


    public MovimientoCuentaResponse(final Integer id, final Date fecha, final String cliente,
                                    final String numeroCuenta, final TipoCuenta tipo, final BigDecimal saldoInicial,
                                    final Boolean estado, final BigDecimal movimiento,
                                    final BigDecimal saldodisponible) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.movimiento = movimiento;
        this.saldodisponible = saldodisponible;
    }
}
