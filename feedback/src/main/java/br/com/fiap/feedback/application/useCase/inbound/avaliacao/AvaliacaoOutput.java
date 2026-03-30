package br.com.fiap.feedback.application.useCase.inbound.avaliacao;

import br.com.fiap.feedback.application.domain.FeedBack;

public record AvaliacaoOutput(String aluno, String professor, String descricao, int nota) {
    public static AvaliacaoOutput toOutput (FeedBack domain) {
        return new AvaliacaoOutput(
                domain.getAluno().getNome(),
                domain.getProfessor().getNome(),
                domain.getDescricao(),
                domain.getNota()
        );
    }
}
