package com.github.kozosjavak.asteroidmining.e2e;

import com.github.kozosjavak.asteroidmining.core.Game;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;

public class NapviharTest {

    @Test
    @Ignore
    public void it_should_run_test() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com/github/kozosjavak/asteroidmining/e2e/input-napvihar.txt");
        Game game = E2eTools.getGame(inputStream);
        // TODO
    }
}
