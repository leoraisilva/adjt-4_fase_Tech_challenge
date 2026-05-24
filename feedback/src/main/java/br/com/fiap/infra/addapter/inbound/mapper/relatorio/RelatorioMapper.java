package br.com.fiap.infra.addapter.inbound.mapper.relatorio;

import br.com.fiap.application.domain.*;
import br.com.fiap.infra.addapter.outbound.persistent.relatorio.entity.RelatorioEntity;
import br.com.fiap.infra.addapter.outbound.persistent.usuario.entity.UsuarioEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RelatorioMapper implements IRelatorioMapper{
    private final RelatorioFactory relatorioFactory;
    private final UsuarioFactory usuarioFactory;
    public RelatorioMapper (RelatorioFactory relatorioFactory, UsuarioFactory usuarioFactory) {
        this.relatorioFactory = relatorioFactory;
        this.usuarioFactory = usuarioFactory;
    }
    @Override
    public Relatorio toDomain(RelatorioEntity entity, UsuarioEntity usuario) {
        return relatorioFactory.newRelatorio(
                entity.getIdFeedBack(),
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
    public RelatorioEntity toEntity(Relatorio domain) {
        return new RelatorioEntity(
                domain.getIdFeedback(),
                domain.getProfessor().getCpf(),
                domain.getDescricao(),
                domain.getDataEnvio(),
                domain.getUrgencia().name(),
                domain.getQuantidadeAvaliacao()
        );
    }
}
