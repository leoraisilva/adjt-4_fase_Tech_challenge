package br.com.fiap.feedback.infra.addapter.inbound.mapper;

import br.com.fiap.feedback.application.domain.*;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.AvisoEntity;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.RelatorioEntity;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.UsuarioEntity;

public class RelatorioMapper implements IRelatorioMapper{
    private final RelatorioFactory relatorioFactory;
    private final UsuarioFactory usuarioFactory;
    public RelatorioMapper (RelatorioFactory relatorioFactory, UsuarioFactory usuarioFactory) {
        this.relatorioFactory = relatorioFactory;
        this.usuarioFactory = usuarioFactory;
    }
    @Override
    public Relatorio toRelatorioDomain(RelatorioEntity entity, UsuarioEntity usuario) {
        return relatorioFactory.newRelatorio(
                usuarioFactory.newUsuario(
                        usuario.getNome(),
                        Tipo.valueOf(usuario.getTipo()),
                        usuario.getEmail(),
                        usuario.getTell(),
                        usuario.getCPF(),
                        usuario.getCurso()
                ),
                entity.getDescricao(),
                entity.getDataEnvio(),
                Urgencia.valueOf(entity.getUrgencia()),
                entity.getQuantidadeAvalicao()
        );
    }

    @Override
    public Relatorio toAvisoDomain(AvisoEntity entity, UsuarioEntity usuario) {
        return relatorioFactory.newAviso(
                entity.getIdFeedback(),
                usuarioFactory.newUsuario(
                        usuario.getNome(),
                        Tipo.valueOf(usuario.getTipo()),
                        usuario.getEmail(),
                        usuario.getTell(),
                        usuario.getCPF(),
                        usuario.getCurso()
                ),
                entity.getDescricao(),
                entity.getDataEnvio(),
                Urgencia.valueOf(entity.getUrgencia())
        );
    }

    @Override
    public RelatorioEntity toRelatorioEntity(Relatorio domain) {
        return new RelatorioEntity(
                domain.getProfessor().getCpf(),
                domain.getDescricao(),
                domain.getDataEnvio(),
                domain.getUrgencia().name(),
                domain.getQuantidadeAvaliacao()
        );
    }

    @Override
    public AvisoEntity toAvisoEntity(Relatorio domain) {
        return new AvisoEntity(
                domain.getIdFeedback(),
                domain.getProfessor().getCpf(),
                domain.getDescricao(),
                domain.getDataEnvio(),
                domain.getUrgencia().name()
        );
    }
}
