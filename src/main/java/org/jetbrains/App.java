package org.jetbrains;

import nullsafety.NullsafetyKt;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        var value = new Random().nextInt() > 50 ? "blah" : null;
        NullsafetyKt.nullsafe(value);
    }
}
