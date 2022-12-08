package com.jmontiel.banking.data.respository;

import com.jmontiel.banking.data.entities.Movimiento;
import com.jmontiel.banking.data.entities.User;
import com.jmontiel.banking.data.response.CuentaMovimientos;
import com.jmontiel.banking.data.response.MovimientoCuentaResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer>, JpaSpecificationExecutor<User> {
    @Query("select m from Movimiento m join Cuenta c on m.cuentaId = c.id join Cliente cte on c.clienteId = cte.id " +
            "where cte.publicId =:clienteId and m.fecha between :fechaIniacial and :fechaFinal order by m.fecha desc")
    List<Movimiento> findAllByFechaBetween(String clienteId, Date fechaIniacial, Date fechaFinal);

    @Query("select sum(m.valor) from Movimiento m where m.cuentaId =:cuentaId")
    BigDecimal getSaldo(Integer cuentaId);

    @Query("select new com.jmontiel.banking.data.response.MovimientoCuentaResponse(m.id, m.fecha, u.nombre, c" +
            ".numero," +
            " c.tipo," +
            " c.saldoInicial, c.estado, m.valor, m.saldo)  " +
            "from " +
            "Movimiento m " +
            "join Cuenta c on m.cuentaId = c.id join Cliente cte on c.clienteId = cte.id join User u on cte.userId = " +
            "u.id " +
            "where cte.publicId =:clienteId and m.fecha between :fechaIniacial and :fechaFinal order by m.fecha desc")
    List<MovimientoCuentaResponse> getReporte(String clienteId, Date fechaIniacial, Date fechaFinal);

    int countByCuentaId(Integer cuentaId);

    Movimiento findTopByCuentaIdOrderByIdDesc(Integer cuentaId);
}
