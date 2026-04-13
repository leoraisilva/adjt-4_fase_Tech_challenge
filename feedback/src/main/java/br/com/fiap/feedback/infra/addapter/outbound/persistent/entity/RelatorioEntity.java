package br.com.fiap.feedback.infra.addapter.outbound.persistent.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "relatorio_tb")
public class RelatorioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idRelatorio;
    @Column(name = "professor", nullable = false)
    private String professor;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "LocalDateTime", nullable = false)
    private LocalDateTime dataEnvio;
    @Column(name = "urgencia", nullable = false)
    private String urgencia;
    @Column(name = "quantidadeAvalicao", nullable = false)
    private Long quantidadeAvalicao;

    public RelatorioEntity(String professor, String descricao, LocalDateTime dataEnvio, String urgencia, Long quantidadeAvalicao) {
        this.professor = professor;
        this.descricao = descricao;
        this.dataEnvio = dataEnvio;
        this.urgencia = urgencia;
        this.quantidadeAvalicao = quantidadeAvalicao;
    }

    public RelatorioEntity() { }

    public String getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(String idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public Long getQuantidadeAvalicao() {
        return quantidadeAvalicao;
    }

    public void setQuantidadeAvalicao(Long quantidadeAvalicao) {
        this.quantidadeAvalicao = quantidadeAvalicao;
    }
}
