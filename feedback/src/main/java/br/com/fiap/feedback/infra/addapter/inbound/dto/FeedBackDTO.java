package br.com.fiap.feedback.infra.addapter.inbound.dto;

import br.com.fiap.feedback.application.domain.Usuario;
import br.com.fiap.feedback.application.useCase.inbound.avaliacao.AvaliacaoInput;

public record FeedBackDTO (String aluno, String professor, String descricao, int nota) {
    public static AvaliacaoInput toInput (FeedBackDTO feedBackDTO) {
        return new AvaliacaoInput(
                feedBackDTO.aluno(),
                feedBackDTO.professor(),
                feedBackDTO.descricao(),
                feedBackDTO.nota()
        );
    }
}
