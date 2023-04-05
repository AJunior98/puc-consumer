package br.com.puc.oneracao.core.config;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(
                title = "Comunidade Crédito PF - RT Infra PUC e RIC - POC Squad Oneração",
                version = "1.0.0",
                contact = @Contact(
                        name = "Site do Itaú",
                        url = "https://www.itau.com.br/",
                        email = "apojr98@gmail.com")
        ), tags = {
                @Tag(
                        name = "/v1/oneracao/cliente", description = "API para recepção de payload e envio para fila do poc-consumer."),
        },
        servers = {
                @Server(url = "http://localhost:8080")
        })
public class OpenApiConfig extends Application {
}
