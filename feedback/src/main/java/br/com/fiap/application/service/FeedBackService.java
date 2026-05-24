package br.com.fiap.application.service;

import br.com.fiap.application.useCase.inbound.FeedbackPorts;
import br.com.fiap.application.useCase.inbound.avaliacao.AvaliacaoInput;
import br.com.fiap.application.useCase.inbound.avaliacao.AvaliacaoOutput;
import br.com.fiap.application.useCase.inbound.aviso.AvisoOutput;
import br.com.fiap.application.useCase.inbound.novoUsuario.NovoUsuarioInput;
import br.com.fiap.application.useCase.inbound.novoUsuario.NovoUsuarioOutput;
import br.com.fiap.application.useCase.inbound.relatorio.RelatorioOutput;
import br.com.fiap.application.useCase.outbound.FeedBackRepository;

import java.util.Optional;

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
    public Optional<AvisoOutput> aviso(String idFeedback) {
        return Optional.of(AvisoOutput.toOutput(repository.aviso(idFeedback)));
    }

    @Override
    public Optional<RelatorioOutput> relatorio(String professor) {
        return Optional.of(RelatorioOutput.toOutput(repository.relatorio(professor)));
    }

    @Override
    public NovoUsuarioOutput novoUsuario(NovoUsuarioInput input) {
        return NovoUsuarioOutput.toOutput(repository.novoUsuario(NovoUsuarioInput.toDomain(input)));
    }
}
