package br.com.fiap.feedback.infra.addapter.inbound.mapper;

import br.com.fiap.feedback.application.domain.FeedBack;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.FeedBackEntity;

public interface IFeedBackMapper {
    FeedBack toDomain (FeedBackEntity entity);
    FeedBackEntity toEntity (FeedBack domain);
}
