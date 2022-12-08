package com.jmontiel.banking.data.entities;

import com.jmontiel.banking.enums.TipoCuenta;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "cuentas")
@NoArgsConstructor
public class Cuenta extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "cliente_id", nullable = false)
    private Integer clienteId;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoCuenta tipo;

    @Column(name = "saldo_inicial", nullable = false)
    private BigDecimal saldoInicial;

    @Column(name = "estado")
    private boolean estado;

    public Cuenta(final Cuenta cuenta) {
        this.setId(cuenta.getId());
        this.setPublicId(cuenta.getPublicId());
        this.setEstado(cuenta.isEstado());
        this.setClienteId(cuenta.getClienteId());
        this.setNumero(cuenta.getNumero());
        this.setTipo(cuenta.getTipo());
        this.setSaldoInicial(cuenta.getSaldoInicial());
    }
}
