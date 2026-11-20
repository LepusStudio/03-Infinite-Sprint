package br.edu.ifce.infinitesprint;

/** Contrato de um cenario de corrida lateral: fundo com parallax e desenho dos obstaculos. */
public interface Cenario {
    /** distancia = quanto o jogador ja percorreu (define o deslocamento das camadas). */
    void desenharFundo(Gfx g, float distancia);

    /** sx = posicao x do obstaculo na tela. */
    void desenharObstaculo(Gfx g, Obstaculo o, float sx);
}
