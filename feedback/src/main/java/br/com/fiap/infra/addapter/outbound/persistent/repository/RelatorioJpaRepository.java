package br.com.fiap.infra.addapter.outbound.persistent.repository;

import br.com.fiap.infra.addapter.outbound.persistent.entity.RelatorioEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RelatorioJpaRepository implements PanacheRepositoryBase<RelatorioEntity, String> {
}
