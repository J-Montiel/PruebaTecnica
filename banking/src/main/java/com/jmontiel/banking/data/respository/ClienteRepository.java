package com.jmontiel.banking.data.respository;

import com.jmontiel.banking.data.entities.Cliente;
import com.jmontiel.banking.data.entities.User;
import com.jmontiel.banking.exceptions.CustomException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>, JpaSpecificationExecutor<User> {

    Cliente findByPublicId(String publicId);

    default Cliente getValidCliente(String publicId){
        return Optional.ofNullable(findByPublicId(publicId)).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND,
                "No se encontro informacion relacionada al cliente"));
    }
}
