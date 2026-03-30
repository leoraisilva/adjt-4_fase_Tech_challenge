package br.com.fiap.feedback.infra.addapter.outbound.controller;

import br.com.fiap.feedback.application.useCase.inbound.avaliacao.Avaliacao;
import br.com.fiap.feedback.application.useCase.inbound.avaliacao.AvaliacaoOutput;
import br.com.fiap.feedback.application.useCase.inbound.aviso.Aviso;
import br.com.fiap.feedback.application.useCase.inbound.aviso.AvisoOutput;
import br.com.fiap.feedback.application.useCase.inbound.novoUsuario.NovoUsuario;
import br.com.fiap.feedback.application.useCase.inbound.novoUsuario.NovoUsuarioInput;
import br.com.fiap.feedback.application.useCase.inbound.novoUsuario.NovoUsuarioOutput;
import br.com.fiap.feedback.application.useCase.inbound.relatorio.Relatorio;
import br.com.fiap.feedback.application.useCase.inbound.relatorio.RelatorioOutput;
import br.com.fiap.feedback.infra.addapter.inbound.dto.FeedBackDTO;
import br.com.fiap.feedback.infra.addapter.inbound.dto.UsuarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/feedback/v1/api")
public class FeedBackController {

    private final Avaliacao avaliacao;
    private final Relatorio relatorio;
    private final NovoUsuario novoUsuario;
    private final Aviso aviso;

    public FeedBackController(Avaliacao avaliacao, Relatorio relatorio, NovoUsuario novoUsuario, Aviso aviso) {
        this.avaliacao = avaliacao;
        this.relatorio = relatorio;
        this.novoUsuario = novoUsuario;
        this.aviso = aviso;
    }

    @PostMapping("/usuario/criar")
    public ResponseEntity<NovoUsuarioOutput> newUsuario (@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario.novoUsuario(NovoUsuarioInput.toInput(UsuarioDTO.toDTO(usuarioDTO))));
    }

    @PostMapping("/aviso/{idFeedback}")
    public ResponseEntity<AvisoOutput> aviso (@PathVariable (value = "idFeedback") String idFeedback) {
        return ResponseEntity.status(HttpStatus.OK).body(aviso.aviso(idFeedback));
    }

    @PostMapping("/relatorio/{professor}")
    public ResponseEntity<RelatorioOutput> relatorio (@PathVariable (value = "professor") String professor){
        return ResponseEntity.status(HttpStatus.OK).body(relatorio.relatorio(professor));
    }

    @PostMapping("/avaliacao")
    public ResponseEntity<AvaliacaoOutput> avaliacao (@RequestBody FeedBackDTO feedBackDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(avaliacao.avaliacao(FeedBackDTO.toInput(feedBackDTO)));
    }

}
