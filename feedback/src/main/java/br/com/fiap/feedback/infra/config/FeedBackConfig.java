package br.com.fiap.feedback.infra.config;

import br.com.fiap.feedback.application.domain.*;
import br.com.fiap.feedback.application.useCase.inbound.relatorio.Relatorio;
import br.com.fiap.feedback.application.service.FeedBackService;
import br.com.fiap.feedback.application.useCase.inbound.FeedbackPorts;
import br.com.fiap.feedback.application.useCase.inbound.avaliacao.Avaliacao;
import br.com.fiap.feedback.application.useCase.inbound.aviso.Aviso;
import br.com.fiap.feedback.application.useCase.inbound.novoUsuario.NovoUsuario;
import br.com.fiap.feedback.application.useCase.outbound.FeedBackRepository;
import br.com.fiap.feedback.infra.addapter.inbound.mapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeedBackConfig {
    @Bean
    IUsuarioMapper usuarioMapper (UsuarioFactory usuarioFactory) {
        return new UsuarioMapper(usuarioFactory);
    }
    @Bean
    IRelatorioMapper relatorioMapper (RelatorioFactory relatorioFactory, UsuarioFactory usuarioFactory) {
        return new RelatorioMapper(relatorioFactory, usuarioFactory);
    }
    @Bean
    IFeedBackMapper feedBackMapper (FeedBackFactory feedBackFactory, UsuarioFactory usuarioFactory) {
        return new FeedBackMapper(feedBackFactory, usuarioFactory);
    }
    @Bean
    UsuarioFactory usuarioFactory () {
        return new DefaultUsuarioFactory();
    }
    @Bean
    FeedBackFactory feedBackFactory () {
        return new DefaultFeedBackFactory();
    }
    @Bean
    RelatorioFactory relatorioFactory () {
        return new DefaultRelatorioFactory();
    }
    @Bean
    FeedbackPorts feedbackPorts(FeedBackRepository repository) {
        return new FeedBackService(repository);
    }
    @Bean
    Avaliacao avaliacao(FeedbackPorts feedbackPorts) {
        return new Avaliacao(feedbackPorts);
    }
    @Bean
    Aviso aviso(FeedbackPorts feedbackPorts) {
        return new Aviso(feedbackPorts);
    }
    @Bean
    NovoUsuario novoUsuario(FeedbackPorts feedbackPorts) {
        return new NovoUsuario(feedbackPorts);
    }
    @Bean
    Relatorio relatorio(FeedbackPorts feedbackPorts) {
        return new Relatorio(feedbackPorts);
    }




}
