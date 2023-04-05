package br.com.puc.oneracao.core.config;

import br.com.puc.oneracao.api.request.ClienteDTO;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class ClienteDeserializer extends ObjectMapperDeserializer<ClienteDTO> {
    public ClienteDeserializer() {
        super (ClienteDTO.class);
    }
}