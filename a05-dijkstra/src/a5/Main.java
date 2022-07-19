package a5;

import java.util.Map;

public class Main {

        public static void main(String[] args){
            //Node node1 = new NodeImpl(harry);
            //Node node2 = new NodeImpl(gabo);
            //Node node3 = new NodeImpl(jesus);
            //Node node4 = new NodeImpl(julio);
            Graph graph = new GraphImpl();
            boolean add1 = graph.addNode("gabo");
            //boolean add2 = graph.addNode("gabo");
            //boolean add3 = graph.addNode("jesus");
            //boolean add4 = graph.addNode("julio");
            //boolean add5 = graph.addNode("ivette");
            //boolean add6 = graph.addNode("juli");
            //boolean adde1 = graph.addEdge("gabo", "julio", 4);
            //boolean adde8 = graph.addEdge("gabo", "ivette", 8);
            //boolean adde9 = graph.addEdge("gabo", "jesus", 3);
            //boolean adde14 = graph.addEdge("gabo", "juli", 9);

            //boolean adde2 = graph.addEdge("julio", "gabo", 2);
            //boolean adde12 = graph.addEdge("julio", "juli", 8);
            //boolean adde6 = graph.addEdge("julio", "ivette", 7);
            //boolean adde4 = graph.addEdge("julio", "jesus", 4);

            //boolean adde3 = graph.addEdge("jesus", "julio", 3);
            //boolean adde13 = graph.addEdge("jesus", "juli", 3);
            //boolean adde15 = graph.addEdge("jesus", "gabo", 1);
            //boolean adde16 = graph.addEdge("jesus", "ivette", 7);

            //boolean adde5 = graph.addEdge("ivette", "julio", 5);
            //boolean adde7 = graph.addEdge("ivette", "gabo", 2);
            //boolean adde17 = graph.addEdge("ivette", "juli", 3);
           // boolean adde18 = graph.addEdge("ivette", "jesus ", 2);


            //boolean adde10 = graph.addEdge("juli", "ivette", 3);
            //boolean adde11 = graph.addEdge("juli", "gabo", 2);


            //boolean del1 = graph.deleteNode("gabo");
            //boolean adde10 = graph.addEdge("jesus", "gabo", 1);
            //boolean adde11 = graph.addEdge("ivette", "gabo", 2);
            //boolean adde12 = graph.addEdge("gabo", "ivette", 8);
            //boolean adde13 = graph.addEdge("gabo", "jesus", 3);
            //boolean adde14 = graph.addEdge("jesus", "gabo", 1);
            Map<String, Double> shotPath = graph.dijkstra("gabo");
            for(Map.Entry<String, Double> entry: shotPath.entrySet()){
                System.out.println(entry.getValue());
                System.out.println(entry.getKey());
            }
            //System.out.println(graph.getNodes().get("ivette").getEdges().size());

            //System.out.println(add2);
            //System.out.println(add3);
            //System.out.println(add4);
            //System.out.println(add5);
            //System.out.println(adde6);
            //System.out.println(adde7);
            //System.out.println(adde8);
            //System.out.println(adde9);
            //System.out.println(adde10);
            //System.out.println(adde11);
            //System.out.println(adde12);
            //System.out.println(adde13);
            //System.out.println(adde14);
        }
    }

