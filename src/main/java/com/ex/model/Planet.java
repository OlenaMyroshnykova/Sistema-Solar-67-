package com.ex.model;

public class Planet {
    private String name;
    private int satelliteCount;
    private double mass;
    private double volume;
    private int diameter;
    private int averageDistanceFromSun;
    private PlanetType type;
    private boolean visibleToNakedEye;

    public enum PlanetType {
        GASEOSO("Gigante gaseoso"),
        TERRESTRE("Planeta terrestre"),
        ENANO("Planeta enano");

        private final String description;

        PlanetType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public Planet(String name, int satelliteCount, double mass, double volume, int diameter, int averageDistanceFromSun,
                  PlanetType type, boolean visibleToNakedEye, double orbitalPeriod, double rotationPeriod) {
        this.name = name;
        this.satelliteCount = satelliteCount;
        this.mass = mass;
        this.volume = volume;
        this.diameter = diameter;
        this.averageDistanceFromSun = averageDistanceFromSun;
        this.type = type;
        this.visibleToNakedEye = visibleToNakedEye;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getSatelliteCount() {
        return satelliteCount;
    }

    public double getMass() {
        return mass;
    }

    public double getVolume() {
        return volume;
    }

    public int getDiameter() {
        return diameter;
    }

    public int getAverageDistanceFromSun() {
        return averageDistanceFromSun;
    }

    public PlanetType getType() {
        return type;
    }

    public boolean isVisibleToNakedEye() {
        return visibleToNakedEye;
    }

    public String getInfo() {
        return String.format("""
                Nombre: %s
                Satélites: %d
                Masa (kg): %.2e
                Volumen (km³): %.2e
                Diámetro (km): %d
                Distancia media al Sol (millones km): %d
                Tipo: %s
                Visible a simple vista: %b
                """,
                name, satelliteCount, mass, volume, diameter, averageDistanceFromSun,
                type.getDescription(), visibleToNakedEye);
    }

    public double calculateDensity() {
        if (volume == 0) {
            throw new ArithmeticException("El volumen no puede ser cero.");
        }
        return mass / volume;
    }

    public boolean isOuterPlanet() {
        double distanceInAU = averageDistanceFromSun * 1_000_000 / 149_597_870.0;
        return distanceInAU > 3.4;
    }
}

