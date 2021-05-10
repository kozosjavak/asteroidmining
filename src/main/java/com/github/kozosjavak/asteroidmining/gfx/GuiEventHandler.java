package com.github.kozosjavak.asteroidmining.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.github.kozosjavak.asteroidmining.core.*;
import com.github.kozosjavak.asteroidmining.core.materials.InventoryIsFullException;
import com.github.kozosjavak.asteroidmining.core.materials.NotEnoughMaterialException;
import com.github.kozosjavak.asteroidmining.gfx.view.AsteroidListTable;
import com.github.kozosjavak.asteroidmining.gfx.view.AsteroidMiningGame;
import com.github.kozosjavak.asteroidmining.gfx.view.GameScreen;

import java.util.ArrayList;
import java.util.List;

public class GuiEventHandler implements InputProcessor {
    private final AsteroidMiningGame game;
    private final GameScreen gameScreen;
    private final AsteroidListTable asteroidListTable;
    private Location selectedLocation;

    public GuiEventHandler(AsteroidMiningGame game, GameScreen gameScreen) {
        this.game = game;
        this.gameScreen = gameScreen;
        this.asteroidListTable = gameScreen.getAsteroidListTable();
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
        //Asteroid table
        for (Steppable settler : settlerList) {
            Settler currentSettler = (Settler) settler;
            if (currentSettler.isSelected()) {
                asteroidListTable.setCurrentSettler(currentSettler);
            }
        }
        selectedLocation = asteroidListTable.getListLocation(screenX, screenY);
        //Drill
        if (screenX >= 2010 / game.getDivider() && screenX <= 2010 / game.getDivider() + 378 / game.getDivider() && screenY >= 15 / game.getDivider() && screenY <= 15 / game.getDivider() + 136 / game.getDivider()) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    try {
                        currentSettler.drill();
                    } catch (Exception exception) {
                        gameScreen.getInformationTable().setText(exception.getMessage());
                    }
                    currentSettler.setSelectedFalse();
                    System.out.println(currentSettler.getCurrentAsteroid().getSurfaceThickness());
                    gameScreen.getResourceTable().setInventory(currentSettler.getCurrentAsteroid().getAsteroidInventory(), currentSettler);
                }

            }
        }
        //Mine
        if (screenX >= 2010 / game.getDivider() && screenX <= 2010 / game.getDivider() + 378 / game.getDivider() && screenY >= 175 / game.getDivider() && screenY <= 175 / game.getDivider() + 136 / game.getDivider()) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    System.out.println(currentSettler.getCurrentAsteroid().getSubstance());
                    try {
                        currentSettler.mine();
                    } catch (Exception exception) {
                        gameScreen.getInformationTable().setText(exception.getMessage());
                    }
                    currentSettler.setSelectedFalse();
                    System.out.println(currentSettler.getCurrentAsteroid().getSubstance());
                    System.out.println(currentSettler.getInventory());
                    gameScreen.getResourceTable().setInventory(currentSettler.getCurrentAsteroid().getAsteroidInventory(), currentSettler);
                }
            }
        }
        //InsertMaterial
        if (screenX >= 1610 / game.getDivider() && screenX <= 1610 / game.getDivider() + 378 / game.getDivider() && screenY >= 655 / game.getDivider() && screenY <= 655 / game.getDivider() + 136 / game.getDivider()) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    try {
                        currentSettler.insertMaterial();
                    } catch (Exception exception) {
                        gameScreen.getInformationTable().setText(exception.getMessage());
                    }
                    currentSettler.setSelectedFalse();

                    System.out.println(currentSettler.getCurrentAsteroid().getSurfaceThickness());
                    System.out.println(currentSettler.getInventory());
                    System.out.println(currentSettler.getCurrentAsteroid().getAsteroidInventory());
                    gameScreen.getResourceTable().setInventory(currentSettler.getCurrentAsteroid().getAsteroidInventory(), currentSettler);
                }
            }
        }
        //Remove material
        if (screenX >= 2010 / game.getDivider() && screenX <= 2010 / game.getDivider() + 378 / game.getDivider() && screenY >= 655 / game.getDivider() && screenY <= 655 / game.getDivider() + 136 / game.getDivider()) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    try {
                        currentSettler.removeMaterial();
                    } catch (Exception exception) {
                        gameScreen.getInformationTable().setText(exception.getMessage());
                    }
                    currentSettler.setSelectedFalse();

                    System.out.println(currentSettler.getCurrentAsteroid().getSurfaceThickness());
                    System.out.println(currentSettler.getInventory());
                    System.out.println(currentSettler.getCurrentAsteroid().getAsteroidInventory());
                    gameScreen.getResourceTable().setInventory(currentSettler.getCurrentAsteroid().getAsteroidInventory(), currentSettler);
                }
            }
        }
        //Pass
        if (screenX >= 1612 / game.getDivider() && screenX <= 1612 / game.getDivider() + 776 / game.getDivider() && screenY >= 1297 / game.getDivider() && screenY <= 1297 / game.getDivider() + 138 / game.getDivider()) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    currentSettler.setSelectedFalse();
                    gameScreen.getInformationTable().setText("Lepes feladva!");
                    gameScreen.getResourceTable().setInventory(currentSettler.getCurrentAsteroid().getAsteroidInventory(), currentSettler);
                }

            }
        }
        //MOVE
        if (screenX >= 2010 / game.getDivider() && screenX <= 2010 / game.getDivider() + 378 / game.getDivider() && screenY >= 335 / game.getDivider() && screenY <= 335 / game.getDivider() + 136 / game.getDivider()) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    if (selectedLocation == null) {
                        try {
                            currentSettler.move(currentSettler.getCurrentAsteroid().getLocation().getRandomNeighbor());
                        } catch (NoNeighborException e) {
                            gameScreen.getInformationTable().setText(e.getMessage());
                        }
                    } else {
                        currentSettler.move(selectedLocation);
                    }

                    currentSettler.setSelectedFalse();
                    gameScreen.getResourceTable().setInventory(currentSettler.getCurrentAsteroid().getAsteroidInventory(), currentSettler);
                }

            }
        }
        //Deploy teleport
        if (screenX >= 1610 / game.getDivider() && screenX <= 1610 / game.getDivider() + 378 / game.getDivider() && screenY >= 495 / game.getDivider() && screenY <= 495 / game.getDivider() + 136 / game.getDivider()) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    try {
                        currentSettler.deployTeleport();
                    } catch (NoTeleportToDeployExecption noTeleportToDeployExecption) {
                        gameScreen.getInformationTable().setText(noTeleportToDeployExecption.getMessage());
                    }
                    //ezt itt teljesen ujragondolni
                    currentSettler.setSelectedFalse();
                    gameScreen.getResourceTable().setInventory(currentSettler.getCurrentAsteroid().getAsteroidInventory(), currentSettler);
                    System.out.println("Teleport deployed");
                }
            }
        }
        //Use teleport
        if (screenX >= 2010 / game.getDivider() && screenX <= 2010 / game.getDivider() + 378 / game.getDivider() && screenY >= 495 / game.getDivider() && screenY <= 495 / game.getDivider() + 136 / game.getDivider()) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    currentSettler.teleport();
                    currentSettler.setSelectedFalse();
                    gameScreen.getResourceTable().setInventory(currentSettler.getCurrentAsteroid().getAsteroidInventory(), currentSettler);
                    gameScreen.getInformationTable().setText("Upps where am i?");
                }
            }
        }
        //Build teleport pair
        if (screenX >= 2010 / game.getDivider() && screenX <= 2010 / game.getDivider() + 378 / game.getDivider() && screenY >= 815 / game.getDivider() && screenY <= 815 / game.getDivider() + 136 / game.getDivider()) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    try {
                        currentSettler.buildTeleportPair();
                    } catch (NotEnoughMaterialException e) {
                        gameScreen.getInformationTable().setText(e.getMessage());
                    }
                    currentSettler.setSelectedFalse();

                    gameScreen.getResourceTable().setInventory(currentSettler.getCurrentAsteroid().getAsteroidInventory(), currentSettler);
                }
            }
        }
        //Build robot
        if (screenX >= 2010 / game.getDivider() && screenX <= 2010 / game.getDivider() + 378 / game.getDivider() && screenY >= 977 / game.getDivider() && screenY <= 977 / game.getDivider() + 136 / game.getDivider()) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    try {
                        currentSettler.buildRobot();
                    } catch (NotEnoughMaterialException e) {
                        gameScreen.getInformationTable().setText(e.getMessage());
                    }
                    currentSettler.setSelectedFalse();
                    gameScreen.getResourceTable().setInventory(currentSettler.getCurrentAsteroid().getAsteroidInventory(), currentSettler);
                }
            }
        }
        //Build base
        if (screenX >= 2010 / game.getDivider() && screenX <= 2010 / game.getDivider() + 378 / game.getDivider() && screenY >= 1137 / game.getDivider() && screenY <= 1137 / game.getDivider() + 136 / game.getDivider()) {
            for (Steppable settler : settlerList) {
                Settler currentSettler = (Settler) settler;
                if (currentSettler.isSelected()) {
                    try {
                        currentSettler.buildBase();
                    } catch (NotEnoughMaterialException | InventoryIsFullException e) {
                        gameScreen.getInformationTable().setText(e.getMessage());
                    }
                    currentSettler.setSelectedFalse();
                    gameScreen.getResourceTable().setInventory(currentSettler.getCurrentAsteroid().getAsteroidInventory(), currentSettler);
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
