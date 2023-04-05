package br.com.puc.oneracao.infra.service;

import br.com.puc.oneracao.api.request.ClienteDTO;

import java.util.List;

public interface ClienteService {

    ClienteDTO findClienteById(Long id);

    List<ClienteDTO> findAllClientes();

    void createNewCliente(ClienteDTO clienteDTO);

    void changeCliente(Long id, ClienteDTO clienteDTO);

    void deleteCliente(Long id);

}