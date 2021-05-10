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
    private final Texture settlerMenu;
    private final Texture gameover;
    private final Texture gamewon;

    //world params meg kell tartani az aranyszamot
    private final int RENDER_WIDTH = 1200; //meterben ertendo
    private final int RENDER_HEIGHT = 800; //veletlen muve ez nem a felbontas
    //timing
    private final int backGroundOffset; //kicsit mozgo hatterert

    private final TextureAtlas textureAtlas;

    AsteroidMiningGame asteroidMiningGame;

    public GameScreen(AsteroidMiningGame asteroidMiningGame) {
        camera = new OrthographicCamera(); //2d kamera, ami kesobb rendeledodik elobb van az jelenik meg, legegyszerubb kamera
        viewport = new StretchViewport(RENDER_WIDTH, RENDER_HEIGHT, camera);
        backGround = new Texture("space_background.jpg");
        settlerMenu = new Texture("settlermenu.png");
        gameover = new Texture("gameover.png");
        gamewon = new Texture("gamewon.png");
        textureAtlas = new TextureAtlas("images.atlas");
        backGroundOffset = 0;
        this.asteroidMiningGame = asteroidMiningGame;
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
        if (asteroidMiningGame.getGame().isRunning()) {
            batch.draw(backGround, 0, -backGroundOffset, RENDER_WIDTH, RENDER_HEIGHT);
            batch.draw(settlerMenu, 800, 0, 400, 800);
            for (Model model : modelList) {
                model.draw(batch);
            }
        } else if (asteroidMiningGame.getGame().isWon()) {
            //win kep
            batch.draw(gamewon, 0, -backGroundOffset, RENDER_WIDTH, RENDER_HEIGHT);
        } else {
            //loose kep
            batch.draw(gameover, 0, -backGroundOffset, RENDER_WIDTH, RENDER_HEIGHT);
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
