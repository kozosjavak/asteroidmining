package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;

public interface StringCommandAdapter {
    Command parse(String str);
}
