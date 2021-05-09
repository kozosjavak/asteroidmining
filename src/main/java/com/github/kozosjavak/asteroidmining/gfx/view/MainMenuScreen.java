package com.github.kozosjavak.asteroidmining.gfx.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.github.kozosjavak.asteroidmining.gfx.GuiEventHandler;
import com.github.kozosjavak.asteroidmining.gfx.MainMenuEventHandler;

public class MainMenuScreen implements Screen {
    Camera camera;
    Viewport viewport;
    Texture backGround;
    SpriteBatch spriteBatch;


    AsteroidMiningGame game;
    GameScreen gameScreen;
    MainMenuEventHandler eventHandler;


    public MainMenuScreen(AsteroidMiningGame game, GameScreen gameScreen, GuiEventHandler guiEventHandler) {
        camera = new OrthographicCamera();
        viewport = new StretchViewport(1200, 800, camera);
        backGround = new Texture("fomenu.png");
        spriteBatch = new SpriteBatch();

        eventHandler = new MainMenuEventHandler(this, guiEventHandler, game);
        this.game = game;
        this.gameScreen = gameScreen;
        Gdx.input.setInputProcessor(eventHandler);

    }

    public void setScreenToGame() {
        game.setScreen(gameScreen);
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
