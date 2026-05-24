package br.com.fiap.application.useCase.inbound.avaliacao;

import br.com.fiap.application.domain.FeedBack;
import br.com.fiap.application.domain.Usuario;

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
                .withAluno(new Usuario.UsuarioBuilder().withCpf(input.aluno).build())
                .withProfessor(new Usuario.UsuarioBuilder().withCpf(input.professor).build())
                .withNota(input.nota)
                .withDescricao(input.descricao)
                .build();
    }
}
