package br.com.fiap.application.useCase.inbound.avaliacao;

import br.com.fiap.application.useCase.inbound.FeedbackPorts;

public class Avaliacao {
    private final FeedbackPorts feedbackPorts;

    public Avaliacao(FeedbackPorts feedbackPorts) {
        this.feedbackPorts = feedbackPorts;
    }

    public AvaliacaoOutput avaliacao (AvaliacaoInput input) {
        return feedbackPorts.avaliacao(input);
    }

}
