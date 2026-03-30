package br.com.fiap.feedback.application.useCase.inbound.relatorio;

import br.com.fiap.feedback.application.useCase.inbound.FeedbackPorts;

public class Relatorio {
    private final FeedbackPorts feedbackPorts;

    public Relatorio(FeedbackPorts feedbackPorts) {
        this.feedbackPorts = feedbackPorts;
    }

    public RelatorioOutput relatorio (String idFeedback) {
        return feedbackPorts.relatorio();
    }
}
