package com.jmontiel.banking.data.entities;

import com.jmontiel.banking.enums.Genero;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "identificacion", nullable = false)
    private String indentificacion;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", nullable = false)
    private Genero genero;

    public User(final User user) {
        this.setId(user.getId());
        this.setPublicId(user.getPublicId());
        this.setNombre(user.getNombre());
        this.setEdad(user.getEdad());
        this.setIndentificacion(user.getIndentificacion());
        this.setDireccion(user.getDireccion());
        this.setTelefono(user.getTelefono());
        this.setGenero(user.getGenero());
    }

}
