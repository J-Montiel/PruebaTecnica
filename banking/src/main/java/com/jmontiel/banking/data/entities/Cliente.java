package com.jmontiel.banking.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "clientes")
@NoArgsConstructor
public class Cliente extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "estado")
    private Boolean estado;

    public Cliente(Cliente  cliente){
        this.setEstado(cliente.getEstado());
        this.setContrasena(cliente.getContrasena());
        this.setUserId(cliente.getUserId());
        this.setId(cliente.getId());
        this.setPublicId(cliente.getPublicId());
    }
}
