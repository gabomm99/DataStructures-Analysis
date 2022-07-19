package a5;

public interface Edge {
    void setOrigin(String cameFrom);

    String getOrigin();

    void setDesti(String wentTo);

    String getDesti();

    void setWeight(double edgeWeight);

    double getWeight();

    boolean equal(Edge otherEdge);

}
