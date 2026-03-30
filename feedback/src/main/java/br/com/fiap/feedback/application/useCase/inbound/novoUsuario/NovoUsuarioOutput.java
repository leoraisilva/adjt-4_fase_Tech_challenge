package br.com.fiap.feedback.application.useCase.inbound.novoUsuario;

import br.com.fiap.feedback.application.domain.Tipo;
import br.com.fiap.feedback.application.domain.Usuario;

public record NovoUsuarioOutput (String nome, String tipo, String email, String tell, String cpf, String curso) {
    public static NovoUsuarioOutput toOutput (Usuario domain) {
        return new NovoUsuarioOutput(
                domain.getNome(),
                domain.getTipo().name(),
                domain.getEmail(),
                domain.getTell(),
                domain.getCpf(),
                domain.getCurso()
        );
    }
}
