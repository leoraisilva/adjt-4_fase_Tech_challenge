package br.com.fiap.application.useCase.outbound;

import br.com.fiap.application.domain.FeedBack;
import br.com.fiap.application.domain.Relatorio;
import br.com.fiap.application.domain.Usuario;
import br.com.fiap.application.useCase.inbound.avaliacao.Avaliacao;
import br.com.fiap.application.useCase.inbound.avaliacao.AvaliacaoInput;
import br.com.fiap.application.useCase.inbound.avaliacao.AvaliacaoOutput;
import br.com.fiap.application.useCase.inbound.aviso.AvisoOutput;
import br.com.fiap.application.useCase.inbound.novoUsuario.NovoUsuarioInput;
import br.com.fiap.application.useCase.inbound.novoUsuario.NovoUsuarioOutput;
import br.com.fiap.application.useCase.inbound.relatorio.RelatorioOutput;

public interface FeedBackRepository {
    FeedBack avaliacao (FeedBack avaliacao);
    Relatorio aviso (String idFeedback);
    Relatorio relatorio (String professor);
    Usuario novoUsuario (Usuario usuario);
}
