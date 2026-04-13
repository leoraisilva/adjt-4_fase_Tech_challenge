package br.com.fiap.feedback.infra.addapter.inbound.mapper;

import br.com.fiap.feedback.application.domain.*;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.FeedBackEntity;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.UsuarioEntity;

public class FeedBackMapper implements IFeedBackMapper{
    private final FeedBackFactory feedBackFactory;
    private final UsuarioFactory usuarioFactory;
    public FeedBackMapper (FeedBackFactory feedBackFactory, UsuarioFactory usuarioFactory) {
        this.feedBackFactory = feedBackFactory;
        this.usuarioFactory = usuarioFactory;
    }
    @Override
    public FeedBack toDomain(FeedBackEntity entity, UsuarioEntity aluno, UsuarioEntity professor) {
        return feedBackFactory.newFeedBack(
                usuarioFactory.newUsuario(
                        aluno.getNome(),
                        Tipo.valueOf(aluno.getTipo()),
                        aluno.getEmail(),
                        aluno.getTell(),
                        aluno.getCPF(),
                        aluno.getCurso()
                ),
                usuarioFactory.newUsuario(
                        professor.getNome(),
                        Tipo.valueOf(professor.getTipo()),
                        professor.getEmail(),
                        professor.getTell(),
                        professor.getCPF(),
                        professor.getCurso()
                ),
                entity.getDescricao(),
                entity.getNota()
        );
    }

    @Override
    public FeedBackEntity toEntity(FeedBack domain) {
        return new FeedBackEntity(
                domain.getAluno().getCpf(),
                domain.getProfessor().getCpf(),
                domain.getDescricao(),
                domain.getNota()
        );
    }
}
