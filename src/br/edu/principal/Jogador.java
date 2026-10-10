package br.edu.principal;

public class Jogador {
	
	String nome;
    double velocidade;
    double posicao;
    double aceleracao;

    void correr() {
        posicao += velocidade;
        velocidade += aceleracao;

        System.out.println(nome + " está correndo!");
        System.out.println("Velocidade: " + velocidade);
        System.out.println("Posição: " + posicao);
    }
    
}