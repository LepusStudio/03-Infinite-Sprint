package br.edu.ifce.infinitesprint;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

public final class Sprites {
    public enum Pose { PARADO, CORRENDO, PULANDO, AGACHADO, TROPECO, COMEMORANDO }

    public enum Humor { NEUTRO, BRAVO, FELIZ }

    private Sprites() {}

    private static void r(Gfx g, float x, float y, float w, float h, Color c) {
        g.rect(x, y, w, h, c);
    }

    private static void q(Gfx g, float cx, float cy, float u, float lx, float ly, float w, float h, Color c) {
        g.rect(cx + lx * u, cy + ly * u, w * u, h * u, c);
    }

    /** x = centro, y = pe do personagem. */
    public static void alunoLateral(Gfx g, float x, float y, Pose pose, float t) {
        int f = ((int) (t * 10f)) % 2;
        g.rect(x - 9, y - 1, 18, 2, Cores.PRETO, 0.25f);
        switch (pose) {
            case AGACHADO:
                r(g, x - 8, y, 8, 6, Cores.CALCA);
                r(g, x + 1, y, 8, 5, Cores.CALCA);
                r(g, x - 9, y, 7, 2, Cores.BRANCO);
                r(g, x + 2, y, 7, 2, Cores.BRANCO);
                r(g, x - 12, y + 7, 5, 8, Cores.MOCHILA);
                r(g, x - 7, y + 6, 14, 8, Cores.AZUL);
                r(g, x - 1, y + 11, 10, 9, Cores.PELE);
                r(g, x - 2, y + 16, 11, 4, Cores.CABELO_ESCURO);
                r(g, x + 5, y + 14, 2, 2, Cores.PRETO);
                break;
            case PULANDO:
                r(g, x - 7, y + 5, 6, 9, Cores.CALCA);
                r(g, x + 1, y + 7, 7, 7, Cores.CALCA);
                r(g, x - 7, y + 5, 7, 3, Cores.BRANCO);
                r(g, x + 1, y + 7, 8, 3, Cores.BRANCO);
                corpoEmPe(g, x, y + 14, true, false);
                break;
            case TROPECO:
                r(g, x - 12, y, 5, 5, Cores.CALCA);
                r(g, x - 6, y, 5, 4, Cores.CALCA);
                r(g, x - 13, y + 6, 6, 10, Cores.MOCHILA);
                r(g, x - 8, y + 4, 16, 10, Cores.AZUL);
                r(g, x + 5, y + 8, 10, 10, Cores.PELE);
                r(g, x + 4, y + 14, 11, 4, Cores.CABELO_ESCURO);
                r(g, x + 11, y + 12, 2, 2, Cores.PRETO);
                if (f == 0) {
                    r(g, x + 2, y + 22, 3, 3, Cores.OURO);
                } else {
                    r(g, x + 9, y + 24, 3, 3, Cores.OURO);
                }
                break;
            case COMEMORANDO: {
                float salto = Math.abs(MathUtils.sin(t * 7f)) * 10f;
                pernasParadas(g, x, y + salto);
                corpoEmPe(g, x, y + salto + 14, true, true);
                break;
            }
            case CORRENDO:
                pernasCorrida(g, x, y, f);
                corpoEmPe(g, x, y + 14, false, false);
                break;
            case PARADO:
            default:
                pernasParadas(g, x, y);
                corpoEmPe(g, x, y + 14, false, false);
                break;
        }
    }

    private static void pernasParadas(Gfx g, float x, float y) {
        r(g, x - 5, y, 4, 14, Cores.CALCA);
        r(g, x + 1, y, 4, 14, Cores.CALCA);
        r(g, x - 5, y, 6, 3, Cores.BRANCO);
        r(g, x + 1, y, 6, 3, Cores.BRANCO);
    }

