package br.com.fiap.feedback.application.useCase.inbound;

import br.com.fiap.feedback.application.useCase.inbound.avaliacao.AvaliacaoInput;
import br.com.fiap.feedback.application.useCase.inbound.avaliacao.AvaliacaoOutput;
import br.com.fiap.feedback.application.useCase.inbound.aviso.AvisoOutput;
import br.com.fiap.feedback.application.useCase.inbound.novoUsuario.NovoUsuarioInput;
import br.com.fiap.feedback.application.useCase.inbound.novoUsuario.NovoUsuarioOutput;
import br.com.fiap.feedback.application.useCase.inbound.relatorio.RelatorioOutput;

public interface FeedbackPorts {
    AvaliacaoOutput avaliacao (AvaliacaoInput input);
    AvisoOutput aviso (String idFeedback);
    RelatorioOutput relatorio (String idFeedback);
    NovoUsuarioOutput novoUsuario (NovoUsuarioInput input);
}
