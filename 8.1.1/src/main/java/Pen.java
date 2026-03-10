public class Pen {

    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; }
        @Override public String toString() { return color; }
    }

    private Color color;
    private boolean isCapOn;

    /*
      Default constructor. Creates a RED pen with the cap on.
     */
    public Pen() {
        this.color = Color.RED;
        this.isCapOn = true;
    }

    /**
     * Constructor to create a pen of a specific color, with the cap on.
     * @param color The initial color of the pen.
     */
    public Pen(Color color) {
        this.color = color;
        this.isCapOn = true;
    }

    /**
     * Removes the cap from the pen.
     */
    public void capOff() {
        this.isCapOn = false;
    }

    /**
     * Puts the cap on the pen.
     */
    public void capOn() {
        this.isCapOn = true;
    }

    /**
     * Simulates drawing with the pen.
     * @return A string indicating what is being drawn, or an empty string if the cap is on.
     */
    public String draw() {
        if (isCapOn) {
            return "";
        }
        return "Drawing " + this.color;
    }

    /**
     * Changes the color of the pen. This can only be done when the cap is on.
     * @param newColor The new color for the pen.
     */
    public void changeColor(Color newColor) {
        if (isCapOn) {
            this.color = newColor;
        }
    }
}