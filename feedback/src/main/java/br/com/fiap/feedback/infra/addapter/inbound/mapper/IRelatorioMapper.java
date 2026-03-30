package br.com.fiap.feedback.infra.addapter.inbound.mapper;


import br.com.fiap.feedback.application.domain.Relatorio;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.AvisoEntity;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.RelatorioEntity;

public interface IRelatorioMapper {
    Relatorio toRelatorioDomain (RelatorioEntity entity);
    Relatorio toAvisoDomain (AvisoEntity entity);
    RelatorioEntity toRelatorioEntity (Relatorio domain);
    AvisoEntity toAvisoEntity (Relatorio domain);
}
