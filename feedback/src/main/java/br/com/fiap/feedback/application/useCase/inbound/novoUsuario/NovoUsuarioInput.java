package br.com.fiap.feedback.application.useCase.inbound.novoUsuario;

import br.com.fiap.feedback.application.domain.Tipo;
import br.com.fiap.feedback.application.domain.Usuario;

public record NovoUsuarioInput (String nome, String tipo, String email, String tell, String cpf, String curso) {
    public static NovoUsuarioInput toInput (Usuario domain) {
        return new NovoUsuarioInput(
                domain.getNome(),
                domain.getTipo().name(),
                domain.getEmail(),
                domain.getTell(),
                domain.getCpf(),
                domain.getCurso()
        );
    }

    public static Usuario toDomain (NovoUsuarioInput input) {
        return new Usuario.UsuarioBuilder()
                .withNome(input.nome())
                .withTipo(Tipo.valueOf(input.tipo()))
                .withEmail(input.email())
                .withCpf(input.cpf())
                .withTell(input.tell())
                .withCurso(input.curso())
                .build();
    }
}
