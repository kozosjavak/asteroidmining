package com.github.kozosjavak.asteroidmining.gfx.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainMenuScreen implements Screen {
    Camera camera;
    Viewport viewport;
    Texture backGround;
    SpriteBatch spriteBatch;
    Stage stage;
    Table table;
    //ImageButton playButton;
    //Skin skin = new Skin();

    public MainMenuScreen() {
        camera = new OrthographicCamera();
        viewport = new StretchViewport(1200, 800, camera);
        backGround = new Texture("fomenu.png");
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void show() {
        //  playButton = new ImageButton(skin);
        //   playButton.addListener(new ClickListener(){
//
        // });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        spriteBatch.begin();
        spriteBatch.draw(backGround, 0, 0, 1200, 800);
        spriteBatch.end();


    }

    @Override
    public void resize(int width, int height) {
        viewport.update(1200, 800, true);
        spriteBatch.setProjectionMatrix(camera.combined);
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
}
