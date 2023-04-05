package br.com.puc.oneracao.infra.repository;

import br.com.puc.oneracao.domain.entity.ClienteEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<ClienteEntity> {
}
