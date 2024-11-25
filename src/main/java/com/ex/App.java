package com.ex;

import com.ex.model.Planet;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Planet earth = new Planet(
            "Tierra", 1, 5.972e24, 1.08321e12, 12742, 149,
            Planet.PlanetType.TERRESTRE, true, 1, 0.997
        );

        Planet jupiter = new Planet(
            "Júpiter", 79, 1.898e27, 1.43128e15, 139820, 778,
            Planet.PlanetType.GASEOSO, true, 11.86, 0.41
        );

        System.out.println("Información de los planetas:\n");
        System.out.println(earth.getInfo());
        System.out.printf("Densidad: %.3f kg/m³\n", earth.calculateDensity());
        System.out.println("¿Es planeta exterior? " + (earth.isOuterPlanet() ? "Sí" : "No"));
        System.out.println();

        System.out.println(jupiter.getInfo());
        System.out.printf("Densidad: %.3f kg/m³\n", jupiter.calculateDensity());
        System.out.println("¿Es planeta exterior? " + (jupiter.isOuterPlanet() ? "Sí" : "No"));
    }
}