package br.com.puc.oneracao.infra.kafka;

import br.com.puc.oneracao.api.request.ClienteDTO;
import br.com.puc.oneracao.infra.service.ClienteService;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class ClienteConsumer {

    private static final Logger LOG = Logger.getLogger(ClienteConsumer.class);

    @Inject
    ClienteService clienteService;

    @Incoming("cliente")
    public CompletionStage<Void> consumer(final Message<ClienteDTO> msg) {
        LOG.info("Mensagem cliente recebido " + msg.getPayload());
        return CompletableFuture.runAsync(() -> clienteService.createNewCliente(msg.getPayload())).thenRun(msg::ack);
    }

}