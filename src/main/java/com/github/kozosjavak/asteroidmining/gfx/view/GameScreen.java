package com.github.kozosjavak.asteroidmining.gfx.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.github.kozosjavak.asteroidmining.core.Settler;
import com.github.kozosjavak.asteroidmining.core.Steppable;
import com.github.kozosjavak.asteroidmining.gfx.model.Model;

import java.util.List;
import java.util.Random;

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
    private final InformationTable informationTable;
    private final ResourceTable resourceTable;
    private final AsteroidListTable asteroidListTable;
    //world params meg kell tartani az aranyszamot
    private final int RENDER_WIDTH = 1200; //meterben ertendo
    private final int RENDER_HEIGHT = 800; //veletlen muve ez nem a felbontas
    //timing
    private final int backGroundOffset; //kicsit mozgo hatterert
    private final TextureAtlas textureAtlas;
    AsteroidMiningGame asteroidMiningGame;
    int counter = 1;
    String[] erzsike;
    private List<Model> modelList;
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
        this.informationTable = new InformationTable(batch, this);
        this.resourceTable = new ResourceTable(batch);
        this.asteroidListTable = new AsteroidListTable(batch, this, asteroidMiningGame);
        this.asteroidListTable.setCurrentSettler((Settler) asteroidMiningGame.getGame().getSettlers().get(0));
        erzsike = new String[8];

        informationTable.setText("Üdvözöl Kozos_javak es Erzsike!");
    }

    public AsteroidListTable getAsteroidListTable() {
        return asteroidListTable;
    }

    public String getRandomErzsike() {
        Random random = new Random();
        erzsike[0] = "A mai napig titkolja kollégái elött, hogy felesége földönkivüli.";
        erzsike[1] = "A volt baratnöjétöl haza költözött, mikor meghallota hogy \nedesanyját idegenek látogatják.";
        erzsike[2] = "Az E.T. a kedvenc filmje.";
        erzsike[3] = "A szomszédoknál azzal dicsekszik, hogy idegenek révén tudja,\nmilyen lesz az idö.";
        erzsike[3] = "A kornyékbeli közértben is \nmindig földönkivüli nyelven köszön.";
        erzsike[4] = "Kitagadta a lányát, mert ö nem hitte el, hogy kapcsoltban\náll az idegenekkel";
        erzsike[5] = "Férje szerint Erzsi köpenye a szkafandere.";
        erzsike[6] = "Egy idegen bolygorol erkeztem!";
        erzsike[7] = "Az Irisz bolygon más az élet!";
        return erzsike[random.nextInt(7)];
    }

    public ResourceTable getResourceTable() {
        return resourceTable;
    }

    public InformationTable getInformationTable() {
        return informationTable;
    }

    public TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }

    public void updateModelList(List<Model> modelList) {
        this.modelList = modelList;
    }

    private void update() {

        if (asteroidMiningGame.getGame().isWon() || !asteroidMiningGame.getGame().isRunning() && counter != 0) {
            counter--;
            asteroidMiningGame.getJanosHegyen().stop();
            asteroidMiningGame.getLoopmusic().play();
        }


    }

    @Override
    public void render(float delta) {   //delta = delta time megmondja hogy mennyi ido telt el a 2 render kort kozott (magyarul orahoz kotott ido, nem orajelhez)
        update();
        batch.begin();
        if (asteroidMiningGame.getGame().isRunning()) {
            for (Steppable settler : asteroidMiningGame.getGame().getSettlers()) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    asteroidListTable.setCurrentSettler(currentSettler);
                }
            }
            batch.draw(backGround, 0, -backGroundOffset, RENDER_WIDTH, RENDER_HEIGHT);
            batch.draw(settlerMenu, 800, 0, 400, 800);
            for (Model model : modelList) {
                model.draw(batch);
            }
            asteroidListTable.draw();
            informationTable.draw();
            resourceTable.draw();


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
