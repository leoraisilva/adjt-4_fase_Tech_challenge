package br.com.fiap.feedback.infra.addapter.inbound.mapper;

import br.com.fiap.feedback.application.domain.FeedBack;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.FeedBackEntity;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.UsuarioEntity;

public interface IFeedBackMapper {
    FeedBack toDomain (FeedBackEntity entity, UsuarioEntity aluno, UsuarioEntity professor);
    FeedBackEntity toEntity (FeedBack domain);
}
