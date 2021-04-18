package com.github.kozosjavak.asteroidmining.core.commands;

import com.github.kozosjavak.asteroidmining.core.Game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class CommandExecutor {
    //Jatekot tarolja amin dolgozunk
    private final Game game;
    //itt tarolja az elkeszult commandokat
    private final List<Command> executedCommands = new ArrayList<>();

    public CommandExecutor(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    //itt tudsz egy bizonyos commandot lefuttatni
    public void execute(Command command) throws Exception {
        command.apply(game);
        executedCommands.add(command);
    }

    //lefuttatja a tarolt osszes commandot
    public void executeAll(Collection<Command> commands) throws Exception {
        for (Command command : commands) {
            execute(command);
        }
    }

    //visszaadja a listat egy modosithatlan listaban
    public List<Command> getExecutedCommands() {
        return Collections.unmodifiableList(executedCommands);
    }

}
