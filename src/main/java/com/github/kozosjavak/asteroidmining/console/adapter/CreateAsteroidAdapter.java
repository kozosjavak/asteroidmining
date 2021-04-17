package com.github.kozosjavak.asteroidmining.console.adapter;

import com.github.kozosjavak.asteroidmining.core.commands.Command;
import com.github.kozosjavak.asteroidmining.core.commands.CreateAsteroidCommand;


//leterhozunk egy create asteroid commandot felismero command adaptert, azaz ez a class dolgozza fel a bejovo Stringet ami tartalmazza az adatokat a System.inbol
public class CreateAsteroidAdapter implements StringCommandAdapter {
    //Parse fgvt kell felulirni mindenhol
    @Override
    public Command parse(String str) {
        String[] splitted = str.split(" ");
        //Nagyon fontos, hogy itt kell egy ellenorzes hogy magara ismere-e a command, azaz itt a peldanak okaert: "create asteroid", meg kell nezzuk hogy a string eleje tartalmazzae a commandot
        if (splitted[0].equals("CreateAsteroid")) {
            //ha tartalmazza akkor itt adunk vissza egy uj commandot, amely construktoranak mar atadtuk a megfelelo adatokat a megfelelo formaban.

            //leterhozunk egy uj commandot az adatokkal megadva, es visszaadjuk a ConsoleCommandExecutornak, aminek a CommandExecutor foosztalya eltarolja az uj commandot
            return new CreateAsteroidCommand(Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]));
        }
        //Ha nem a "create asteroid" a string akkor szimplan nullt visszaadva a ConsoleCommandExecutor tudja hogy nem talalt a latogatas (visitor pattern).
        return null;
    }
}
