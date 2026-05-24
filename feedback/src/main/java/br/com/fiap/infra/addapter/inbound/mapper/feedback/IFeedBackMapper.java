package br.com.fiap.infra.addapter.inbound.mapper.feedback;

import br.com.fiap.application.domain.FeedBack;
import br.com.fiap.infra.addapter.outbound.persistent.feedback.entity.FeedBackEntity;
import br.com.fiap.infra.addapter.outbound.persistent.usuario.entity.UsuarioEntity;


public interface IFeedBackMapper {
    FeedBack toDomain (FeedBackEntity entity, UsuarioEntity aluno, UsuarioEntity professor);
    FeedBackEntity toEntity (FeedBack domain);
}
