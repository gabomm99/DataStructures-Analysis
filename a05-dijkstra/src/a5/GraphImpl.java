package a5;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class GraphImpl implements Graph {
    Map<String, Node> nodes; //do not delete, use this field to store your nodes
                             // key: name of node. value: a5.Node object associated with name

    private int numEdg;
    private int numNode;


    public GraphImpl() {
        nodes = new HashMap<>();
        numEdg = 0;
        numNode = 0;
    }

    @Override
    public boolean addNode(String name) {
        if(name == null){return false;}
        if(nodes.containsKey(name)){
            return false;
        }
        else{
            Node newNode = new NodeImpl(name);
            nodes.put(name, newNode);
            numNode += 1;
            return true;
        }
    }

    @Override
    public boolean addEdge(String src, String dest, double weight) {
        if (weight < 0){return false;}
        if (nodes.containsKey(src) == false){return false;}
        if (nodes.containsKey(dest) == false){return false;}
        Edge nEdge = new EdgeImpl(src, dest, weight);
        if (nodes.get(src).getOutdeg() == 0){
            nodes.get(src).addEdgeinNode(nEdge);
            nodes.get(dest).upIndeg();
            numEdg += 1;
            return true;
        }
        int i = 0;
        while(i < nodes.get(src).getEdges().size()){
            if (nEdge.equal(nodes.get(src).getEdges().get(i))){
                return false;
            }
            i++;
        }
        nodes.get(src).addEdgeinNode(nEdge);
        nodes.get(dest).upIndeg();
        numEdg += 1;
        return true;
    }

    @Override
    public boolean deleteNode(String name) {
        if(nodes.containsKey(name) == false){return false;}
        int i = 1;
        while(i < nodes.get(name).getEdges().size()){
            String dest = nodes.get(name).getEdges().get(i).getDesti();
            nodes.get(dest).downIndeg();
            i++;
        }
        for(Map.Entry<String, Node> entry: nodes.entrySet()){
            Edge importEdg = entry.getValue().findEdge(name);
            if (importEdg != null){
                entry.getValue().getEdges().remove(importEdg);
                entry.getValue().downOutdeg();
            }
        }
        nodes.remove(name);
        numNode -= 1;
        return true;
    }

    @Override
    public boolean deleteEdge(String src, String dest) {
        if(nodes.containsKey(src) == false){return false;}
        if(nodes.containsKey(dest) == false){return false;}
        Node important = nodes.get(src);
        Edge importantEdg = important.findEdge(dest);
        if(importantEdg != null){
            important.getEdges().remove(importantEdg);
            important.downOutdeg();
            nodes.get(dest).downIndeg();
            numEdg -= 1;
            return true;
        }
        return false;
    }

    @Override
    public int numNodes() {
        return numNode;
    }

    @Override
    public int numEdges() {
        return numEdg;
    }



    @Override
    public Map<String, Double> dijkstra(String start) {
        Map<String, Double> dijksTable = new HashMap<>();
        PriorityQueue<Node> edgeOrder = new PriorityQueue<>(numEdg + 1, new NodeDvComparator());
        dijksTable.put(start, 0.0);
        int i = 0;
        Node importNode = nodes.get(start);
        importNode.setStNode(true);
        while(i<importNode.getEdges().size()){
            Node adjNode = nodes.get(importNode.getEdges().get(i).getDesti());
            adjNode.setDv(importNode.getEdges().get(i).getWeight());
            edgeOrder.add(adjNode);
            adjNode.setPrNode(importNode.getName());
            i++;
        }
        while(edgeOrder.size() != 0){
            Node importNodeN = edgeOrder.poll();
            if(importNodeN.stateOfNode() == false){
                importNodeN.setStNode(true);
                int j = 0;
                while(j<importNodeN.getEdges().size()){
                    Node adjNodeN = nodes.get(importNodeN.getEdges().get(j).getDesti());
                    double pathL = (importNodeN.getEdges().get(j).getWeight()) + importNodeN.getDv();
                    if(adjNodeN.getDv() == 0.0){
                        adjNodeN.setDv(pathL);
                        adjNodeN.setPrNode(importNodeN.getName());
                    }
                    else if (adjNodeN.getDv() > pathL){
                        adjNodeN.setDv(pathL);
                        adjNodeN.setPrNode(importNodeN.getName());
                    }
                    edgeOrder.add(adjNodeN);
                    j++;
                }
                dijksTable.put(importNodeN.getName(), importNodeN.getDv());
            }
        }
        return dijksTable;
    }
}
