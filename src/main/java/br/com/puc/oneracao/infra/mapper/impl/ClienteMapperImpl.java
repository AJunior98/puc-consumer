package br.com.puc.oneracao.infra.mapper.impl;

import br.com.puc.oneracao.api.request.ClienteDTO;
import br.com.puc.oneracao.domain.entity.ClienteEntity;
import br.com.puc.oneracao.infra.mapper.ClienteMapper;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDTO mapClienteEntityToDTO(ClienteEntity clienteEntity) {
        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setDigitoConta(clienteEntity.getDigitoConta());
        clienteDTO.setNumeroAgencia(clienteEntity.getNumeroAgencia());
        clienteDTO.setNumeroCpf(clienteEntity.getNumeroCpf());
        clienteDTO.setNumeroConta(clienteEntity.getNumeroConta());
        clienteDTO.setNomeTitularConta(clienteEntity.getNomeTitularConta());

        return clienteDTO;
    }

    @Override
    public ClienteEntity mapClienteDTOToEntity(ClienteDTO clienteDTO) {
        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.setDigitoConta(clienteDTO.getDigitoConta());
        clienteEntity.setNumeroAgencia(clienteDTO.getNumeroAgencia());
        clienteEntity.setNumeroCpf(clienteDTO.getNumeroCpf());
        clienteEntity.setNumeroConta(clienteDTO.getNumeroConta());
        clienteEntity.setNomeTitularConta(clienteDTO.getNomeTitularConta());

        return clienteEntity;
    }
}
