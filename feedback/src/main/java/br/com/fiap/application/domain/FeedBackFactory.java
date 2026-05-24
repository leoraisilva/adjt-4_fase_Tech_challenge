package br.com.fiap.application.domain;

public interface FeedBackFactory {
    FeedBack newFeedBack (Usuario aluno, Usuario professor, String descricao, int nota);
}
