package br.com.fiap.application.domain;

public interface UsuarioFactory {
    Usuario newUsuario (String nome, Tipo tipo, String email, String tell, String cpf, String curso);
}
