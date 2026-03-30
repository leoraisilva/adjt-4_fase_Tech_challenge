package br.com.fiap.feedback.infra.addapter.inbound.mapper;

import br.com.fiap.feedback.application.domain.FeedBack;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.FeedBackEntity;

public class FeedBackMapper implements IFeedBackMapper{
    @Override
    public FeedBack toDomain(FeedBackEntity entity) {
        return null;
    }

    @Override
    public FeedBackEntity toEntity(FeedBack domain) {
        return null;
    }
}
