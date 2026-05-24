package br.com.fiap.infra.config;

import br.com.fiap.application.domain.*;
import br.com.fiap.application.service.FeedBackService;
import br.com.fiap.application.useCase.inbound.FeedbackPorts;
import br.com.fiap.application.useCase.inbound.avaliacao.Avaliacao;
import br.com.fiap.application.useCase.inbound.aviso.Aviso;
import br.com.fiap.application.useCase.inbound.novoUsuario.NovoUsuario;
import br.com.fiap.application.useCase.inbound.relatorio.Relatorio;
import br.com.fiap.application.useCase.outbound.FeedBackRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;

@ApplicationScoped
public class FeedbackConfig {

    @ApplicationScoped
    UsuarioFactory usuarioFactory() {
        return new DefaultUsuarioFactory();
    }

    @ApplicationScoped
    FeedBackFactory feedBackFactory() {
        return new DefaultFeedBackFactory();
    }

    @ApplicationScoped
    RelatorioFactory relatorioFactory() {
        return new DefaultRelatorioFactory();
    }

    @ApplicationScoped
    FeedbackPorts feedbackPorts(FeedBackRepository repository) {
        return new FeedBackService(repository);
    }

    @ApplicationScoped
    Avaliacao avaliacao(FeedbackPorts feedbackPorts) {
        return new Avaliacao(feedbackPorts);
    }

    @ApplicationScoped
    Aviso aviso(FeedbackPorts feedbackPorts) {
        return new Aviso(feedbackPorts);
    }

    @ApplicationScoped
    NovoUsuario novoUsuario(FeedbackPorts feedbackPorts) {
        return new NovoUsuario(feedbackPorts);
    }

    @ApplicationScoped
    Relatorio relatorio(FeedbackPorts feedbackPorts) {
        return new Relatorio(feedbackPorts);
    }
}