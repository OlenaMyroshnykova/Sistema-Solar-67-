package com.ex.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlanetTest {

    @Test
    void testGetInfo() {
        Planet planet = new Planet("Tierra", 1, 5.972e24, 1.08321e12, 12742, 149,
                Planet.PlanetType.TERRESTRE, true, 1, 0.997);
        String info = planet.getInfo();
        assertTrue(info.contains("Nombre: Tierra"));
        assertTrue(info.contains("Planeta terrestre"));
    }

    @Test
    void testCalculateDensity() {
        Planet planet = new Planet("Tierra", 1, 5.972e24, 1.08321e12, 12742, 149,
                Planet.PlanetType.TERRESTRE, true, 1, 0.997);
        double density = planet.calculateDensity();
        assertEquals(5.513243046131406E12, density, 0.1);
    }

    @Test
    void testCalculateDensityZeroVolume() {
        Planet planet = new Planet("Test", 0, 5.972e24, 0, 12742, 149,
                Planet.PlanetType.TERRESTRE, false, 1, 1);
        Exception exception = assertThrows(ArithmeticException.class, planet::calculateDensity);
        assertEquals("El volumen no puede ser cero.", exception.getMessage());
    }

    @Test
    void testIsOuterPlanet() {
        Planet planet = new Planet("Júpiter", 79, 1.898e27, 1.43128e15, 139820, 778,
                Planet.PlanetType.GASEOSO, true, 11.86, 0.41);
        assertTrue(planet.isOuterPlanet());
    }

    @Test
    void testIsNotOuterPlanet() {
        Planet planet = new Planet("Tierra", 1, 5.972e24, 1.08321e12, 12742, 149,
                Planet.PlanetType.TERRESTRE, true, 1, 0.997);
        assertFalse(planet.isOuterPlanet());
    }

    @Test
    void testGetters() {
        Planet planet = new Planet("Tierra", 1, 5.972e24, 1.08321e12, 12742, 149,
                Planet.PlanetType.TERRESTRE, true, 1.0, 0.997);

        assertEquals("Tierra", planet.getName());
        assertEquals(1, planet.getSatelliteCount());
        assertEquals(5.972e24, planet.getMass(), 0.0);
        assertEquals(1.08321e12, planet.getVolume(), 0.0);
        assertEquals(12742, planet.getDiameter());
        assertEquals(149, planet.getAverageDistanceFromSun());
        assertEquals(Planet.PlanetType.TERRESTRE, planet.getType());
        assertTrue(planet.isVisibleToNakedEye());
        assertEquals(1.0, planet.getOrbitalPeriod(), 0.0);
        assertEquals(0.997, planet.getRotationPeriod(), 0.0);
    }

    @Test
    void testEnumDescription() {
        assertEquals("Gigante gaseoso", Planet.PlanetType.GASEOSO.getDescription());
        assertEquals("Planeta terrestre", Planet.PlanetType.TERRESTRE.getDescription());
        assertEquals("Planeta enano", Planet.PlanetType.ENANO.getDescription());
    }
}
