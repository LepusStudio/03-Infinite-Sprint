package br.edu.ifce.infinitesprint;

public class LinhaDialogo {
    public final String quem;
    public final String texto;
    public final boolean professor;
    public final Sprites.Humor humor;

    private LinhaDialogo(String quem, String texto, boolean professor, Sprites.Humor humor) {
        this.quem = quem;
        this.texto = texto;
        this.professor = professor;
        this.humor = humor;
    }

    public static LinhaDialogo professor(String texto, Sprites.Humor humor) {
        return new LinhaDialogo("PROFESSOR", texto, true, humor);
    }

    public static LinhaDialogo aluno(String texto) {
        return new LinhaDialogo("VOCÊ", texto, false, Sprites.Humor.NEUTRO);
    }

    public static LinhaDialogo computador(String texto) {
        return new LinhaDialogo("COMPUTADOR", texto, false, Sprites.Humor.NEUTRO);
    }

    public static LinhaDialogo narrador(String texto) {
        return new LinhaDialogo("NARRADOR", texto, false, Sprites.Humor.NEUTRO);
    }
}