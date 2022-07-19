package a5;

import java.util.LinkedList;
public interface Node {

     void setDv(double path);

     double getDv();

     void setPrNode(String prevNode);

     String getPrNode();

     void upIndeg();

     void downIndeg();

     int getIndeg();

     void upOutdeg();

     void downOutdeg();

     int getOutdeg();

     LinkedList<Edge> getEdges();

     boolean addEdgeinNode(Edge newEdge);

     Edge findEdge(String destin);

     boolean stateOfNode();

     void setStNode(boolean fullyKnown);

     /**
      * @return the name of the node
      */
     String getName();

}
