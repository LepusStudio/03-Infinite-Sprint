package br.edu.ifce.infinitesprint;

import java.util.ArrayList;
import java.util.List;

public final class RoteiroProgramacao {
    private RoteiroProgramacao() {}

    public static List<LinhaDialogo> criar() {
        List<LinhaDialogo> l = new ArrayList<>();
        l.add(LinhaDialogo.professor("Ah, que bom que você chegou! Meu computador travou e eu só queria projetar a aula.",
                Sprites.Humor.NEUTRO));
        l.add(LinhaDialogo.aluno("Posso dar uma olhada, professor?"));
        l.add(LinhaDialogo.computador("ERRO 404: café não encontrado. Reinicie o professor."));
        l.add(LinhaDialogo.professor("Como assim, \"reinicie o professor\"?!", Sprites.Humor.NEUTRO));
        l.add(LinhaDialogo.aluno("Hum... professor, a pasta \"Provas_Finais\" foi parar na lixeira."));
        l.add(LinhaDialogo.professor("O QUÊ?! VOLTA AQUI, ALUNO!!!", Sprites.Humor.BRAVO));
        l.add(LinhaDialogo.narrador("O professor está furioso. CORRA!"));
        return l;
    }
}