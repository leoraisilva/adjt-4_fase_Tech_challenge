package br.com.fiap.application.useCase.inbound.relatorio;

import br.com.fiap.application.domain.Relatorio;
import br.com.fiap.application.domain.Urgencia;
import br.com.fiap.application.domain.Usuario;

import java.time.LocalDateTime;

public record RelatorioOutput(String professor, String descricao, LocalDateTime dataEnvio, String urgencia, Long quantidadeAvaliacao) {
    public static RelatorioOutput toOutput (Relatorio domain) {
        return new RelatorioOutput(
                domain.getProfessor().getNome(),
                domain.getDescricao(),
                domain.getDataEnvio(),
                domain.getUrgencia().name(),
                domain.getQuantidadeAvaliacao()
        );
    }
}
