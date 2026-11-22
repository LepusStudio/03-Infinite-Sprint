package br.edu.ifce.infinitesprint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public final class Teclado {
    private Teclado() {}

    public static boolean cima() { return Gdx.input.isKeyJustPressed(Keys.W); }
    public static boolean baixo() { return Gdx.input.isKeyJustPressed(Keys.S); }
    public static boolean esquerda() { return Gdx.input.isKeyJustPressed(Keys.A); }
    public static boolean direita() { return Gdx.input.isKeyJustPressed(Keys.D); }
    public static boolean confirmar() {
        return Gdx.input.isKeyJustPressed(Keys.ENTER) || Gdx.input.isKeyJustPressed(Keys.NUMPAD_ENTER);
    }
    public static boolean pausa() { return Gdx.input.isKeyJustPressed(Keys.ESCAPE); }

    public static boolean cimaPressionada() { return Gdx.input.isKeyPressed(Keys.W); }
    public static boolean baixoPressionada() { return Gdx.input.isKeyPressed(Keys.S); }
    public static boolean esquerdaPressionada() { return Gdx.input.isKeyPressed(Keys.A); }
    public static boolean direitaPressionada() { return Gdx.input.isKeyPressed(Keys.D); }
}