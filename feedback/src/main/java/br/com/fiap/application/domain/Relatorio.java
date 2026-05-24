package br.com.fiap.application.domain;

import java.time.LocalDateTime;

public class Relatorio {
    private final String idFeedback;
    private final Usuario professor;
    private final String descricao;
    private final LocalDateTime dataEnvio;
    private final Urgencia urgencia;
    private final Long quantidadeAvaliacao;

    public Relatorio(RelatorioBuilder builder) {
        this.idFeedback = builder.idFeedback;
        this.professor = builder.professor;
        this.descricao = builder.descricao;
        this.dataEnvio = builder.dataEnvio;
        this.urgencia = builder.urgencia;
        this.quantidadeAvaliacao = builder.quantidadeAvalicao;
    }

    public String getIdFeedback() {
        return idFeedback;
    }

    public Usuario getProfessor() {
        return professor;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public Urgencia getUrgencia() {
        return urgencia;
    }

    public Long getQuantidadeAvaliacao () {
        return quantidadeAvaliacao;
    }

    public static class RelatorioBuilder {
        private String idFeedback;
        private Usuario professor;
        private String descricao;
        private LocalDateTime dataEnvio;
        private Urgencia urgencia;
        private Long quantidadeAvalicao;


        public RelatorioBuilder withIdFeedback (String idFeedback) {
            this.idFeedback = idFeedback;
            return this;
        }
        public RelatorioBuilder withProfessor (Usuario professor) {
            this.professor = professor;
            return this;
        }
        public RelatorioBuilder withDescricao (String descricao) {
            this.descricao = descricao;
            return this;
        }
        public RelatorioBuilder withDataEnvio (LocalDateTime dataEnvio) {
            this.dataEnvio = dataEnvio;
            return this;
        }
        public RelatorioBuilder withUrgencia (Urgencia urgencia) {
            this.urgencia = urgencia;
            return this;
        }
        public RelatorioBuilder withQuantidadeAvalicao (Long quantidadeAvalicao) {
            this.quantidadeAvalicao = quantidadeAvalicao;
            return this;
        }
        public Relatorio build () {
            return new Relatorio(this);
        }
    }
}