    private static void pernasCorrida(Gfx g, float x, float y, int f) {
        float xa = f == 0 ? -8 : -3;
        float xb = f == 0 ? 3 : -1;
        float ya = f == 0 ? 0 : 3;
        float yb = f == 0 ? 3 : 0;
        r(g, x + xa, y + ya, 4, 14 - ya, Cores.CALCA);
        r(g, x + xa, y + ya, 6, 3, Cores.BRANCO);
        r(g, x + xb, y + yb, 4, 14 - yb, Cores.CALCA);
        r(g, x + xb, y + yb, 6, 3, Cores.BRANCO);
    }

    private static void corpoEmPe(Gfx g, float x, float b, boolean bracosCima, boolean sorrindo) {
        r(g, x - 10, b + 2, 5, 11, Cores.MOCHILA);
        r(g, x - 6, b, 12, 14, Cores.AZUL);
        r(g, x - 5, b + 14, 10, 10, Cores.PELE);
        r(g, x - 6, b + 20, 11, 5, Cores.CABELO_ESCURO);
        r(g, x - 6, b + 15, 3, 6, Cores.CABELO_ESCURO);
        r(g, x + 2, b + 18, 2, 2, Cores.PRETO);
        if (sorrindo) {
            r(g, x + 1, b + 15, 4, 1, Cores.PRETO);
        }
        if (bracosCima) {
            r(g, x + 6, b + 10, 3, 12, Cores.PELE);
            r(g, x - 9, b + 10, 3, 12, Cores.PELE);
        } else {
            r(g, x + 3, b + 4, 3, 8, Cores.PELE);
        }
    }

    public static void alunoTopDown(Gfx g, float x, float y, Jogador.Direcao dir, boolean andando, float t) {
        int f = andando ? ((int) (t * 8f)) % 2 : 0;
        g.rect(x - 7, y - 1, 14, 3, Cores.PRETO, 0.25f);
        float la = f == 0 ? 0 : 2;
        float lb = f == 0 ? 2 : 0;
        r(g, x - 5, y + la, 4, 6 - la, Cores.CALCA);
        r(g, x + 1, y + lb, 4, 6 - lb, Cores.CALCA);
        r(g, x - 5, y + la, 4, 2, Cores.BRANCO);
        r(g, x + 1, y + lb, 4, 2, Cores.BRANCO);
        r(g, x - 6, y + 6, 12, 10, Cores.AZUL);
        r(g, x - 8, y + 7, 2, 7, Cores.PELE);
        r(g, x + 6, y + 7, 2, 7, Cores.PELE);
        r(g, x - 5, y + 16, 10, 9, Cores.PELE);
        switch (dir) {
            case CIMA:
                r(g, x - 5, y + 16, 10, 9, Cores.CABELO_ESCURO);
                r(g, x - 5, y + 7, 10, 8, Cores.MOCHILA);
                break;
            case ESQUERDA:
                r(g, x - 5, y + 21, 10, 4, Cores.CABELO_ESCURO);
                r(g, x + 1, y + 16, 4, 6, Cores.CABELO_ESCURO);
                r(g, x - 4, y + 19, 2, 2, Cores.PRETO);
                r(g, x + 4, y + 8, 4, 8, Cores.MOCHILA);
                break;
            case DIREITA:
                r(g, x - 5, y + 21, 10, 4, Cores.CABELO_ESCURO);
                r(g, x - 5, y + 16, 4, 6, Cores.CABELO_ESCURO);
                r(g, x + 2, y + 19, 2, 2, Cores.PRETO);
                r(g, x - 8, y + 8, 4, 8, Cores.MOCHILA);
                break;
            case BAIXO:
            default:
                r(g, x - 5, y + 21, 10, 4, Cores.CABELO_ESCURO);
                r(g, x - 3, y + 19, 2, 2, Cores.PRETO);
                r(g, x + 1, y + 19, 2, 2, Cores.PRETO);
                break;
        }
    }

    public static void alunoDeCostas(Gfx g, float x, float y, Color camisa, Color cabelo) {
        r(g, x - 8, y, 16, 10, camisa);
        r(g, x - 2, y + 9, 4, 2, Cores.PELE);
        r(g, x - 5, y + 10, 10, 10, cabelo);
        r(g, x - 6, y + 12, 1, 3, Cores.PELE);
        r(g, x + 5, y + 12, 1, 3, Cores.PELE);
    }

