package br.com.fiap.feedback.infra.addapter.inbound.mapper;


import br.com.fiap.feedback.application.domain.Relatorio;
import br.com.fiap.feedback.application.domain.Usuario;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.AvisoEntity;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.RelatorioEntity;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.UsuarioEntity;

public interface IRelatorioMapper {
    Relatorio toRelatorioDomain (RelatorioEntity entity, UsuarioEntity usuario);
    Relatorio toAvisoDomain (AvisoEntity entity, UsuarioEntity usuario);
    RelatorioEntity toRelatorioEntity (Relatorio domain);
    AvisoEntity toAvisoEntity (Relatorio domain);
}
