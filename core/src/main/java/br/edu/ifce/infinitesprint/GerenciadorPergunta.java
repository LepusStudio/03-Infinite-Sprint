package br.edu.ifce.infinitesprint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GerenciadorPergunta {
    private final List<Pergunta> banco = new ArrayList<>();
    private final List<Pergunta> fila = new ArrayList<>();
    private final Random rng = new Random();

    public GerenciadorPergunta() {
        carregarPadrao();
    }

    public void adicionar(Pergunta pergunta) {
        banco.add(pergunta);
    }

    public Pergunta sortear() {
        if (banco.isEmpty()) {
            throw new IllegalStateException("Não há perguntas cadastradas.");
        }
        if (fila.isEmpty()) {
            fila.addAll(banco);
            Collections.shuffle(fila, rng);
        }
        return fila.remove(fila.size() - 1);
    }

    private void p(String enunciado, int correta, String... alternativas) {
        banco.add(new Pergunta(enunciado, alternativas, correta));
    }

    private void carregarPadrao() {
        p("Quanto é 7 x 8?", 1, "54", "56", "58", "64", "48");
        p("Qual é a unidade de força no Sistema Internacional?", 2,
                "Joule", "Watt", "Newton", "Pascal", "Volt");
        p("Qual é a raiz quadrada de 144?", 2, "10", "11", "12", "14", "16");
        p("A velocidade da luz no vácuo é de aproximadamente:", 2,
                "300 km/s", "3.000 km/s", "300.000 km/s", "30.000 km/s", "3.000.000 km/s");
        p("Um carro percorre 120 km em 2 h. Qual a velocidade média?", 2,
                "40 km/h", "50 km/h", "60 km/h", "80 km/h", "120 km/h");
        p("Qual o valor de x em 2x + 6 = 20?", 2, "5", "6", "7", "8", "10");
        p("A Segunda Lei de Newton é expressa por:", 2,
                "F = m / a", "F = m + a", "F = m . a", "F = a / m", "F = m . v");
        p("A área de um círculo de raio 2 (use π = 3) vale:", 2, "6", "8", "12", "16", "24");
    }
}