package dev.nukecraft5419.gamecore.errors;

public class MaterialNotFoundException extends Exception {
    private String material;

    public MaterialNotFoundException(String material) {
        super("Material " + material + " doesn't exist.");
        this.material = material;
    }

    public String getMaterialName() {
        return this.material;
    }
}