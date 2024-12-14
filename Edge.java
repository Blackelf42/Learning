import java.util.*;

public class Edge {

    private int target;
    public int getTarget() {
        return target;
    }

    private double weight;
    public double getWeight() {
        return weight;
    }

    Edge(int target, double weight) {
        this.target = target;
        this.weight = weight;
    }
}