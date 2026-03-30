package br.com.fiap.feedback.infra.addapter.outbound.persistent.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "aviso_tb")
public class AvisoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idAviso;
    @Column(name = "id_feedback", nullable = false)
    private String idFeedback;
    @Column(name = "professor", nullable = false)
    private String professor;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "LocalDateTime", nullable = false)
    private LocalDateTime dataEnvio;
    @Column(name = "urgencia", nullable = false)
    private String urgencia;

    public AvisoEntity(String idFeedback ,String professor, String descricao, LocalDateTime dataEnvio, String urgencia) {
        this.idFeedback = idFeedback;
        this.professor = professor;
        this.descricao = descricao;
        this.dataEnvio = dataEnvio;
        this.urgencia = urgencia;
    }

    public AvisoEntity() { }

    public String getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(String idAviso) {
        this.idAviso = idAviso;
    }

    public String getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(String idFeedback) {
        this.idFeedback = idFeedback;
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
}
