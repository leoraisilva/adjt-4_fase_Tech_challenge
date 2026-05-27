package br.com.fiap.infra.addapter.outbound.controller;

import br.com.fiap.application.useCase.inbound.avaliacao.Avaliacao;
import br.com.fiap.application.useCase.inbound.aviso.Aviso;
import br.com.fiap.application.useCase.inbound.novoUsuario.NovoUsuario;
import br.com.fiap.application.useCase.inbound.novoUsuario.NovoUsuarioInput;
import br.com.fiap.application.useCase.inbound.relatorio.Relatorio;
import br.com.fiap.infra.addapter.inbound.dto.AvaliacaoDTO;
import br.com.fiap.infra.addapter.inbound.dto.UsuarioDTO;
import br.com.fiap.infra.listener.SqsListener;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/feedback/api/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FeedBackController {
    private final Avaliacao avaliacao;
    private final Aviso aviso;
    private final Relatorio relatorio;
    private final NovoUsuario novoUsuario;
    private SqsListener sqsListener;

    public FeedBackController(NovoUsuario novoUsuario, Avaliacao avaliacao, Aviso aviso, Relatorio relatorio, SqsListener sqsListener) {
        this.novoUsuario = novoUsuario;
        this.avaliacao = avaliacao;
        this.aviso = aviso;
        this.relatorio = relatorio;
        this.sqsListener = sqsListener;
    }

    @GET
    @Path("/aviso/{id}")
    public Response aviso (@PathParam("id") String idFeedback) {
        return aviso.aviso(idFeedback)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @GET
    @Path("/relatorio/{professor}")
    public Response relatorio (@PathParam("professor") String professor) {
        return relatorio.relatorio(professor)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @POST
    @Path("/usuario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response usuario (UsuarioDTO usuarioDTO) {
        return Response.status(Response.Status.CREATED)
                .entity(novoUsuario.novoUsuario(NovoUsuarioInput.toInput(UsuarioDTO.toDTO(usuarioDTO))))
                .build();
    }

    @POST
    @Path("/avaliacao")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response avaliacao (AvaliacaoDTO avaliacaoDTO) {

        var avaliarMessage = avaliacao.avaliacao(AvaliacaoDTO.toInput(avaliacaoDTO));
        String message = "{" +
                            "aluno : " + avaliarMessage.aluno() + "," +
                            "professor : " + avaliarMessage.professor() + "," +
                            "descrição : " + avaliarMessage.descricao() + "," +
                            "nota : " + avaliarMessage.nota() +
                        "}";
        sqsListener.enviar(message);
        return Response.status(Response.Status.CREATED)
                .entity(avaliarMessage)
                .build();
    }

}
