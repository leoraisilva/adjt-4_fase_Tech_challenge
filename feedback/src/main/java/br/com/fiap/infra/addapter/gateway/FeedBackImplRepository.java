package br.com.fiap.infra.addapter.gateway;

import br.com.fiap.application.domain.FeedBack;
import br.com.fiap.application.domain.Relatorio;
import br.com.fiap.application.domain.Urgencia;
import br.com.fiap.application.domain.Usuario;
import br.com.fiap.application.useCase.outbound.FeedBackRepository;
import br.com.fiap.infra.addapter.inbound.mapper.feedback.IFeedBackMapper;
import br.com.fiap.infra.addapter.inbound.mapper.relatorio.IRelatorioMapper;
import br.com.fiap.infra.addapter.inbound.mapper.usuario.IUsuarioMapper;
import br.com.fiap.infra.addapter.outbound.persistent.relatorio.entity.RelatorioEntity;
import br.com.fiap.infra.addapter.outbound.persistent.feedback.repository.FeedBackJpaRepository;
import br.com.fiap.infra.addapter.outbound.persistent.relatorio.repository.RelatorioJpaRepository;
import br.com.fiap.infra.addapter.outbound.persistent.usuario.repository.UsuarioJpaRepository;
import io.quarkus.hibernate.orm.PersistenceUnit;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class FeedBackImplRepository implements FeedBackRepository {

    FeedBackJpaRepository feedBackJpaRepository;
    RelatorioJpaRepository relatorioJpaRepository;
    UsuarioJpaRepository usuarioJpaRepository;
    private final IFeedBackMapper feedBackMapper;
    private final IRelatorioMapper relatorioMapper;
    private final IUsuarioMapper usuarioMapper;

    public FeedBackImplRepository(
            FeedBackJpaRepository feedBackJpaRepository,
            RelatorioJpaRepository relatorioJpaRepository,
            UsuarioJpaRepository usuarioJpaRepository,
            IFeedBackMapper feedBackMapper,
            IRelatorioMapper relatorioMapper,
            IUsuarioMapper usuarioMapper) {
        this.feedBackJpaRepository = feedBackJpaRepository;
        this.relatorioJpaRepository = relatorioJpaRepository;
        this.usuarioJpaRepository = usuarioJpaRepository;
        this.feedBackMapper = feedBackMapper;
        this.relatorioMapper = relatorioMapper;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    @Transactional
    public FeedBack avaliacao(FeedBack avaliacao) {
        var feedBackEntity = feedBackMapper.toEntity(avaliacao);
        feedBackJpaRepository.persist(feedBackEntity);
        var aluno = usuarioJpaRepository.findByCPF(feedBackEntity.getAluno());
        var professor = usuarioJpaRepository.findByCPF(feedBackEntity.getProfessor());
        return feedBackMapper.toDomain(feedBackEntity, aluno, professor);
    }

    @Override
    @Transactional
    public Relatorio aviso(String idFeedback) {
        var feedBackEntity = feedBackJpaRepository.findById(idFeedback);
        var usuarioEntity = usuarioJpaRepository.findByCPF(feedBackEntity.getProfessor());
        var entity = new RelatorioEntity(
                feedBackEntity.getIdFeedBack(),
                feedBackEntity.getProfessor(),
                feedBackEntity.getDescricao(),
                LocalDateTime.now(),
                Urgencia.fromNota(feedBackEntity.getNota()).name(),
                null
        );
        return relatorioMapper.toDomain(entity, usuarioEntity);
    }

    @Override
    @Transactional
    public Relatorio relatorio(String professor) {
        List<RelatorioEntity> avisoEntities = relatorioJpaRepository.findAll().stream()
                .filter(c -> c.getProfessor().equals(professor))
                .toList();
        var usuarioEntity = usuarioJpaRepository.findByCPF(professor);
        Map <String, Long> quantidade =avisoEntities.stream()
                .collect(Collectors.groupingBy(
                        RelatorioEntity::getUrgencia,
                    Collectors.counting()
                ));
        var maior = quantidade
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        var relatorioEntity = new RelatorioEntity(
                "",
                professor,
                "Relatorio semanal referente ao " + professor + " sobre o tema " + maior.getKey(),
                LocalDateTime.now(),
                maior.getKey(),
                maior.getValue()
        );

        return relatorioMapper.toDomain(relatorioEntity, usuarioEntity);
    }

    @Override
    @Transactional
    public Usuario novoUsuario(Usuario usuario) {
        var novoUsuario = usuarioMapper.toEntity(usuario);
        usuarioJpaRepository.persist(novoUsuario);
        return usuarioMapper.toDomain(novoUsuario);
    }
}
