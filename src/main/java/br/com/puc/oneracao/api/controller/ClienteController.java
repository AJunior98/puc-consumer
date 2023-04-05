package br.com.puc.oneracao.api.controller;

import br.com.puc.oneracao.api.request.ClienteDTO;
import br.com.puc.oneracao.infra.service.ClienteService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/oneracao/cliente")
@Tag(name = "/v1/oneracao/cliente", description = "Conjunto de API's para captura e injestão de dados no banco.")
public class ClienteController {

    @Inject
    ClienteService clienteService;

    @Operation(description = "Endpoint responsável por procurar um cliente")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Retorno OK com o cliente."),
            @APIResponse(responseCode = "401", description = "Erro de autenticação dessa API"),
            @APIResponse(responseCode = "403", description = "Erro de autorização dessa API"),
            @APIResponse(responseCode = "404", description = "Cliente não encontrado")})
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClienteDTO findClienteById(@PathParam("id") Long id) {
        return clienteService.findClienteById(id);
    }

    @Operation(description = "Endpoint responsável por procurar todos os clientes")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Retorno OK com os clientes."),
            @APIResponse(responseCode = "401", description = "Erro de autenticação dessa API"),
            @APIResponse(responseCode = "403", description = "Erro de autorização dessa API"),
            @APIResponse(responseCode = "404", description = "Nenhum cliente encontrado")})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClienteDTO> findAllCliente() {
        return clienteService.findAllClientes();
    }

    @Operation(description = "Endpoint responsável por salvar um cliente")
    @APIResponses(value = {
            @APIResponse(responseCode = "201", description = "Retorno OK com o cliente criado."),
            @APIResponse(responseCode = "401", description = "Erro de autenticação dessa API"),
            @APIResponse(responseCode = "403", description = "Erro de autorização dessa API"),
            @APIResponse(responseCode = "404", description = "Cliente não encontrado")})
    @POST
    @Transactional
    public Response saveCliente(ClienteDTO ClienteDTO) {
        try {
            clienteService.createNewCliente(ClienteDTO);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Operation(description = "Endpoint responsável por alterar um cliente")
    @APIResponses(value = {
            @APIResponse(responseCode = "201", description = "Retorno OK com o cliente."),
            @APIResponse(responseCode = "401", description = "Erro de autenticação dessa API"),
            @APIResponse(responseCode = "403", description = "Erro de autorização dessa API"),
            @APIResponse(responseCode = "404", description = "Cliente não encontrado")})
    @PUT
    @Path("/{id}")
    @Transactional
    public Response changeCliente(@PathParam("id") Long id, ClienteDTO ClienteDTO) {
        try {
            clienteService.changeCliente(id, ClienteDTO);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Operation(description = "Endpoint responsável por deletar um cliente do banco")
    @APIResponses(value = {
            @APIResponse(responseCode = "204", description = "Retorno OK com o cliente apagado."),
            @APIResponse(responseCode = "401", description = "Erro de autenticação dessa API"),
            @APIResponse(responseCode = "403", description = "Erro de autorização dessa API"),
            @APIResponse(responseCode = "404", description = "Cliente não encontrado")})
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteCliente(@PathParam("id") Long id) {
        try {
            clienteService.deleteCliente(id);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}