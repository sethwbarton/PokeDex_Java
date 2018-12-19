package com.sethbarton.pokedex_java.util;

import com.sethbarton.pokedex_java.models.Model;

public class Singleton {

    private Singleton() {}

    private static Singleton instance;

    public static Singleton getSingleton() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    static Model modelObject;

    public static Model getModelObject() {
        return modelObject;
    }

    public static void setModelObject(Model modelObject) {
        Singleton.modelObject = modelObject;
    }
}
