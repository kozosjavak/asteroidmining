package com.github.kozosjavak.asteroidmining.console;

import com.github.kozosjavak.asteroidmining.console.adapter.*;
import com.github.kozosjavak.asteroidmining.core.Game;
import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.CommandExecutor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

/**
 * Console communicator
 */
public class ConsoleCommandExecutor extends CommandExecutor {
    //Ird be a listaba az uj adaptert.
    private static final List<StringCommandAdapter> adapterCommandList = List.of(
            new StartCommandAdapter(),
            new CreateAsteroidAdapter(),
            new CreateMaterialAdapter(),
            new SpaceshipMoveAdapter(),
            new CreateSettlerAdapter(),
            new InsertMaterialAdapter(),
            new CreateSettlerAdapter(),
            new LinkTeleportsAdapter(),
            new CreateSettlerAdapter(),
            new CreateSunAdapter()
    );

    public ConsoleCommandExecutor(Game game) {
        super(game);
    }

    //Magic
    public void attachToConsole() {

        try (Scanner scanner = new Scanner(System.in)) {

            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                Optional<Command> optionalCommand = adapterCommandList.stream()
                        .map(stringCommandAdapter -> stringCommandAdapter.parse(line))
                        .filter(Objects::nonNull)
                        .findFirst();
                if (optionalCommand.isPresent()) {
                    execute(optionalCommand.get());
                } else {
                    System.out.println("Wrong command");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
