package br.com.fiap.feedback.application.useCase.inbound.aviso;

import br.com.fiap.feedback.application.useCase.inbound.FeedbackPorts;
import br.com.fiap.feedback.application.useCase.inbound.avaliacao.AvaliacaoInput;
import br.com.fiap.feedback.application.useCase.inbound.avaliacao.AvaliacaoOutput;

public class Aviso {
    private final FeedbackPorts feedbackPorts;

    public Aviso(FeedbackPorts feedbackPorts) {
        this.feedbackPorts = feedbackPorts;
    }

    public AvisoOutput aviso (String idFeedback) {
        return feedbackPorts.aviso(idFeedback);
    }
}
