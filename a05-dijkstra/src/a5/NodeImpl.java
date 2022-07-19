package a5;

import java.util.LinkedList;

public class NodeImpl implements Node {

    private String name;
    private int inDegree;
    private int outDegree;
    private double Dv;
    private String PrNode;
    private boolean stateOfNode;
    private LinkedList<Edge> edges;


    public NodeImpl(String newName){
        name = newName;
        inDegree = 0;
        outDegree = 0;
        Dv = 0.0;
        edges = new LinkedList<>();
        PrNode = null;
        stateOfNode = false;
    }

    public void setDv(double path){
        Dv = path;
    }

    public double getDv(){
        return Dv;
    }

    public void setPrNode(String prevNode){
        PrNode = prevNode;
    }

    public String getPrNode(){
        return PrNode;
    }

    public void upIndeg(){
        inDegree += 1;
    }

    public void downIndeg(){
        outDegree -= 1;
    }


    public int getIndeg(){
        return inDegree;
    }

    public void upOutdeg(){
        outDegree += 1;
    }

    public void downOutdeg(){
        outDegree -= 1;
    }

    public int getOutdeg(){
        return outDegree;
    }

    public LinkedList<Edge> getEdges(){
        return edges;
    }

    public boolean addEdgeinNode(Edge newEdge){
        if (edges == null){
            edges.add(newEdge);
            upOutdeg();
            return true;
        }
        if (edges.contains(newEdge)){
            return false;
        }
        else{
            edges.add(newEdge);
            upOutdeg();
            return true;
        }
    }

    public Edge findEdge(String destin){
        for(int i = 0; i < edges.size(); i++){
            if (edges.get(i).getDesti().equals(destin)){
                return edges.get(i);
            }
        }
        return null;
    }

    public boolean getStNode(){
        return stateOfNode;
    }

    public void setStNode(boolean state){
        stateOfNode = state;
    }

    public boolean stateOfNode(){
        return stateOfNode;
    }

    public String getName(){
        return name;
    }

}
