package com.github.kozosjavak.asteroidmining.core;

/**
 * Zero surface thickness
 */
public class SurfaceThicknessIsZeroException extends Exception {
    public SurfaceThicknessIsZeroException() {
        super("Surface already drilled into a hole!");
    }
}
