package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
//Mindig ezt az interfacet add a command adapterhez
public interface StringCommandAdapter {
    Command parse(String str);
}
