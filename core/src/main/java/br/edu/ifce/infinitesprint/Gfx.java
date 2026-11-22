package br.edu.ifce.infinitesprint;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.text.Normalizer;

public class Gfx implements Disposable {
    public static final float LARGURA = 640f;
    public static final float ALTURA = 360f;

    public final OrthographicCamera camera = new OrthographicCamera();
    public final FitViewport viewport = new FitViewport(LARGURA, ALTURA, camera);
    public final SpriteBatch batch = new SpriteBatch();
    public final BitmapFont fonte = new BitmapFont();

    private final Texture pixel;
    private final GlyphLayout layout = new GlyphLayout();
    private final Vector2 mouse = new Vector2();
    private final boolean fonteTemAcentos;

    public Gfx() {
        Pixmap pm = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pm.setColor(Color.WHITE);
        pm.fill();
        pixel = new Texture(pm);
        pm.dispose();
        fonte.getRegion().getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        fonteTemAcentos = fonte.getData().hasGlyph('\u00c3') && fonte.getData().hasGlyph('\u00ea')
                && fonte.getData().hasGlyph('\u00e7');
    }

    public void redimensionar(int largura, int altura) {
        viewport.update(largura, altura, true);
    }

    public void iniciarQuadro() {
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
    }

    public Vector2 mouse() {
        return viewport.unproject(mouse.set(Gdx.input.getX(), Gdx.input.getY()));
    }

    public void rect(float x, float y, float w, float h, Color c) {
        batch.setColor(c);
        batch.draw(pixel, x, y, w, h);
        batch.setColor(Color.WHITE);
    }

    public void rect(float x, float y, float w, float h, Color c, float alfa) {
        batch.setColor(c.r, c.g, c.b, alfa);
        batch.draw(pixel, x, y, w, h);
        batch.setColor(Color.WHITE);
    }

    public void borda(float x, float y, float w, float h, float e, Color c) {
        rect(x, y, w, e, c);
        rect(x, y + h - e, w, e, c);
        rect(x, y, e, h, c);
        rect(x + w - e, y, e, h, c);
    }

    private String ajustar(String s) {
        if (fonteTemAcentos) {
            return s;
        }
        return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    }

    private void preparar(String texto, float escala, float largura, boolean quebrar) {
        String s = ajustar(texto);
        fonte.getData().setScale(escala);
        if (quebrar) {
            layout.setText(fonte, s, Color.WHITE, largura, Align.left, true);
        } else {
            layout.setText(fonte, s);
        }
    }

    private void desenharLayout(float x, float y, Color c) {
        fonte.setColor(0f, 0f, 0f, 0.6f);
        fonte.draw(batch, layout, x + 1f, y - 1f);
        fonte.setColor(c);
        fonte.draw(batch, layout, x, y);
    }

    public void texto(String s, float x, float y, float escala, Color c) {
        preparar(s, escala, 0f, false);
        desenharLayout(x, y, c);
    }

    public void textoCentro(String s, float cx, float y, float escala, Color c) {
        preparar(s, escala, 0f, false);
        desenharLayout(cx - layout.width / 2f, y, c);
    }

    public void textoQuebrado(String s, float x, float y, float largura, float escala, Color c) {
        preparar(s, escala, largura, true);
        desenharLayout(x, y, c);
    }

    public float larguraTexto(String s, float escala) {
        preparar(s, escala, 0f, false);
        return layout.width;
    }

    @Override
    public void dispose() {
        batch.dispose();
        fonte.dispose();
        pixel.dispose();
    }
}