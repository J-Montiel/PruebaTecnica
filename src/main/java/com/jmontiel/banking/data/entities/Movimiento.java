package com.jmontiel.banking.data.entities;

import com.jmontiel.banking.enums.TipoMovimiento;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "movimientos")
@NoArgsConstructor
public class Movimiento extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "cuenta_id", nullable = false)
    private Integer cuentaId;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoMovimiento tipo;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;

    public Movimiento(final Movimiento movimiento) {
        this.setId(movimiento.getId());
        this.setPublicId(movimiento.getPublicId());
        this.setCuentaId(movimiento.getCuentaId());
        this.setFecha(movimiento.getFecha());
        this.setTipo(movimiento.getTipo());
        this.setValor(movimiento.getValor());
        this.setSaldo(movimiento.getSaldo());
    }
}
