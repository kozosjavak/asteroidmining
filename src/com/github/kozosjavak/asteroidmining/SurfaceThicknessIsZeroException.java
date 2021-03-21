package com.github.kozosjavak.asteroidmining;

public class SurfaceThicknessIsZeroException extends Exception {
    public SurfaceThicknessIsZeroException() {
        super("Surface already drilled into a hole!");
    }
}
