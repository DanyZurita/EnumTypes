package edu.elsmancs.EnumTypes;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;



public enum Planeta {
    MERCURY (3.303e+23, 2.4397e6),     
    VENUS (4.869e+24, 6.0518e6),     
    EARTH (5.976e+24, 6.37814e6),     
    MARS (6.421e+23, 3.3972e6),     
    JUPITER (1.9e+27,   7.1492e7),     
    SATURN (5.688e+26, 6.0268e7),     
    URANUS (8.686e+25, 2.5559e7),     
    NEPTUNE (1.024e+26, 2.4746e7); 
    
    public final double G = 6.67400e-11;
    private double masa = 0.0;
    private double radio = 0.0;
    
    Planeta (double masa, double radio) {
        this.masa = masa;
        this.radio = radio;
    }

    public double getMasa() {
        return this.masa;
    }

    public double getRadio() {
        return this.radio;
    }
    
    private double getGravity() {
        return G * getMasa() / (getRadio() * getRadio());
    }
    
    private double getGravity(Planeta planeta) {
        return G * planeta.getMasa() / (planeta.getRadio() * planeta.getRadio());
    }
    
    private double masaTerricola(double peso) {
        return peso / getGravity(EARTH);
    }
    
    public double pesoSuperficie(double peso) {
        return masaTerricola(peso) * getGravity();
    }
    
    public static EnumSet<Planeta> getPlanetasTerrestres(){
        return EnumSet.range(MERCURY, MARS);
    }
}
