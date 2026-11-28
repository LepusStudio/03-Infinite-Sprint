package br.edu.ifce.infinitesprint;

import java.util.List;

public class DialogoBox {
    private static final float LETRAS_POR_SEGUNDO = 45f;

    private final List<LinhaDialogo> linhas;
    private int indice;
    private float tempo;

    public DialogoBox(List<LinhaDialogo> linhas) {
        this.linhas = linhas;
    }

    public boolean isFinalizado() {
        return indice >= linhas.size();
    }

    public void atualizar(float dt) {
        if (isFinalizado()) return;
        tempo += dt;
        if (Teclado.confirmar()) {
            int total = linhas.get(indice).texto.length();
            if (tempo * LETRAS_POR_SEGUNDO < total) {
                tempo = 999f;      // revela tudo
            } else {
                indice++;
                tempo = 0f;
            }
        }
    }

    public void desenhar(Gfx g, int tipoProfessor, float t) {
        if (isFinalizado()) return;
        LinhaDialogo l = linhas.get(indice);
        g.rect(20f, 14f, 600f, 104f, Cores.PRETO, 0.88f);
        g.borda(20f, 14f, 600f, 104f, 3f, Cores.CINZA_CLARO);
        g.rect(20f, 118f, 130f, 20f, Cores.AZUL);
        g.textoCentro(l.quem, 85f, 134f, 0.9f, Cores.BRANCO);

        float xTexto = 36f;
        if (l.professor) {
            g.rect(30f, 22f, 84f, 88f, Cores.CINZA_ESCURO);
            Sprites.cabecaProfessor(g, 72f, 70f, 2.6f, tipoProfessor, l.humor, t);
            xTexto = 128f;
        }
        int visiveis = Math.min(l.texto.length(), (int) (tempo * LETRAS_POR_SEGUNDO));
        g.textoQuebrado(l.texto.substring(0, visiveis), xTexto, 104f, 480f, 1.1f, Cores.BRANCO);
        if (visiveis >= l.texto.length() && ((int) (t * 3f)) % 2 == 0) {
            g.texto("ENTER >", 548f, 34f, 0.8f, Cores.OURO);
        }
    }
}