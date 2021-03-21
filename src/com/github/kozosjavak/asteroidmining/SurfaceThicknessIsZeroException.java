package com.github.kozosjavak.asteroidmining;

/** Nulla felszínvastagság az aszteroidán kivétel */
public class SurfaceThicknessIsZeroException extends Exception {
    public SurfaceThicknessIsZeroException() {
        super("Surface already drilled into a hole!");
    }
}
