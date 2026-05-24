package br.com.fiap.infra.addapter.inbound.mapper;

import br.com.fiap.application.domain.Relatorio;
import br.com.fiap.infra.addapter.outbound.persistent.entity.RelatorioEntity;
import br.com.fiap.infra.addapter.outbound.persistent.entity.UsuarioEntity;


public interface IRelatorioMapper {
    Relatorio toDomain (RelatorioEntity entity, UsuarioEntity usuario);
    RelatorioEntity toEntity (Relatorio domain);
}
