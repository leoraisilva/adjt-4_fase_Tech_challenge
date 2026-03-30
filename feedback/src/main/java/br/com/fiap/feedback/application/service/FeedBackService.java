package br.com.fiap.feedback.application.service;

import br.com.fiap.feedback.application.useCase.inbound.FeedbackPorts;
import br.com.fiap.feedback.application.useCase.inbound.avaliacao.AvaliacaoInput;
import br.com.fiap.feedback.application.useCase.inbound.avaliacao.AvaliacaoOutput;
import br.com.fiap.feedback.application.useCase.inbound.aviso.AvisoOutput;
import br.com.fiap.feedback.application.useCase.inbound.novoUsuario.NovoUsuarioInput;
import br.com.fiap.feedback.application.useCase.inbound.novoUsuario.NovoUsuarioOutput;
import br.com.fiap.feedback.application.useCase.inbound.relatorio.RelatorioOutput;
import br.com.fiap.feedback.application.useCase.outbound.FeedBackRepository;

public class FeedBackService implements FeedbackPorts {
    private final FeedBackRepository repository;

    public FeedBackService(FeedBackRepository repository) {
        this.repository = repository;
    }

    @Override
    public AvaliacaoOutput avaliacao(AvaliacaoInput input) {
        return AvaliacaoOutput.toOutput(repository.avaliacao(AvaliacaoInput.toDomain(input)));
    }

    @Override
    public AvisoOutput aviso(String idFeedback) {
        return AvisoOutput.toOutput(repository.aviso(idFeedback));
    }

    @Override
    public RelatorioOutput relatorio(String professor) {
        return RelatorioOutput.toOutput(repository.relatorio(professor));
    }

    @Override
    public NovoUsuarioOutput novoUsuario(NovoUsuarioInput input) {
        return NovoUsuarioOutput.toOutput(repository.novoUsuario(NovoUsuarioInput.toDomain(input)));
    }
}
