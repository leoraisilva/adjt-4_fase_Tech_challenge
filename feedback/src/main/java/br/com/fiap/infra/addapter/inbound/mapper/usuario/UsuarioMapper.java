package br.com.fiap.infra.addapter.inbound.mapper.usuario;

import br.com.fiap.application.domain.Tipo;
import br.com.fiap.application.domain.Usuario;
import br.com.fiap.application.domain.UsuarioFactory;
import br.com.fiap.infra.addapter.outbound.persistent.usuario.entity.UsuarioEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioMapper implements IUsuarioMapper {
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
