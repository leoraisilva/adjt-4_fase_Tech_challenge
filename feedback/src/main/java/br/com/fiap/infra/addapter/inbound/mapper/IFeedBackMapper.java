package br.com.fiap.infra.addapter.inbound.mapper;

import br.com.fiap.application.domain.FeedBack;
import br.com.fiap.infra.addapter.outbound.persistent.entity.FeedBackEntity;
import br.com.fiap.infra.addapter.outbound.persistent.entity.UsuarioEntity;
import jakarta.enterprise.context.ApplicationScoped;


public interface IFeedBackMapper {
    FeedBack toDomain (FeedBackEntity entity, UsuarioEntity aluno, UsuarioEntity professor);
    FeedBackEntity toEntity (FeedBack domain);
}
