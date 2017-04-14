/**
 * Created by Janek Taras on 4/14/2017.
 */
public class SemanticEdge {

    public int getStrength() {
        return strength;
    }

    private int strength;
    private Logo destination;

    public SemanticEdge(Logo destination, int strength) throws IllegalArgumentException {
        try {
            if (strength <= 0) throw new IllegalArgumentException();
            this.destination = destination;
            this.strength = strength;
        } catch (IllegalArgumentException e) {
            System.out.println("Value of an semantic cannot be lower than one.");
        }

    }

    public void strengthen(int value) {
        strength = strength + value;
    }


}
