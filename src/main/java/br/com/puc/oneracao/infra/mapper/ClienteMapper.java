package br.com.puc.oneracao.infra.mapper;

import br.com.puc.oneracao.api.request.ClienteDTO;
import br.com.puc.oneracao.domain.entity.ClienteEntity;

public interface ClienteMapper {

    ClienteDTO mapClienteEntityToDTO(ClienteEntity customer);

    ClienteEntity mapClienteDTOToEntity(ClienteDTO customer);

}
