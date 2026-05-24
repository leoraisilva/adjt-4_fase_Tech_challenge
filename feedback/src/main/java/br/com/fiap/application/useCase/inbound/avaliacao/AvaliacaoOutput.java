package br.com.fiap.application.useCase.inbound.avaliacao;

import br.com.fiap.application.domain.FeedBack;

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
