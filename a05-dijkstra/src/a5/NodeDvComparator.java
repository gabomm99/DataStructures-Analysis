package a5;

import java.util.Comparator;

public class NodeDvComparator implements Comparator<Node>{
    public int compare(Node dv1, Node dv2){
        if (dv1.getDv() > dv2.getDv()){
            return 1;
        }
        else if(dv1.getDv() < dv2.getDv()){
            return -1;
        }
        return 0;
    }
}
