package br.com.fiap.feedback.application.useCase.inbound.novoUsuario;

import br.com.fiap.feedback.application.useCase.inbound.FeedbackPorts;

public class NovoUsuario {
    private final FeedbackPorts feedbackPorts;

    public NovoUsuario(FeedbackPorts feedbackPorts) {
        this.feedbackPorts = feedbackPorts;
    }

    public NovoUsuarioOutput novoUsuario (NovoUsuarioInput input) {
        return feedbackPorts.novoUsuario(input);
    }
}
