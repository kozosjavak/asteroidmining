package com.github.kozosjavak.asteroidmining.core;

/** Nulla felszínvastagság az aszteroidán kivétel */
public class SurfaceThicknessIsZeroException extends Exception {
    public SurfaceThicknessIsZeroException() {
        super("Surface already drilled into a hole!");
    }
}
