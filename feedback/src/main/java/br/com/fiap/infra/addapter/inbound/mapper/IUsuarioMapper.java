package br.com.fiap.infra.addapter.inbound.mapper;

import br.com.fiap.application.domain.Usuario;
import br.com.fiap.infra.addapter.outbound.persistent.entity.UsuarioEntity;
import jakarta.enterprise.context.ApplicationScoped;

public interface IUsuarioMapper {
    Usuario toDomain (UsuarioEntity entity);
    UsuarioEntity toEntity (Usuario domain);
}
