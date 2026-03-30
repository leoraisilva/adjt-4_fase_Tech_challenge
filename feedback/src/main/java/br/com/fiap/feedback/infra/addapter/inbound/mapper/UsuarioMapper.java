package br.com.fiap.feedback.infra.addapter.inbound.mapper;

import br.com.fiap.feedback.application.domain.Usuario;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.UsuarioEntity;

public class UsuarioMapper implements IUsuarioMapper{
    @Override
    public Usuario toDomain(UsuarioEntity entity) {
        return new Usuario.UsuarioBuilder()
                .build();
    }

    @Override
    public UsuarioEntity toEntity(Usuario domain) {
        return null;
    }
}