    public static void professorFrente(Gfx g, float x, float y, int tipo) {
        Color camisa = tipo == 0 ? Cores.BRANCO : Cores.ROXO_ESCURO;
        Color calca = tipo == 0 ? Cores.CALCA_MARROM : Cores.PRETO;
        Color cabelo = tipo == 0 ? Cores.CABELO_GRISALHO : Cores.CABELO_ESCURO;
        g.rect(x - 8, y - 1, 16, 3, Cores.PRETO, 0.25f);
        r(g, x - 6, y, 5, 10, calca);
        r(g, x + 1, y, 5, 10, calca);
        r(g, x - 8, y + 10, 16, 16, camisa);
        r(g, x - 11, y + 12, 3, 10, camisa);
        r(g, x + 8, y + 12, 3, 10, camisa);
        r(g, x - 11, y + 10, 3, 3, Cores.PELE);
        r(g, x + 8, y + 10, 3, 3, Cores.PELE);
        if (tipo == 0) {
            r(g, x - 1, y + 14, 2, 11, Cores.VERMELHO);
        }
        r(g, x - 6, y + 26, 12, 11, Cores.PELE);
        r(g, x - 7, y + 33, 14, 5, cabelo);
        if (tipo == 1) {
            r(g, x - 6, y + 26, 12, 4, cabelo);
            g.borda(x - 6, y + 30, 6, 4, 1, Cores.PRETO);
            g.borda(x, y + 30, 6, 4, 1, Cores.PRETO);
        } else {
            r(g, x - 4, y + 30, 2, 2, Cores.PRETO);
            r(g, x + 2, y + 30, 2, 2, Cores.PRETO);
            r(g, x - 3, y + 28, 6, 1, cabelo);
        }
    }

    public static void professorLateral(Gfx g, float x, float y, int tipo, float t) {
        int f = ((int) (t * 9f)) % 2;
        Color camisa = tipo == 0 ? Cores.BRANCO : Cores.ROXO_ESCURO;
        Color calca = tipo == 0 ? Cores.CALCA_MARROM : Cores.PRETO;
        Color cabelo = tipo == 0 ? Cores.CABELO_GRISALHO : Cores.CABELO_ESCURO;
        g.rect(x - 10, y - 1, 20, 2, Cores.PRETO, 0.25f);
        float xa = f == 0 ? -8 : -3;
        float xb = f == 0 ? 3 : -1;
        float ya = f == 0 ? 0 : 3;
        float yb = f == 0 ? 3 : 0;
        r(g, x + xa, y + ya, 5, 17 - ya, calca);
        r(g, x + xb, y + yb, 5, 17 - yb, calca);
        r(g, x - 7, y + 17, 14, 16, camisa);
        if (tipo == 0) {
            r(g, x + 3, y + 19, 2, 10, Cores.VERMELHO);
        }
        r(g, x + 5, y + 23, 13, 4, Cores.PELE_BRAVO);
        r(g, x - 6, y + 33, 12, 12, Cores.PELE_BRAVO);
        r(g, x - 7, y + 41, 13, 5, cabelo);
        r(g, x + 1, y + 38, 6, 3, Cores.PRETO);
        r(g, x + 3, y + 39, 2, 1, Cores.BRANCO);
        if (tipo == 1) {
            r(g, x, y + 33, 7, 4, cabelo);
        }
        r(g, x - 3, y + 47 + f * 2, 2, 3, Cores.BRANCO);
        r(g, x + 2, y + 48 - f * 2, 2, 3, Cores.BRANCO);
    }

