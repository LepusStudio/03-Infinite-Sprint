package br.edu.ifce.infinitesprint;

import com.badlogic.gdx.graphics.Color;

public final class Cores {
    private Cores() {}

    private static Color c(String hex) {
        return Color.valueOf(hex);
    }

    public static final Color PRETO = c("0b0b14");
    public static final Color BRANCO = c("f5f5f0");
    public static final Color CINZA_ESCURO = c("3a3f4b");
    public static final Color CINZA = c("7a8090");
    public static final Color CINZA_CLARO = c("c5cad3");

    public static final Color PELE = c("f1c27d");
    public static final Color PELE_BRAVO = c("e8705a");
    public static final Color PELE_SOMBRA = c("d49a5a");
    public static final Color VERMELHO_ESCURO = c("8a1f1f");
    public static final Color CABELO_ESCURO = c("2b1d14");
    public static final Color CABELO_CASTANHO = c("6a4326");
    public static final Color CABELO_GRISALHO = c("b9b9c4");
    public static final Color CABELO_LOIRO = c("e3c15a");

    public static final Color AZUL = c("3b6fd4");
    public static final Color VERMELHO = c("d4503b");
    public static final Color VERDE = c("3fa66b");
    public static final Color AMARELO = c("e8c33a");
    public static final Color ROXO = c("8a5bd0");
    public static final Color ROXO_ESCURO = c("3d2a5c");
    public static final Color CALCA = c("2f3a5a");
    public static final Color CALCA_MARROM = c("6b4a2e");
    public static final Color MOCHILA = c("c0392b");

    public static final Color MADEIRA_CLARA = c("d9ae6e");
    public static final Color MADEIRA = c("b9884a");
    public static final Color MADEIRA_ESCURA = c("7a5230");
    public static final Color QUADRO_VERDE = c("2e5d4b");
    public static final Color CORTICA = c("e0b97a");

    public static final Color OURO = c("f4c20d");
    public static final Color OURO_CLARO = c("fff08a");
    public static final Color OURO_ESCURO = c("b8860b");

    // Salas (visao top-down)
    public static final Color PAREDE_SALA = c("6f8fa8");
    public static final Color PAREDE_SALA_ESCURA = c("4f6b82");
    public static final Color PISO_FISICA_A = c("c9a46a");
    public static final Color PISO_FISICA_B = c("bb965c");
    public static final Color PISO_PROG_A = c("5a6b86");
    public static final Color PISO_PROG_B = c("506079");
    public static final Color CADEIRA = c("c24a3a");
    public static final Color CADEIRA_ESCURA = c("8e3226");
    public static final Color TELA_AZUL = c("2a6fdb");
    public static final Color TELA_ESCURA = c("10223f");

    // Corredor
    public static final Color PAREDE_CORREDOR = c("e8dcb0");
    public static final Color PAREDE_ESCURA = c("c9bb8a");
    public static final Color PISO_CLARO = c("d4cfc0");
    public static final Color PISO_ESCURO = c("b9b3a2");
    public static final Color ARMARIO_AZUL = c("3d6fb0");
    public static final Color ARMARIO_ESCURO = c("2a4f86");
    public static final Color TETO = c("8a8f9c");
    public static final Color VIDRO = c("8fd3ff");

    // Floresta
    public static final Color CEU_ALTO = c("5fb3f0");
    public static final Color CEU_BAIXO = c("cdeeff");
    public static final Color SOL = c("ffe27a");
    public static final Color COLINA = c("6fae8a");
    public static final Color FOLHA_ESCURA = c("1f5c2e");
    public static final Color FOLHA = c("2f8f46");
    public static final Color FOLHA_CLARA = c("5cbf5f");
    public static final Color TRONCO = c("6b4423");
    public static final Color TRONCO_ESCURO = c("4a2e17");
    public static final Color TRONCO_CLARO = c("a0723d");
    public static final Color PEDRA = c("8c8f94");
    public static final Color PEDRA_ESCURA = c("62656b");
    public static final Color GRAMA = c("4caf50");
    public static final Color GRAMA_CLARA = c("7ed36f");
    public static final Color GRAMA_ESCURA = c("357a38");
    public static final Color TERRA = c("8a6038");
    public static final Color TERRA_ESCURA = c("6e4a2a");
}