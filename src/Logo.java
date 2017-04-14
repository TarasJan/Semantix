import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Janek Taras on 4/14/2017.
 */
public class Logo implements Comparable {


    private HashMap<String, SemanticEdge> edges;
    private HashSet<Category> categories;
    private String ID;

    public int getNodeSize() {
        return nodeSize;
    }

    private int nodeSize;


    public String getID() {
        return ID;
    }

    public Logo(String ID) {
        edges = new HashMap<String, SemanticEdge>();
        categories = new HashSet<Category>();
        this.ID = ID;
        nodeSize = 0;


    }

    public void display() {
        System.out.println("ID: " + ID);
        System.out.println("No. of refernces: " + nodeSize);
      //  edges.forEach((k, v) -> System.out.println(k + " Connection strength: " + v.getStrength()));
    }

    public void grow(){nodeSize++;}

    public void solidifyBond(Logo other) {
        String ID = other.getID();
        if (edges.get(ID) == null) {
            edges.put(ID, new SemanticEdge(other, 1));
        } else {
            edges.get(other.getID()).strengthen(1);
        }
        other.grow();


    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Logo))return 0;
        if  ( ((Logo) o).getNodeSize() > getNodeSize())return -1;
        if ( ((Logo) o).getNodeSize() == getNodeSize() ) return 0;
        return 1;
    }
}