    public static void cabecaProfessor(Gfx g, float cx, float cy, float u, int tipo, Humor humor, float t) {
        if (humor == Humor.BRAVO) {
            cx += MathUtils.sin(t * 45f) * u * 0.3f;
        }
        Color pele = humor == Humor.BRAVO ? Cores.PELE_BRAVO : Cores.PELE;
        Color cabelo = tipo == 0 ? Cores.CABELO_GRISALHO : Cores.CABELO_ESCURO;
        q(g, cx, cy, u, -4, -14, 8, 4, pele);
        q(g, cx, cy, u, -9, -16, 18, 3, tipo == 0 ? Cores.BRANCO : Cores.ROXO_ESCURO);
        q(g, cx, cy, u, -9, -10, 18, 20, pele);
        q(g, cx, cy, u, -10, -2, 1, 5, pele);
        q(g, cx, cy, u, 9, -2, 1, 5, pele);
        q(g, cx, cy, u, -10, 6, 20, 5, cabelo);
        q(g, cx, cy, u, -10, 1, 2, 6, cabelo);
        q(g, cx, cy, u, 8, 1, 2, 6, cabelo);
        if (tipo == 1) {
            q(g, cx, cy, u, -9, -10, 18, 4, cabelo);
            q(g, cx, cy, u, -9, -6, 2, 5, cabelo);
            q(g, cx, cy, u, 7, -6, 2, 5, cabelo);
        } else {
            q(g, cx, cy, u, -4, -3, 8, 2, cabelo);
        }
        q(g, cx, cy, u, -1, -2, 3, 3, Cores.PELE_SOMBRA);
        q(g, cx, cy, u, -6, 1, 4, 3, Cores.BRANCO);
        q(g, cx, cy, u, 2, 1, 4, 3, Cores.BRANCO);
        q(g, cx, cy, u, -5, 1, 2, 2, Cores.PRETO);
        q(g, cx, cy, u, 3, 1, 2, 2, Cores.PRETO);
        if (tipo == 1) {
            g.borda(cx - 7 * u, cy, 6 * u, 5 * u, u * 0.8f, Cores.PRETO);
            g.borda(cx + 1 * u, cy, 6 * u, 5 * u, u * 0.8f, Cores.PRETO);
            q(g, cx, cy, u, -1, 3, 2, 1, Cores.PRETO);
        }
        switch (humor) {
            case BRAVO:
                q(g, cx, cy, u, -7, 5, 3, 1, Cores.CABELO_ESCURO);
                q(g, cx, cy, u, -4, 4, 3, 1, Cores.CABELO_ESCURO);
                q(g, cx, cy, u, 4, 5, 3, 1, Cores.CABELO_ESCURO);
                q(g, cx, cy, u, 1, 4, 3, 1, Cores.CABELO_ESCURO);
                q(g, cx, cy, u, -3, -7, 6, 1, Cores.VERMELHO_ESCURO);
                q(g, cx, cy, u, -4, -8, 1, 1, Cores.VERMELHO_ESCURO);
                q(g, cx, cy, u, 3, -8, 1, 1, Cores.VERMELHO_ESCURO);
                q(g, cx, cy, u, 5, 7, 3, 1, Cores.VERMELHO);
                q(g, cx, cy, u, 6, 6, 1, 3, Cores.VERMELHO);
                break;
            case FELIZ:
                q(g, cx, cy, u, -7, 6, 5, 1, Cores.CABELO_ESCURO);
                q(g, cx, cy, u, 2, 6, 5, 1, Cores.CABELO_ESCURO);
                q(g, cx, cy, u, -3, -7, 6, 1, Cores.VERMELHO_ESCURO);
                q(g, cx, cy, u, -4, -6, 1, 1, Cores.VERMELHO_ESCURO);
                q(g, cx, cy, u, 3, -6, 1, 1, Cores.VERMELHO_ESCURO);
                q(g, cx, cy, u, -2, -6, 4, 1, Cores.BRANCO);
                break;
            case NEUTRO:
            default:
                q(g, cx, cy, u, -7, 5, 5, 1, Cores.CABELO_ESCURO);
                q(g, cx, cy, u, 2, 5, 5, 1, Cores.CABELO_ESCURO);
                q(g, cx, cy, u, -3, -7, 6, 1, Cores.VERMELHO_ESCURO);
                break;
        }
    }
}