package com.github.kozosjavak.asteroidmining.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.github.kozosjavak.asteroidmining.core.NoNeighborException;
import com.github.kozosjavak.asteroidmining.core.Settler;
import com.github.kozosjavak.asteroidmining.core.Steppable;
import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;
import com.github.kozosjavak.asteroidmining.gfx.view.AsteroidMiningGame;

import java.util.ArrayList;
import java.util.List;

public class GuiEventHandler implements InputProcessor {
    AsteroidMiningGame game;

    public GuiEventHandler(AsteroidMiningGame game) {
        this.game = game;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        List<Steppable> settlerList = new ArrayList<>(game.getGame().getSettlers());

        //Drill
        if (screenX >= 2010 && screenX <= 2010 + 378 && screenY >= 15 && screenY <= 15 + 136) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    try {
                        currentSettler.drill();
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    currentSettler.setSelectedFalse();
                    System.out.println(currentSettler.getCurrentAsteroid().getSurfaceThickness());
                }
            }
        }
        //Mine
        if (screenX >= 2010 && screenX <= 2010 + 378 && screenY >= 175 && screenY <= 175 + 136) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    System.out.println(currentSettler.getCurrentAsteroid().getSubstance());
                    try {
                        currentSettler.mine();
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    currentSettler.setSelectedFalse();
                    System.out.println(currentSettler.getCurrentAsteroid().getSubstance());
                    System.out.println(currentSettler.getInventory());
                }
            }
        }
        //InsertMaterial
        if (screenX >= 2010 && screenX <= 2010 + 378 && screenY >= 337 && screenY <= 337 + 136) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    try {
                        currentSettler.insertMaterial();
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    currentSettler.setSelectedFalse();

                    System.out.println(currentSettler.getCurrentAsteroid().getSurfaceThickness());
                    System.out.println(currentSettler.getInventory());
                    System.out.println(currentSettler.getCurrentAsteroid().getAsteroidInventory());
                }
            }
        }
        //Pass
        if (screenX >= 1612 && screenX <= 1612 + 776 && screenY >= 1297 && screenY <= 1297 + 138) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    currentSettler.setSelectedFalse();
                    System.out.println("Lepes feladva!");
                }

            }
        }
        //MOVE
        if (screenX >= 1612 && screenX <= 1612 + 378 && screenY >= 657 && screenY <= 657 + 136) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    try {
                        currentSettler.move(currentSettler.getCurrentAsteroid().getLocation().getRandomNeighbor());
                    } catch (NoNeighborException e) {
                        e.printStackTrace();
                    }
                    currentSettler.setSelectedFalse();
                }

            }
        }
        //Deploy teleport
        if (screenX >= 2010 && screenX <= 2010 + 378 && screenY >= 497 && screenY <= 497 + 136) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    currentSettler.deployTeleport(0);
                    //ezt itt teljesen ujragondolni
                    currentSettler.setSelectedFalse();
                }
            }
        }
        //Use teleport
        if (screenX >= 2010 && screenX <= 2010 + 378 && screenY >= 655 && screenY <= 655 + 136) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    currentSettler.teleport();
                    currentSettler.setSelectedFalse();
                }
            }
        }
        //Build teleport pair
        if (screenX >= 2010 && screenX <= 2010 + 378 && screenY >= 815 && screenY <= 815 + 136) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    try {
                        currentSettler.buildTeleportPair();
                    } catch (NotEnoughMaterialException e) {
                        e.printStackTrace();
                    }
                    currentSettler.setSelectedFalse();
                }
            }
        }
        //Build robot
        if (screenX >= 2010 && screenX <= 2010 + 378 && screenY >= 977 && screenY <= 977 + 136) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    try {
                        currentSettler.buildRobot();
                    } catch (NotEnoughMaterialException e) {
                        e.printStackTrace();
                    }
                    currentSettler.setSelectedFalse();
                }
            }
        }
        //Build base
        if (screenX >= 2010 && screenX <= 2010 + 378 && screenY >= 1137 && screenY <= 1137 + 136) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    try {
                        currentSettler.buildBase();
                    } catch (NotEnoughMaterialException | InventoryIsFullException e) {
                        e.printStackTrace();
                    }
                    currentSettler.setSelectedFalse();
                }
            }
        }
        System.out.println(screenX + " " + screenY);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
