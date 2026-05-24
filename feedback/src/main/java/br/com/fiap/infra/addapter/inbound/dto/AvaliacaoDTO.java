package br.com.fiap.infra.addapter.inbound.dto;

import br.com.fiap.application.useCase.inbound.avaliacao.AvaliacaoInput;

public record AvaliacaoDTO(String aluno, String professor, String descricao, int nota) {
    public static AvaliacaoInput toInput (AvaliacaoDTO feedBackDTO) {
        return new AvaliacaoInput(
                feedBackDTO.aluno(),
                feedBackDTO.professor(),
                feedBackDTO.descricao(),
                feedBackDTO.nota()
        );
    }
}
