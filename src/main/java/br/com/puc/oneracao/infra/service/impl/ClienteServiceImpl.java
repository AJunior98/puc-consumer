package br.com.puc.oneracao.infra.service.impl;

import br.com.puc.oneracao.api.request.ClienteDTO;
import br.com.puc.oneracao.domain.entity.ClienteEntity;
import br.com.puc.oneracao.infra.kafka.ClienteConsumer;
import br.com.puc.oneracao.infra.mapper.ClienteMapper;
import br.com.puc.oneracao.infra.repository.ClienteRepository;
import br.com.puc.oneracao.infra.service.ClienteService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    private static final Logger LOG = Logger.getLogger(ClienteConsumer.class);

    @Inject
    private ClienteRepository clienteRepository;

    @Inject
    private ClienteMapper clienteMapper;

    @Override
    public ClienteDTO findClienteById(Long id) {
        ClienteEntity customerEntity = clienteRepository.findById(id);
        return clienteMapper.mapClienteEntityToDTO(customerEntity);
    }

    @Override
    public List<ClienteDTO> findAllClientes() {
        List<ClienteDTO> customers = new ArrayList<>();

        clienteRepository.findAll().stream().forEach(item -> {
            customers.add(clienteMapper.mapClienteEntityToDTO(item));
        });

        return customers;
    }

    @Override
    @Transactional
    public void createNewCliente(ClienteDTO clienteDTO) {
        try {
            clienteRepository.persist(clienteMapper.mapClienteDTOToEntity(clienteDTO));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public void changeCliente(Long id, ClienteDTO clienteDTO) {
        ClienteEntity clienteEntity = clienteRepository.findById(id);

        clienteEntity.setDigitoConta(clienteDTO.getDigitoConta());
        clienteEntity.setNumeroAgencia(clienteDTO.getNumeroAgencia());
        clienteEntity.setNumeroCpf(clienteDTO.getNumeroCpf());
        clienteEntity.setNumeroConta(clienteDTO.getNumeroConta());
        clienteEntity.setNomeTitularConta(clienteDTO.getNomeTitularConta());

        clienteRepository.persist(clienteEntity);
    }

    @Override
    @Transactional
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

}