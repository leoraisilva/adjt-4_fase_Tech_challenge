package br.com.fiap.infra.addapter.outbound.persistent.usuario.repository;

import br.com.fiap.infra.addapter.outbound.persistent.usuario.entity.UsuarioEntity;
import io.quarkus.hibernate.orm.PersistenceUnit;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioJpaRepository implements PanacheRepository<UsuarioEntity> {
    public UsuarioEntity findByCPF (String cpf) {
        return findAll().stream()
                .filter(c -> c.getCPF().equals(cpf))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Erro ao Buscar Usuario"));
    }
}
