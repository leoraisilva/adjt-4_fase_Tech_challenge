package br.com.fiap.feedback.application.domain;

import java.time.LocalDateTime;

public class DefaultRelatorioFactory implements RelatorioFactory {
    public DefaultRelatorioFactory() {
    }

    @Override
    public Relatorio newAviso(String idFeedback, Usuario professor, String descricao, LocalDateTime dataEnvio, Urgencia urgencia) {
        return new Relatorio.RelatorioBuilder()
                .withIdFeedback(idFeedback)
                .withProfessor(professor)
                .withDescricao(descricao)
                .withDataEnvio(dataEnvio)
                .withUrgencia(urgencia)
                .build();
    }

    @Override
    public Relatorio newRelatorio(String idFeedback, Usuario professor, String descricao, LocalDateTime dataEnvio, Urgencia urgencia, Long quantidadeAvaliacao) {
        return new Relatorio.RelatorioBuilder()
                .withIdFeedback(idFeedback)
                .withProfessor(professor)
                .withDescricao(descricao)
                .withDataEnvio(dataEnvio)
                .withUrgencia(urgencia)
                .withQuantidadeAvalicao(quantidadeAvaliacao)
                .build();
    }

}
