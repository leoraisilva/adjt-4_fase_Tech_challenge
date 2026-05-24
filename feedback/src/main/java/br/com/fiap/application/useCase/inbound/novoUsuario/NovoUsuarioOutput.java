package br.com.fiap.application.useCase.inbound.novoUsuario;

import br.com.fiap.application.domain.Tipo;
import br.com.fiap.application.domain.Usuario;

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
