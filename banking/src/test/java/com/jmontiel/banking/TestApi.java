package com.jmontiel.banking;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmontiel.banking.data.response.MovimientosResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.io.IOException;

public class TestApi {

    @Test
    public void get_reporte_movimientos() throws IOException {

        HttpUriRequest request = new HttpGet("http://localhost:8082/e268e78f-89a9-463c-8cc7-0caba029b80e/reportes" +
                "?fechaInicial=2022-12-09&fechaFinal=2022-12-11");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assertions.assertTrue(HttpStatus.OK.value() == response.getStatusLine().getStatusCode());

    }

    @Test
    public void get_reporte_movimientos_body_not_empty() throws IOException {

        HttpUriRequest request = new HttpGet("http://localhost:8082/e268e78f-89a9-463c-8cc7-0caba029b80e/reportes" +
                "?fechaInicial=2022-12-09&fechaFinal=2022-12-11");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        ObjectMapper objectMapper = new ObjectMapper();
        MovimientosResponse movimientosResponse = objectMapper.readValue(response.getEntity().getContent(),
                MovimientosResponse.class);
        Assertions.assertTrue(movimientosResponse.getTotal() > 0);

    }
}
