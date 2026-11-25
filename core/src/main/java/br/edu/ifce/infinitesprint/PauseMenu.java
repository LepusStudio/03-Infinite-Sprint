package br.edu.ifce.infinitesprint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class PauseMenu {
    public enum Acao { NENHUMA, CONTINUAR, MENU }

    private static final String[] ITENS = {"CONTINUAR", "VOLTAR AO MENU PRINCIPAL"};

    private final Rectangle[] botoes = {
            new Rectangle(170f, 168f, 300f, 36f),
            new Rectangle(170f, 122f, 300f, 36f)
    };
    private boolean aberto;
    private int selecionado;

    public boolean isAberto() { return aberto; }

    public void alternar() {
        aberto = !aberto;
        selecionado = 0;
    }

    public void fechar() { aberto = false; }

    public Acao atualizar(Gfx g) {
        if (Teclado.cima()) selecionado = (selecionado + ITENS.length - 1) % ITENS.length;
        if (Teclado.baixo()) selecionado = (selecionado + 1) % ITENS.length;

        Vector2 m = g.mouse();
        boolean moveu = Gdx.input.getDeltaX() != 0 || Gdx.input.getDeltaY() != 0;
        boolean clique = Gdx.input.justTouched();
        for (int i = 0; i < botoes.length; i++) {
            if (botoes[i].contains(m.x, m.y)) {
                if (moveu || clique) selecionado = i;
                if (clique) return acaoDe(i);
            }
        }
        if (Teclado.confirmar()) return acaoDe(selecionado);
        return Acao.NENHUMA;
    }

    private Acao acaoDe(int i) {
        return i == 0 ? Acao.CONTINUAR : Acao.MENU;
    }

    public void desenhar(Gfx g) {
        g.rect(0, 0, Gfx.LARGURA, Gfx.ALTURA, Cores.PRETO, 0.65f);
        g.rect(140f, 96f, 360f, 160f, Cores.CINZA_ESCURO);
        g.borda(140f, 96f, 360f, 160f, 3f, Cores.CINZA_CLARO);
        g.textoCentro("PAUSA", 320f, 244f, 2f, Cores.OURO);
        for (int i = 0; i < botoes.length; i++) {
            Rectangle b = botoes[i];
            boolean sel = i == selecionado;
            g.rect(b.x, b.y, b.width, b.height, sel ? Cores.AZUL : Cores.PRETO, sel ? 0.9f : 0.5f);
            g.borda(b.x, b.y, b.width, b.height, 2f, sel ? Cores.OURO : Cores.CINZA);
            g.textoCentro(ITENS[i], b.x + b.width / 2f, b.y + 26f, 1.1f, Cores.BRANCO);
        }
        g.textoCentro("W/S: navegar   ENTER: confirmar   ESC: fechar", 320f, 110f, 0.7f, Cores.CINZA_CLARO);
    }
}