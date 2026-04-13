package br.com.fiap.feedback.infra.addapter.inbound.mapper;

import br.com.fiap.feedback.application.domain.Tipo;
import br.com.fiap.feedback.application.domain.Usuario;
import br.com.fiap.feedback.application.domain.UsuarioFactory;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.UsuarioEntity;

public class UsuarioMapper implements IUsuarioMapper{
    private final UsuarioFactory usuarioFactory;

    public UsuarioMapper (UsuarioFactory usuarioFactory) {
        this.usuarioFactory = usuarioFactory;
    }
    @Override
    public Usuario toDomain(UsuarioEntity entity) {
        return usuarioFactory.newUsuario(
                entity.getNome(),
                Tipo.valueOf(entity.getTipo()),
                entity.getEmail(),
                entity.getTell(),
                entity.getCPF(),
                entity.getCurso()
        );
    }

    @Override
    public UsuarioEntity toEntity(Usuario domain) {
        return new UsuarioEntity(
                domain.getNome(),
                domain.getTipo().name(),
                domain.getEmail(),
                domain.getTell(),
                domain.getCpf(),
                domain.getCurso()
        );
    }
}
