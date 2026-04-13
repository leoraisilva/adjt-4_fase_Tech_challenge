package br.com.fiap.feedback.infra.addapter.outbound.persistent.repository;

import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, String> {
    Optional<UsuarioEntity> findByCPF(String cpf);
}
