package br.com.fiap.infra.addapter.inbound.dto;

import br.com.fiap.application.domain.Tipo;
import br.com.fiap.application.domain.Usuario;

public record UsuarioDTO (String nome, String tipo, String email, String tell, String cpf, String curso) {
    public static Usuario toDTO (UsuarioDTO usuarioDTO) {
        return new Usuario.UsuarioBuilder()
                .withNome(usuarioDTO.nome())
                .withTipo(Tipo.valueOf(usuarioDTO.tipo()))
                .withEmail(usuarioDTO.email())
                .withTell(usuarioDTO.tell())
                .withCpf(usuarioDTO.cpf())
                .withCurso(usuarioDTO.curso())
                .build();
    }
}
