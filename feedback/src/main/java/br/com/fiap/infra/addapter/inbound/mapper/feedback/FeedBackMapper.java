package br.com.fiap.infra.addapter.inbound.mapper.feedback;

import br.com.fiap.application.domain.FeedBack;
import br.com.fiap.application.domain.FeedBackFactory;
import br.com.fiap.application.domain.Tipo;
import br.com.fiap.application.domain.UsuarioFactory;
import br.com.fiap.infra.addapter.outbound.persistent.feedback.entity.FeedBackEntity;
import br.com.fiap.infra.addapter.outbound.persistent.usuario.entity.UsuarioEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FeedBackMapper implements IFeedBackMapper {
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
