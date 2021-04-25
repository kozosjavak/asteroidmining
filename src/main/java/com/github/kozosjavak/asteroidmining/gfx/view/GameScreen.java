package com.github.kozosjavak.asteroidmining.gfx.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.github.kozosjavak.asteroidmining.gfx.model.Model;

import java.util.List;

public class GameScreen implements Screen {

    //screen
    private final Camera camera;
    private final Viewport viewport;
    //graphics
    private final SpriteBatch batch;  //megjelnitendo texturak osszegsege
    private final Texture backGround;

    //world params meg kell tartani az aranyszamot
    private final int WORLD_WIDTH = 7680; //meterben ertendo
    private final int WORLD_HEIGHT = 4320; //veletlen muve ez nem a felbontas
    //timing
    private final int backGroundOffset; //kicsit mozgo hatterert

    private final TextureAtlas textureAtlas;

    public GameScreen() {
        camera = new OrthographicCamera(); //2d kamera, ami kesobb rendeledodik elobb van az jelenik meg, legegyszerubb kamera
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        backGround = new Texture("space_background.jpg");
        textureAtlas = new TextureAtlas("images.atlas");
        backGroundOffset = 0;
        batch = new SpriteBatch();
    }

    private List<Model> modelList;

    public TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }

    public void updateModelList(List<Model> modelList) {
        this.modelList = modelList;
    }

    private void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

    }

    @Override
    public void render(float delta) {   //delta = delta time megmondja hogy mennyi ido telt el a 2 render kort kozott (magyarul orahoz kotott ido, nem orajelhez)
        update();
        batch.begin();
        batch.draw(backGround, 0, -backGroundOffset, WORLD_WIDTH, WORLD_HEIGHT);
        for (Model model : modelList) {
            model.draw(batch);
        }


        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void show() {

    }
}
