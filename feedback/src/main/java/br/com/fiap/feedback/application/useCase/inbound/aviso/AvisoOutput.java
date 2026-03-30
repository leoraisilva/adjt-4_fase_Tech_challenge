package br.com.fiap.feedback.application.useCase.inbound.aviso;

import br.com.fiap.feedback.application.domain.Relatorio;
import br.com.fiap.feedback.application.domain.Urgencia;
import br.com.fiap.feedback.application.domain.Usuario;

import java.time.LocalDateTime;

public record AvisoOutput (Usuario professor, String idFeedBack, String descricao, LocalDateTime dataEnvio, Urgencia urgencia) {
    public static AvisoOutput toOutput (Relatorio domain) {
        return new AvisoOutput(
                domain.getProfessor(),
                domain.getIdFeedback(),
                domain.getDescricao(),
                domain.getDataEnvio(),
                domain.getUrgencia()
        );
    }
}
