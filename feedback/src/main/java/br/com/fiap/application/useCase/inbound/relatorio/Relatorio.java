package br.com.fiap.application.useCase.inbound.relatorio;

import br.com.fiap.application.useCase.inbound.FeedbackPorts;

import java.util.Optional;

public class Relatorio {
    private final FeedbackPorts feedbackPorts;

    public Relatorio(FeedbackPorts feedbackPorts) {
        this.feedbackPorts = feedbackPorts;
    }

    public Optional<RelatorioOutput> relatorio (String idFeedback) {
        return feedbackPorts.relatorio(idFeedback);
    }
}
