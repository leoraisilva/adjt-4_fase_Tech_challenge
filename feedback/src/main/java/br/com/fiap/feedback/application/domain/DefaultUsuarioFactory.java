package br.com.fiap.feedback.application.domain;

public class DefaultUsuarioFactory implements UsuarioFactory {
    public DefaultUsuarioFactory() {}

    @Override
    public Usuario newUsuario(String nome, Tipo tipo, String email, String tell, String cpf, String curso) {
        return new Usuario.UsuarioBuilder()
                .withNome(nome)
                .withTipo(tipo)
                .withEmail(email)
                .withTell(tell)
                .withCpf(cpf)
                .withCurso(curso)
                .build();
    }
}
