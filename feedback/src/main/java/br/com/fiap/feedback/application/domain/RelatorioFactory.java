package br.com.fiap.feedback.application.domain;

import java.time.LocalDateTime;

public interface RelatorioFactory {
    Relatorio newAviso (String idFeedback, Usuario professor, String descricao, LocalDateTime dataEnvio, Urgencia urgencia);
    Relatorio newRelatorio (Usuario professor, String descricao, LocalDateTime dataEnvio, Urgencia urgencia, Long quantidadeAvaliacao);
}
