package br.com.fiap.feedback.infra.addapter.outbound.persistent.repository;

import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.RelatorioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioJpaRepository extends JpaRepository<RelatorioEntity, String> {
}
