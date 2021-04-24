package com.github.kozosjavak.asteroidmining.gfx.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    //screen
    private final Camera camera;
    private final Viewport viewport;
    //graphics
    private final SpriteBatch batch;  //megjelnitendo texturak osszegsege
    private final Texture backGround;

    //timing
    private final int backGroundOffset; //kicsit mozgo hatterert
    //world params
    private final int WORLD_WIDTH = 1920; //meterben ertendo
    private final int WORLD_HEIGHT = 1080; //veletlen muve ez nem a felbontas


    public GameScreen() {
        camera = new OrthographicCamera(); //2d kamera, ami kesobb rendeledodik elobb van az jelenik meg, legegyszerubb kamera
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        backGround = new Texture("space_background.jpg");
        backGroundOffset = 0;
        batch = new SpriteBatch();

    }

    private void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void render(float delta) {
        update();
        batch.begin();
        batch.draw(backGround, 0, 0, WORLD_WIDTH, WORLD_HEIGHT);


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
