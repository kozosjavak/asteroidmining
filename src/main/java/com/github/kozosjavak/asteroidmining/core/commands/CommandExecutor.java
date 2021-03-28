package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class CommandExecutor {
    private final Game game;
    private final List<Command> executedCommands = new ArrayList<>();

    public CommandExecutor(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void execute(Command command) {
        command.apply(game);
        executedCommands.add(command);
    }

    public void executeAll(Collection<Command> commands) {
        for (Command command : commands) {
            execute(command);
        }
    }

    public List<Command> getExecutedCommands() {
        return Collections.unmodifiableList(executedCommands);
    }
}
