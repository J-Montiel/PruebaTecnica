package com.jmontiel.banking.data.request;


import com.jmontiel.banking.enums.Genero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ClienteRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    private String direccion;

    @Min(8)
    @NotBlank
    private String telefono;

    @Min(4)
    @NotBlank
    private String constrasena;

    @NotNull
    private boolean estado;

    private String identificacion;

    @NotNull
    private int edad;

    private Genero genero;
}
