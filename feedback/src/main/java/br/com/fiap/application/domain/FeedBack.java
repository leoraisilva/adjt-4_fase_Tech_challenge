package br.com.fiap.application.domain;

public class FeedBack {
    private final Usuario aluno;
    private final Usuario professor;
    private final String descricao;
    private final int nota;

    public FeedBack(FeedBackBuilder builder) {
        this.aluno = builder.aluno;
        this.professor = builder.professor;
        this.descricao = builder.descricao;
        this.nota = builder.nota;
    }


    public Usuario getAluno() {
        return aluno;
    }

    public Usuario getProfessor() {
        return professor;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getNota() {
        return nota;
    }

    public static class FeedBackBuilder {
        private Usuario aluno;
        private Usuario professor;
        private String descricao;
        private int nota;

        public FeedBackBuilder withAluno (Usuario aluno){
            this.aluno = aluno;
            return this;
        }

        public FeedBackBuilder withProfessor (Usuario professor){
            this.professor = professor;
            return this;
        }

        public FeedBackBuilder withDescricao (String descricao){
            this.descricao = descricao;
            return this;
        }

        public FeedBackBuilder withNota (int nota){
            this.nota = nota;
            return this;
        }

        public FeedBack build () {
            return new FeedBack(this);
        }
    }
}
