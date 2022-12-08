package com.jmontiel.banking.data.response;


import com.jmontiel.banking.data.entities.Cuenta;
import com.jmontiel.banking.data.entities.Movimiento;
import com.jmontiel.banking.data.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CuentaMovimientos {

    private User user;

    private Cuenta cuenta;

    private Movimiento movimiento;

    public CuentaMovimientos(final User user, final Cuenta cuenta, final Movimiento movimiento) {
        this.user = user;
        this.cuenta = cuenta;
        this.movimiento = movimiento;
    }
}
