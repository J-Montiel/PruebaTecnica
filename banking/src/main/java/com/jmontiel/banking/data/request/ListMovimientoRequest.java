package com.jmontiel.banking.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ListMovimientoRequest {

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaInicial;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaFinal;

}
