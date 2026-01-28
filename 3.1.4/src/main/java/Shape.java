class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public double calculateArea() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Shape (Color: " + color + ")";
    }
}