package br.com.ceduphh.joaopaulo.pokedex;

public class Pokemon {

    private final String name;
    private final int nationalNumber;
    private final Type primaryType;
    private final Type secondaryType;

    public Pokemon(String name, int nationalNumber, Type primaryType, Type secondaryType) {
        this.name = name;
        this.nationalNumber = nationalNumber;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
    }

    public String getName() {
        return name;
    }

    public int getNationalNumber() {
        return nationalNumber;
    }

    public Type getPrimaryType() {
        return primaryType;
    }

    public Type getSecondaryType() {
        return secondaryType;
    }
}
