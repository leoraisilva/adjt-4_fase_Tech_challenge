package br.com.fiap.infra.addapter.outbound.persistent.feedback.repository;

import br.com.fiap.infra.addapter.outbound.persistent.feedback.entity.FeedBackEntity;
import io.quarkus.hibernate.orm.PersistenceUnit;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FeedBackJpaRepository implements PanacheRepositoryBase<FeedBackEntity, String> {

}
