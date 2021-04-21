package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;

public class HelpCommand implements Command {
    @Override
    public void apply(Game game) {
        System.out.println("     ___           _______.___________. _______ .______        ______    __   _______     .___  ___.  __  .__   __.  __  .__   __.   _______ \n" +
                "    /   \\         /       |           ||   ____||   _  \\      /  __  \\  |  | |       \\    |   \\/   | |  | |  \\ |  | |  | |  \\ |  |  /  _____|\n" +
                "   /  ^  \\       |   (----`---|  |----`|  |__   |  |_)  |    |  |  |  | |  | |  .--.  |   |  \\  /  | |  | |   \\|  | |  | |   \\|  | |  |  __  \n" +
                "  /  /_\\  \\       \\   \\       |  |     |   __|  |      /     |  |  |  | |  | |  |  |  |   |  |\\/|  | |  | |  . `  | |  | |  . `  | |  | |_ | \n" +
                " /  _____  \\  .----)   |      |  |     |  |____ |  |\\  \\----.|  `--'  | |  | |  '--'  |   |  |  |  | |  | |  |\\   | |  | |  |\\   | |  |__| | \n" +
                "/__/     \\__\\ |_______/       |__|     |_______|| _| `._____| \\______/  |__| |_______/    |__|  |__| |__| |__| \\__| |__| |__| \\__|  \\______| by KozosJavak\n" +
                "                                                                                                                                             " +
                "\nHelp: \n" +
                "Commands are based of ID-s, every create command will give back an ID of the created object, you need to add ID-s in the commands!\n" +
                "Commands:\n" +
                "\tShowGameState\n" +
                "Create commands:\n" +
                "\tCreateAsteroid <int: thickness of surface> <Optional: ID of existing material>\n" +
                "\tCreateMaterial <Material type: iron/waterice/coal/uran> <Optional: if uran you can give int: number of exposions>\n" +
                "\tCreateRobot <int: ID of existing Asteroid>\n" +
                "\tCreateSettler <int: ID of existing Asteroid>\n" +
                "\tCreateSun\n" +
                "\tCreateUfo <int: ID of existing Asteroid>\n" +
                "\tCreateTeleport\n" +
                "Add commands:\n" +
                "\tAddNeighbor <int: ID of existing Asteroid A> <int: ID of existing Asteroid B>\n" +
                "\tAddTeleport <int: ID of existing Teleport> <int: ID of existing Asteroid>\n" +
                "SpaceShip command:\n" +
                "\tSpaceShipMove <int: ID of existing SpaceShip> <int: ID of existing Asteroid>\n" +
                "Settler commands:\n" +
                "\tSettlerAddMaterial <int: ID of existing Settler> <int: ID of existing Material>\n" +
                "\tSettlerInsertMaterial <int: ID of existing Settler> <int: ID of existing Material>\n" +
                "\tSettlerDrill <int: ID of existing Settler>\n" +
                "\tSettlerMine <int: ID of existing Settler>\n" +
                "\tSettlerRemoveMaterial <int: ID of existing Settler>\n" +
                "\tSettlerBuildBase <int: ID of existing Settler>\n" +
                "\tSettlerBuildRobot <int: ID of existing Settler>\n" +
                "\tSettlerBuildTeleport <int: ID of existing Settler>\n" +
                "\tSettlerUseTeleport <int: ID of existing Settler>\n" +
                "Ufo command:\n" +
                "\tUfoSteal <int: ID of existing Ufo>\n" +
                "Other commands:\n" +
                "\tStartCommand\n" +
                "\tLinkTeleports <int: ID of existing Teleport A> <int: ID of existing Teleport B>\n" +
                "\tInsertMaterial <int: ID of existing Asteroid A> <int: ID of existing Material>\n" +
                "\tStartSolarStorm");

    }
}
