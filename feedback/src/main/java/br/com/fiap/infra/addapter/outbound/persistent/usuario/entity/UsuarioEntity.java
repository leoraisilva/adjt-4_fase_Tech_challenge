package br.com.fiap.infra.addapter.outbound.persistent.usuario.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "usuario_tb")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_usuario")
    private String idUsuario;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "tipo", nullable = false)
    private String tipo;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "tell")
    private String tell;
    @Column(name = "CPF", unique = true, nullable = false)
    private String CPF;
    @Column(name = "curso")
    private String curso;

    public UsuarioEntity(String nome, String tipo, String email, String tell, String CPF, String curso) {
        this.nome = nome;
        this.tipo = tipo;
        this.email = email;
        this.tell = tell;
        this.CPF = CPF;
        this.curso = curso;
    }

    public UsuarioEntity() {
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String  getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
