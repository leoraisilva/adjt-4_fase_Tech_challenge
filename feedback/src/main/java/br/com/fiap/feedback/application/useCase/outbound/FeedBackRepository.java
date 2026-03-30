package br.com.fiap.feedback.application.useCase.outbound;

import br.com.fiap.feedback.application.domain.FeedBack;
import br.com.fiap.feedback.application.domain.Relatorio;
import br.com.fiap.feedback.application.domain.Usuario;
import br.com.fiap.feedback.application.useCase.inbound.avaliacao.Avaliacao;
import br.com.fiap.feedback.application.useCase.inbound.avaliacao.AvaliacaoInput;
import br.com.fiap.feedback.application.useCase.inbound.avaliacao.AvaliacaoOutput;
import br.com.fiap.feedback.application.useCase.inbound.aviso.AvisoOutput;
import br.com.fiap.feedback.application.useCase.inbound.novoUsuario.NovoUsuarioInput;
import br.com.fiap.feedback.application.useCase.inbound.novoUsuario.NovoUsuarioOutput;
import br.com.fiap.feedback.application.useCase.inbound.relatorio.RelatorioOutput;

public interface FeedBackRepository {
    FeedBack avaliacao (FeedBack avaliacao);
    Relatorio aviso (String idFeedback);
    Relatorio relatorio (String professor);
    Usuario novoUsuario (Usuario usuario);
}
