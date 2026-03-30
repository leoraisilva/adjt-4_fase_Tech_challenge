package br.com.fiap.feedback.application.domain;

public interface FeedBackFactory {
    FeedBack newFeedBack (Usuario aluno, Usuario professor, String descricao, int nota);
}
