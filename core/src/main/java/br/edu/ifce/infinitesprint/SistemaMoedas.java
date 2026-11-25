package br.edu.ifce.infinitesprint;

public class SistemaMoedas {
    private int total;

    public void adicionar(int quantidade) {
        if (quantidade > 0) {
            total += quantidade;
        }
    }

    public boolean gastar(int quantidade) {
        if (quantidade < 0 || quantidade > total) {
            return false;
        }
        total -= quantidade;
        return true;
    }

    public int getTotal() {
        return total;
    }

    public void zerar() {
        total = 0;
    }
}