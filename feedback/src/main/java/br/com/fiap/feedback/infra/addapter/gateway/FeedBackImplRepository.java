package br.com.fiap.feedback.infra.addapter.gateway;

import br.com.fiap.feedback.application.domain.FeedBack;
import br.com.fiap.feedback.application.domain.Relatorio;
import br.com.fiap.feedback.application.domain.Urgencia;
import br.com.fiap.feedback.application.domain.Usuario;
import br.com.fiap.feedback.application.useCase.inbound.avaliacao.Avaliacao;
import br.com.fiap.feedback.application.useCase.outbound.FeedBackRepository;
import br.com.fiap.feedback.infra.addapter.inbound.mapper.IFeedBackMapper;
import br.com.fiap.feedback.infra.addapter.inbound.mapper.IRelatorioMapper;
import br.com.fiap.feedback.infra.addapter.inbound.mapper.IUsuarioMapper;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.AvisoEntity;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.entity.RelatorioEntity;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.repository.AvisoJpaRepository;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.repository.FeedBackJpaRepository;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.repository.RelatorioJpaRepository;
import br.com.fiap.feedback.infra.addapter.outbound.persistent.repository.UsuarioJpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FeedBackImplRepository implements FeedBackRepository {
    private final AvisoJpaRepository avisoJpaRepository;
    private final RelatorioJpaRepository relatorioJpaRepository;
    private final UsuarioJpaRepository usuarioJpaRepository;
    private final FeedBackJpaRepository feedBackJpaRepository;
    private final IUsuarioMapper usuarioMapper;
    private final IFeedBackMapper feedBackMapper;
    private final IRelatorioMapper relatorioMapper;

    public FeedBackImplRepository(AvisoJpaRepository avisoJpaRepository, RelatorioJpaRepository relatorioJpaRepository, UsuarioJpaRepository usuarioJpaRepository, FeedBackJpaRepository feedBackJpaRepository, IUsuarioMapper usuarioMapper, IFeedBackMapper feedBackMapper, IRelatorioMapper relatorioMapper) {
        this.avisoJpaRepository = avisoJpaRepository;
        this.relatorioJpaRepository = relatorioJpaRepository;
        this.usuarioJpaRepository = usuarioJpaRepository;
        this.feedBackJpaRepository = feedBackJpaRepository;
        this.usuarioMapper = usuarioMapper;
        this.feedBackMapper = feedBackMapper;
        this.relatorioMapper = relatorioMapper;
    }

    @Override
    public FeedBack avaliacao(FeedBack avaliacao) {
        return feedBackMapper.toDomain(feedBackJpaRepository.save(feedBackMapper.toEntity(avaliacao)));
    }

    @Override
    public Relatorio aviso(String idFeedback) {
        var feedback = feedBackJpaRepository.findById(idFeedback).orElseThrow(() -> new RuntimeException("Erro na Buscar do feedback em aviso"));
        var entity = new AvisoEntity(
                feedback.getIdFeedBack(),
                feedback.getProfessor(),
                feedback.getDescricao(),
                LocalDateTime.now(),
                null
        );
        if(feedback.getNota() >= 0 && feedback.getNota() < 3) entity.setUrgencia(Urgencia.ALTA.name());
        else if (feedback.getNota() >= 3 && feedback.getNota() < 5) entity.setUrgencia(Urgencia.MEDIA.name());
        else if (feedback.getNota() >= 5 && feedback.getNota() < 8) entity.setUrgencia(Urgencia.MODERADA.name());
        else if (feedback.getNota() >= 8 && feedback.getNota() < 10) entity.setUrgencia(Urgencia.BAIXA.name());

        return relatorioMapper.toAvisoDomain(avisoJpaRepository.save(entity));
    }

    @Override
    public Relatorio relatorio(String professor) {
        List<AvisoEntity> avisos = avisoJpaRepository.findAll()
                .stream().filter(c -> c.getProfessor().equals(professor))
                .toList();
        Map<String, Long> quantidades = avisos.stream()
                .collect(Collectors.groupingBy(
                        AvisoEntity::getUrgencia,
                        Collectors.counting()
                ));

        var maior = quantidades.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        var relatorio = new RelatorioEntity(
                professor,
                "Relatorio semanal referente ao " + professor + " sobre o tema " + maior.getKey(),
                LocalDateTime.now(),
                maior.getKey(),
                maior.getValue()
        );
        return relatorioMapper.toRelatorioDomain(relatorioJpaRepository.save(relatorio));
    }

    @Override
    public Usuario novoUsuario(Usuario usuario) {
        return usuarioMapper.toDomain(usuarioJpaRepository.save(usuarioMapper.toEntity(usuario)));
    }
}
