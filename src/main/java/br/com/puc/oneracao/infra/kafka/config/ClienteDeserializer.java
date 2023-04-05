package br.com.puc.oneracao.infra.kafka.config;

import br.com.puc.oneracao.api.request.ClienteDTO;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class ClienteDeserializer extends ObjectMapperDeserializer<ClienteDTO> {
    public ClienteDeserializer() {
        super (ClienteDTO.class);
    }
}