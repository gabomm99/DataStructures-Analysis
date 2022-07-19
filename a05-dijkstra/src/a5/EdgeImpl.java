package a5;

public class EdgeImpl implements Edge {

    private String origin;
    private String destin;
    private double weight;

    public EdgeImpl(String orig, String dest, double weg){
        origin = orig;
        destin = dest;
        weight = weg;
    }

    public void setOrigin(String cameFrom){
        origin = cameFrom;
    }

    public String getOrigin(){
        return origin;
    }

    public void setDesti(String wentTo){
        destin = wentTo;
    }

    public String getDesti(){
        return destin;
    }

    public void setWeight(double edgeWeight){
        weight = edgeWeight;
    }

    public double getWeight(){
        return weight;
    }

    public boolean equal(Edge otherEdge){
        if((this.origin == otherEdge.getOrigin()) && (this.destin == otherEdge.getDesti())){
            return true;
        }
        else{return false;}
    }


}
