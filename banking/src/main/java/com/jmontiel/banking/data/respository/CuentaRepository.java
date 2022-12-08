package com.jmontiel.banking.data.respository;

import com.jmontiel.banking.data.entities.Cuenta;
import com.jmontiel.banking.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer>, JpaSpecificationExecutor<User> {

    Optional<Cuenta> getByNumero(String numero);

    Optional<Cuenta> getByPublicIdAndClienteId(String publicID, Integer clienteId);

}
