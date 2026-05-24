package br.com.fiap.application.domain;

import java.time.LocalDateTime;

public interface RelatorioFactory {
    Relatorio newRelatorio (String idFeedback, Usuario professor, String descricao, LocalDateTime dataEnvio, Urgencia urgencia, Long quantidadeAvalicao);
}
