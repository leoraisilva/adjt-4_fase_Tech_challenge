package br.com.fiap.feedback.infra.addapter.inbound.mapper;

import br.com.fiap.feedback.application.domain.Relatorio;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.AvisoEntity;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.RelatorioEntity;

public class RelatorioMapper implements IRelatorioMapper{
    @Override
    public Relatorio toRelatorioDomain(RelatorioEntity entity) {
        return null;
    }

    @Override
    public Relatorio toAvisoDomain(AvisoEntity entity) {
        return null;
    }

    @Override
    public RelatorioEntity toRelatorioEntity(Relatorio domain) {
        return null;
    }

    @Override
    public AvisoEntity toAvisoEntity(Relatorio domain) {
        return null;
    }
}
