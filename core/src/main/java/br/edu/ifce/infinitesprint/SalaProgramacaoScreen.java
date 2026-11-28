package br.edu.ifce.infinitesprint;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class SalaProgramacaoScreen extends SalaBaseScreen {
    private enum Fase { EXPLORANDO, DIALOGO, FIM }

    private static final Color[] CAMISAS = {Cores.VERMELHO, Cores.VERDE, Cores.AMARELO, Cores.ROXO};
    private static final Color[] CABELOS = {Cores.CABELO_ESCURO, Cores.CABELO_CASTANHO, Cores.CABELO_LOIRO};

    private final Rectangle zonaComputador = new Rectangle(420f, 150f, 160f, 46f);

    private Fase fase = Fase.EXPLORANDO;
    private DialogoBox dialogo;

    public SalaProgramacaoScreen(Main jogo) {
        super(jogo, 580f, 40f);
        montarObjetos();
    }

    private void montarObjetos() {
        float[] colX = {40f, 150f, 260f};
        float[] linhaY = {32f, 102f, 172f};
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                final float ux = colX[c];
                final float uy = linhaY[r];
                final boolean ocupada = ((r + c) & 1) == 0;
                final int idx = r * 3 + c;
                solidos.add(new Rectangle(ux, uy + 18f, 70f, 22f));
                solidos.add(new Rectangle(ux + 25f, uy, 20f, 16f));
                objetos.add(new ObjetoCena(uy, () -> {
                    Mobiliario.mesa(gfx, ux, uy + 18f, 70f);
                    Mobiliario.computador(gfx, ux + 21f, uy + 26f, tempoSala, false);
                    Mobiliario.cadeira(gfx, ux + 25f, uy, false);
                    if (ocupada) {
                        Sprites.alunoDeCostas(gfx, ux + 35f, uy + 4f, CAMISAS[idx % CAMISAS.length],
                                CABELOS[idx % CABELOS.length]);
                    }
                }));
            }
        }
        // professor (outro professor: tipo 1) e a mesa com o computador "problematico"
        solidos.add(new Rectangle(420f, 196f, 160f, 26f));
        solidos.add(new Rectangle(388f, 198f, 20f, 8f));
        objetos.add(new ObjetoCena(200f, () -> Sprites.professorFrente(gfx, 398f, 200f, 1)));
        objetos.add(new ObjetoCena(196f, () -> {
            Mobiliario.mesa(gfx, 420f, 196f, 160f);
            Mobiliario.computador(gfx, 480f, 212f, tempoSala, true);
            gfx.rect(478f, 203f, 32f, 5f, Cores.CINZA);
        }));
    }

    @Override
    protected void atualizar(float dt) {
        tempoSala += dt;
        switch (fase) {
            case EXPLORANDO:
                moverJogador(dt, !emTransicao());
                if (zonaComputador.contains(jogador.getX(), jogador.getY()) && Teclado.confirmar()) {
                    jogador.setDirecao(Jogador.Direcao.CIMA);
                    dialogo = new DialogoBox(RoteiroProgramacao.criar());
                    fase = Fase.DIALOGO;
                }
                break;
            case DIALOGO:
                dialogo.atualizar(dt);
                if (dialogo.isFinalizado()) {
                    fase = Fase.FIM;
                }
                break;
            case FIM:
                if (!emTransicao()) {
                    transicao(() -> jogo.irPara(new CorridaScreen(jogo, 1)));
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void desenhar() {
        desenharPiso(Cores.PISO_PROG_A, Cores.PISO_PROG_B);
        desenharParede(Cores.PAREDE_SALA_ESCURA, Cores.CINZA_ESCURO);

        // quadro com codigo
        gfx.rect(150f, 270f, 340f, 80f, Cores.MADEIRA_ESCURA);
        gfx.rect(156f, 276f, 328f, 68f, Cores.TELA_ESCURA);
        gfx.texto("while (true) {", 168f, 336f, 1f, Cores.VERDE);
        gfx.texto("    correr();", 168f, 316f, 1f, Cores.BRANCO);
        gfx.texto("    if (professor) fugir();", 168f, 296f, 1f, Cores.AMARELO);
        gfx.texto("}", 168f, 282f, 1f, Cores.VERDE);
        // cartaz
        gfx.rect(40f, 280f, 70f, 56f, Cores.BRANCO);
        gfx.rect(46f, 286f, 58f, 30f, Cores.AZUL);
        gfx.texto("01010", 50f, 330f, 0.8f, Cores.PRETO);
        gfx.rect(626f, 20f, 14f, 60f, Cores.MADEIRA_ESCURA);
        gfx.rect(628f, 50f, 3f, 3f, Cores.OURO);

        desenharObjetosEJogador();

        if (fase == Fase.EXPLORANDO) {
            float b = MathUtils.sin(tempoSala * 5f) * 3f;
            gfx.rect(490f, 242f + b, 8f, 3f, Cores.OURO);
            gfx.rect(492f, 239f + b, 4f, 3f, Cores.OURO);
            gfx.rect(493f, 237f + b, 2f, 2f, Cores.OURO);
            gfx.texto("Ajude o professor com o computador!   W A S D: andar", 8f, 24f, 0.85f, Cores.BRANCO);
            if (zonaComputador.contains(jogador.getX(), jogador.getY())) {
                desenharAviso("PRESSIONE ENTER PARA USAR O COMPUTADOR");
            }
        } else if (fase == Fase.DIALOGO) {
            dialogo.desenhar(gfx, 1, tempoSala);
        }
    }
}