package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Class of the command executor
 */
public abstract class CommandExecutor {
    /**
     * Game
     */
    private final Game game;
    /**
     * Contains the command which have been successfully ran.
     */
    private final List<Command> executedCommands = new ArrayList<>();

    /**
     * Basic constructor
     *
     * @param game
     */
    public CommandExecutor(Game game) {
        this.game = game;
    }

    /**
     * Returns the game
     *
     * @return
     */
    public Game getGame() {
        return game;
    }

    /**
     * Calls the command apply()
     *
     * @param command Command
     * @throws Exception
     */
    public void execute(Command command) {
        command.apply(game);
        executedCommands.add(command);
    }

    /**
     * Calls all of the commands apply()
     *
     * @param commands
     * @throws Exception
     */
    public void executeAll(Collection<Command> commands) throws Exception {
        for (Command command : commands) {
            execute(command);
        }
    }

    /**
     * Returns the list of the executed commands
     *
     * @return
     */
    public List<Command> getExecutedCommands() {
        return Collections.unmodifiableList(executedCommands);
    }

}
