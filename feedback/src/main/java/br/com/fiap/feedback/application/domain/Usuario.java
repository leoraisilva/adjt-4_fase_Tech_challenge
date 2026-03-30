package br.com.fiap.feedback.application.domain;

public class Usuario {
    private final String nome;
    private final Tipo tipo;
    private final String email;
    private final String tell;
    private final String cpf;
    private final String curso;

    public Usuario(UsuarioBuilder builder) {
        this.nome = builder.nome;
        this.tipo = builder.tipo;
        this.email = builder.email;
        this.tell = builder.tell;
        this.cpf = builder.cpf;
        this.curso = builder.curso;
    }

    public String getNome() {
        return nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getEmail() {
        return email;
    }

    public String getTell() {
        return tell;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCurso() {
        return curso;
    }

    public static class UsuarioBuilder {
        private String nome;
        private Tipo tipo;
        private String email;
        private String tell;
        private String cpf;
        private String curso;

        public UsuarioBuilder withNome (String nome) {
            this.nome = nome;
            return this;
        }
        public UsuarioBuilder withTipo (Tipo tipo) {
            this.tipo = tipo;
            return this;
        }
        public UsuarioBuilder withEmail (String email) {
            this.email = email;
            return this;
        }
        public UsuarioBuilder withTell (String tell) {
            this.tell = tell;
            return this;
        }
        public UsuarioBuilder withCpf (String cpf) {
            this.cpf = cpf;
            return this;
        }
        public UsuarioBuilder withCurso (String curso) {
            this.nome = nome;
            return this;
        }
        public Usuario build () {
            return new Usuario(this);
        }
    }
}
