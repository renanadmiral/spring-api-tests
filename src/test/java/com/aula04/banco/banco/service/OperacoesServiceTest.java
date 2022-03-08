package com.aula04.banco.banco.service;

import com.aula04.banco.banco.dto.RequestCliente;
import com.aula04.banco.banco.dto.RequestDeposito;
import com.aula04.banco.banco.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class OperacoesServiceTest {
    OperacoesService operacoesService = new OperacoesService();
    ClienteService clienteService = new ClienteService();

    @Test
    void depositoIdNaoExiste() throws Exception {
        RequestCliente requestCliente = new RequestCliente(
                "cinthia",
                "cinthiaqcarsoso@teste.com",
                "44934586719",
                "54353",
                3
        );

        Cliente cliente = clienteService.cadastraCliente(requestCliente);

        UUID requestId = UUID.randomUUID();

        Assertions.assertNotNull(cliente.getId());
        Assertions.assertEquals(requestId, cliente.getId());
        RequestDeposito requestDeposito = new RequestDeposito(220.0, UUID.randomUUID());

        operacoesService.deposita(requestId, requestDeposito);
    }
}
