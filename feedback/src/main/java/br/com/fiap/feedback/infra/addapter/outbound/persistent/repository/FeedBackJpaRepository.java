package br.com.fiap.feedback.infra.addapter.outbound.persistent.repository;

import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.FeedBackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackJpaRepository extends JpaRepository<FeedBackEntity, String> {
}
