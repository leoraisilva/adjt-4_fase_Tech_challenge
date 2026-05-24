package br.com.fiap.infra.addapter.outbound.persistent.repository;

import br.com.fiap.infra.addapter.outbound.persistent.entity.FeedBackEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FeedBackJpaRepository implements PanacheRepositoryBase<FeedBackEntity, String> {

}
