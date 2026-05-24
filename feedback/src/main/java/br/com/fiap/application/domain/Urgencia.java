package br.com.fiap.application.domain;

public enum Urgencia {
    ALTA,
    MEDIA,
    MODERADA,
    BAIXA;

    public static Urgencia fromNota(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota inválida: " + nota);
        }

        if (nota < 3) return ALTA;
        if (nota < 5) return MEDIA;
        if (nota < 8) return MODERADA;

        return BAIXA;
    }
}
