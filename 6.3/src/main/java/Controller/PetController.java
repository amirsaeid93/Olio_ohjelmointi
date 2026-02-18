package Controller;

import Model.Pet;

public class PetController {
    private final Pet pet;
    private final double speed = 2.0;

    public PetController(Pet pet) {
        this.pet = pet;
    }

    public void updatePosition(double mouseX, double mouseY) {
        double dx = mouseX - pet.getX();
        double dy = mouseY - pet.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance > speed) {
            double angle = Math.atan2(dy, dx);
            double newX = pet.getX() + speed * Math.cos(angle);
            double newY = pet.getY() + speed * Math.sin(angle);
            pet.setPosition(newX, newY);
        } else {
            pet.setPosition(mouseX, mouseY);
        }
    }
}