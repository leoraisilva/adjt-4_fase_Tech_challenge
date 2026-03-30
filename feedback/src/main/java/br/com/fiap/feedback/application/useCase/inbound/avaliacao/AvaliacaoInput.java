package br.com.fiap.feedback.application.useCase.inbound.avaliacao;

import br.com.fiap.feedback.application.domain.FeedBack;

public record AvaliacaoInput (String aluno, String professor, String descricao, int nota){
    public static AvaliacaoInput toInput (FeedBack domain) {
        return new AvaliacaoInput(
                domain.getAluno().getNome(),
                domain.getProfessor().getNome(),
                domain.getDescricao(),
                domain.getNota()
        );
    }

    public static FeedBack toDomain (AvaliacaoInput input) {
        return new FeedBack.FeedBackBuilder()
                .withNota(input.nota)
                .withDescricao(input.descricao)
                .build();
    }
}
