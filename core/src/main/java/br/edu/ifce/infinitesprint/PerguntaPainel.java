package br.edu.ifce.infinitesprint;

import com.badlogic.gdx.graphics.Color;

public class PerguntaPainel {
    public enum Resultado { ACERTOU, ERROU, TEMPO }

    public static final float TEMPO_LIMITE = 5f;

    private final Pergunta pergunta;
    private float tempoRestante = TEMPO_LIMITE;
    private int selecionada;
    private Resultado resultado;

    public PerguntaPainel(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public boolean terminou() { return resultado != null; }
    public Resultado getResultado() { return resultado; }

    public void atualizar(float dt) {
        if (resultado != null) return;
        tempoRestante -= dt;
        int n = Pergunta.NUM_ALTERNATIVAS;
        if (Teclado.cima()) selecionada = (selecionada + n - 1) % n;
        if (Teclado.baixo()) selecionada = (selecionada + 1) % n;
        if (Teclado.confirmar()) {
            resultado = selecionada == pergunta.getIndiceCorreto() ? Resultado.ACERTOU : Resultado.ERROU;
            return;
        }
        if (tempoRestante <= 0f) {
            tempoRestante = 0f;
            resultado = Resultado.TEMPO;
        }
    }

    public void desenhar(Gfx g) {
        g.rect(0, 0, Gfx.LARGURA, Gfx.ALTURA, Cores.PRETO, 0.55f);
        g.rect(50f, 24f, 540f, 312f, Cores.CINZA_ESCURO);
        g.borda(50f, 24f, 540f, 312f, 3f, Cores.CINZA_CLARO);

        float ratio = Math.max(0f, tempoRestante / TEMPO_LIMITE);
        Color cor = ratio > 0.5f ? Cores.VERDE : (ratio > 0.25f ? Cores.AMARELO : Cores.VERMELHO);
        g.rect(70f, 306f, 500f, 14f, Cores.PRETO);
        g.rect(72f, 308f, 496f * ratio, 10f, cor);
        g.texto("TEMPO: " + (Math.round(tempoRestante * 10f) / 10f) + "s", 70f, 332f, 0.9f, Cores.BRANCO);

        g.textoQuebrado(pergunta.getEnunciado(), 70f, 288f, 500f, 1.2f, Cores.BRANCO);

        for (int i = 0; i < Pergunta.NUM_ALTERNATIVAS; i++) {
            float y = 188f - i * 38f;
            boolean sel = i == selecionada;
            g.rect(70f, y, 500f, 32f, sel ? Cores.AZUL : Cores.PRETO, sel ? 0.9f : 0.45f);
            g.borda(70f, y, 500f, 32f, 2f, sel ? Cores.OURO : Cores.CINZA);
            String rotulo = (char) ('A' + i) + ") " + pergunta.getAlternativa(i);
            g.texto((sel ? "> " : "  ") + rotulo, 80f, y + 24f, 1.1f, sel ? Cores.OURO_CLARO : Cores.BRANCO);
        }
    }
}