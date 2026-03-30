package br.com.fiap.feedback.infra.addapter.outbound.persistent.entity;

import br.com.fiap.feedback.application.domain.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name = "feedback_tb")
public class FeedBackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idFeedBack;
    @Column(name = "aluno", nullable = false)
    private String aluno;
    @Column(name = "professor", nullable = false)
    private String professor;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "nota", nullable = false)
    private int nota;

    public FeedBackEntity(String idFeedBack, String aluno, String professor, String descricao, int nota) {
        this.idFeedBack = idFeedBack;
        this.aluno = aluno;
        this.professor = professor;
        this.descricao = descricao;
        this.nota = nota;
    }

    public FeedBackEntity() {
    }

    public String getIdFeedBack() {
        return idFeedBack;
    }

    public void setIdFeedBack(String idFeedBack) {
        this.idFeedBack = idFeedBack;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
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

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
