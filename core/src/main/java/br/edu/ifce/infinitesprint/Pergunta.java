package br.edu.ifce.infinitesprint;

public class Pergunta {
    public static final int NUM_ALTERNATIVAS = 5;

    private final String enunciado;
    private final String[] alternativas;
    private final int indiceCorreto;

    public Pergunta(String enunciado, String[] alternativas, int indiceCorreto) {
        if (alternativas == null || alternativas.length != NUM_ALTERNATIVAS) {
            throw new IllegalArgumentException("Cada pergunta precisa de exatamente 5 alternativas.");
        }
        if (indiceCorreto < 0 || indiceCorreto >= NUM_ALTERNATIVAS) {
            throw new IllegalArgumentException("Indice da alternativa correta invalido.");
        }
        this.enunciado = enunciado;
        this.alternativas = alternativas.clone();
        this.indiceCorreto = indiceCorreto;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getAlternativa(int i) {
        return alternativas[i];
    }

    public int getIndiceCorreto() {
        return indiceCorreto;
    }
}