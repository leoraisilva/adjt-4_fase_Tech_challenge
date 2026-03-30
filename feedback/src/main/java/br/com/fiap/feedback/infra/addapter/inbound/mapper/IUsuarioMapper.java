package br.com.fiap.feedback.infra.addapter.inbound.mapper;

import br.com.fiap.feedback.application.domain.Usuario;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.UsuarioEntity;

public interface IUsuarioMapper {
    Usuario toDomain (UsuarioEntity entity);
    UsuarioEntity toEntity (Usuario domain);
}
