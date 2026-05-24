package br.com.fiap.application.useCase.inbound.aviso;

import br.com.fiap.application.useCase.inbound.FeedbackPorts;
import br.com.fiap.application.useCase.inbound.avaliacao.AvaliacaoInput;
import br.com.fiap.application.useCase.inbound.avaliacao.AvaliacaoOutput;

import java.util.Optional;

public class Aviso {
    private final FeedbackPorts feedbackPorts;

    public Aviso(FeedbackPorts feedbackPorts) {
        this.feedbackPorts = feedbackPorts;
    }

    public Optional<AvisoOutput> aviso (String idFeedback) {
        return feedbackPorts.aviso(idFeedback);
    }
}
