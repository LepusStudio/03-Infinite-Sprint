package br.edu.ifce.infinitesprint;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public abstract class BaseScreen implements Screen {
    protected final Main jogo;
    protected final Gfx gfx;

    private final PauseMenu pausa = new PauseMenu();
    private float fade = 1f;
    private Runnable acaoSaida;

    protected BaseScreen(Main jogo) {
        this.jogo = jogo;
        this.gfx = jogo.gfx;
    }

    protected boolean pausavel() {
        return true;
    }

    protected abstract void atualizar(float dt);

    protected abstract void desenhar();

    protected void transicao(Runnable acao) {
        if (acaoSaida == null) {
            acaoSaida = acao;
        }
    }

    protected boolean emTransicao() {
        return acaoSaida != null;
    }

    @Override
    public void render(float delta) {
        float dt = Math.min(delta, 0.05f);

        if (pausavel() && acaoSaida == null && Teclado.pausa()) {
            pausa.alternar();
        }
        boolean pausado = pausa.isAberto();

        if (pausado) {
            PauseMenu.Acao acao = pausa.atualizar(gfx);
            if (acao == PauseMenu.Acao.CONTINUAR) {
                pausa.fechar();
            } else if (acao == PauseMenu.Acao.MENU) {
                pausa.fechar();
                jogo.irParaMenu();
                return;
            }
        } else {
            atualizar(dt);
            if (acaoSaida != null) {
                fade = Math.min(1f, fade + dt * 2.5f);
                if (fade >= 1f) {
                    Runnable r = acaoSaida;
                    acaoSaida = null;
                    r.run();
                    return;
                }
            } else if (fade > 0f) {
                fade = Math.max(0f, fade - dt * 2.5f);
            }
        }

        ScreenUtils.clear(0f, 0f, 0f, 1f);
        gfx.iniciarQuadro();
        desenhar();
        if (pausado) {
            pausa.desenhar(gfx);
        }
        if (fade > 0f) {
            gfx.rect(0f, 0f, Gfx.LARGURA, Gfx.ALTURA, Cores.PRETO, fade);
        }
        gfx.batch.end();
    }

    @Override
    public void resize(int largura, int altura) {
        gfx.redimensionar(largura, altura);
    }

    @Override public void show() { }
    @Override public void pause() { }
    @Override public void resume() { }
    @Override public void hide() { }

    @Override
    public void dispose() {
        // Gfx
    }
}