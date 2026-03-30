package br.com.fiap.feedback.application.domain;

public class DefaultFeedBackFactory implements FeedBackFactory {
    public DefaultFeedBackFactory() {}

    @Override
    public FeedBack newFeedBack(Usuario aluno, Usuario professor, String descricao, int nota) {
        return new FeedBack.FeedBackBuilder()
                .withAluno(aluno)
                .withDescricao(descricao)
                .withProfessor(professor)
                .withNota(nota)
                .build();
    }
}
