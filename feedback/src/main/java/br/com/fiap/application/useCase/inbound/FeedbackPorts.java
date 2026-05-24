package br.com.fiap.application.useCase.inbound;

import br.com.fiap.application.useCase.inbound.avaliacao.AvaliacaoInput;
import br.com.fiap.application.useCase.inbound.avaliacao.AvaliacaoOutput;
import br.com.fiap.application.useCase.inbound.aviso.AvisoOutput;
import br.com.fiap.application.useCase.inbound.novoUsuario.NovoUsuarioInput;
import br.com.fiap.application.useCase.inbound.novoUsuario.NovoUsuarioOutput;
import br.com.fiap.application.useCase.inbound.relatorio.RelatorioOutput;

import java.util.Optional;

public interface FeedbackPorts {
    AvaliacaoOutput avaliacao (AvaliacaoInput input);
    Optional<AvisoOutput> aviso (String idFeedback);
    Optional<RelatorioOutput> relatorio (String idFeedback);
    NovoUsuarioOutput novoUsuario (NovoUsuarioInput input);
}
