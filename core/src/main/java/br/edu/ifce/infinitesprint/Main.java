package br.edu.ifce.infinitesprint;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

/** Ponto de entrada do jogo (core). Gerencia as telas e os dados compartilhados da partida. */
public class Main extends Game {
    public Gfx gfx;
    public final SistemaMoedas moedas = new SistemaMoedas();
    public final GerenciadorPerguntas perguntas = new GerenciadorPerguntas();

    @Override
    public void create() {
        gfx = new Gfx();
        irParaMenu();
    }

    /** Troca de tela liberando a anterior. */
    public void irPara(Screen nova) {
        Screen anterior = getScreen();
        setScreen(nova);
        if (anterior != null) {
            anterior.dispose();
        }
    }

    public void irParaMenu() {
        moedas.zerar();
        irPara(new MenuPrincipalScreen(this));
    }

    @Override
    public void dispose() {
        Screen atual = getScreen();
        super.dispose();
        if (atual != null) {
            atual.dispose();
        }
        if (gfx != null) {
            gfx.dispose();
        }
    }
}