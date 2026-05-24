package br.com.fiap.application.domain;

import java.time.LocalDateTime;

public class DefaultRelatorioFactory implements RelatorioFactory {
    public DefaultRelatorioFactory() {
    }

    @Override
    public Relatorio newRelatorio(String idFeedback, Usuario professor, String descricao, LocalDateTime dataEnvio, Urgencia urgencia, Long quantidadeAvalicao) {
        return new Relatorio.RelatorioBuilder()
                .withIdFeedback(idFeedback)
                .withProfessor(professor)
                .withDescricao(descricao)
                .withDataEnvio(dataEnvio)
                .withUrgencia(urgencia)
                .withQuantidadeAvalicao(quantidadeAvalicao)
                .build();
    }

}
