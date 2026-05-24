package br.com.fiap.infra.addapter.inbound.mapper.relatorio;

import br.com.fiap.application.domain.Relatorio;
import br.com.fiap.infra.addapter.outbound.persistent.relatorio.entity.RelatorioEntity;
import br.com.fiap.infra.addapter.outbound.persistent.usuario.entity.UsuarioEntity;


public interface IRelatorioMapper {
    Relatorio toDomain (RelatorioEntity entity, UsuarioEntity usuario);
    RelatorioEntity toEntity (Relatorio domain);
}
