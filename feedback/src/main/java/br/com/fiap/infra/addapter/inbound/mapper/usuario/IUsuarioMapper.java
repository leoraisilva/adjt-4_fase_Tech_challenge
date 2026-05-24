package br.com.fiap.infra.addapter.inbound.mapper.usuario;

import br.com.fiap.application.domain.Usuario;
import br.com.fiap.infra.addapter.outbound.persistent.usuario.entity.UsuarioEntity;

public interface IUsuarioMapper {
    Usuario toDomain (UsuarioEntity entity);
    UsuarioEntity toEntity (Usuario domain);
}
