package a3;

public class BSTImpl implements BST {

    private Node root;
    private int size;

    public BSTImpl() {
        root = null;
        size = 0;
    }

    public BSTImpl(String s) {
        root = new NodeImpl(s);
        size = 0;
    }

    // The implementation of "height" is given to you below
    // it is here to illustrate for you how to set up
    // the method implementation as recursion.
    // You should follow this pattern for implementing the other recursive methods
    // by adding your own private recursive methods
    public void show(){
        int off=4;
        int lev=0;
        for (int k=0; k<10; k++) {
            System.out.print("+");
            for (int kk=0; kk<off-1; kk++){
                System.out.print("-");
            }
        }
        System.out.println("+");
        show_r(this.root,lev,off);
        for (int k=0; k<10; k++) {
            System.out.print("+");
            for (int kk=0; kk<off-1; kk++){
                System.out.print("-");
            }
        }
        System.out.println("+");
    }

    private void show_r(Node n, int lev, int off){
        if (n==null) return;
        show_r(n.getRight(), lev+off, off);
        for( int b=0; b<lev; b++) {System.out.print(" ");}
        System.out.println(n.getValue());
        show_r(n.getLeft(), lev+off, off);
    }

    @Override
    public int height() { // public interface method signature
        // this method is the public interface method
        // it is not recursive, but it calls a recursive
        // private method and passes it access to the tree cells
        return height_recursive(this.root);
    }
    private int height_recursive(Node c) {
        // inner method with different signature
        // this helper method uses recursion to traverse
        // and process the recursive structure of the tree of cells
        if (c==null) return -1;
        int lht = height_recursive(c.getLeft());
        int rht = height_recursive(c.getRight());
        return Math.max(lht,rht) + 1;
    }

    @Override
    public Node getRoot() {
        return this.root;
    }

    @Override
    public String insert(String value) {
        insert_recursive(this.root, value);
        return value;
    }
    private void insert_recursive(Node x, String value) {
        if(x == null){
            Node newNode = new NodeImpl(null, null , value);
            root = newNode;
            size++;
            return;
        }
        int i = 0;
        String currentNodeValue = x.getValue();
        while(value.charAt(i) == currentNodeValue.charAt(i)) {
            if( i == (currentNodeValue.length() - 1)){
                if(x.getRight() == null){
                    Node newNode = new NodeImpl(null, null , value);
                    x.setRight(newNode);
                    size++;
                    return;
                }
                insert_recursive(x.getRight(), value);
                return;
            }
            else if(i == (value.length() - 1)){
                if(x.getLeft() == null){
                    Node newNode = new NodeImpl(null, null , value);
                    x.setLeft(newNode);
                    size++;
                    return;
                }
                insert_recursive(x.getLeft(), value);
                return;
            }
            i++;
        }
        if (value.charAt(i) < currentNodeValue.charAt(i)){
            if(x.getLeft() == null){
                Node newNode = new NodeImpl(null, null , value);
                x.setLeft(newNode);
                size++;
                return;
            }
            insert_recursive(x.getLeft(), value);
            return;
        }
        if (value.charAt(i) > currentNodeValue.charAt(i)){
            if(x.getRight() == null){
                Node newNode = new NodeImpl(null, null , value);
                x.setRight(newNode);
                size++;
                return;
            }
            insert_recursive(x.getRight(), value);
            return;
        }
    }

    // remove implementation given to you, do NOT change
    @Override
    public void remove(String value) {
        remove_r(value,this.root);
        size--;
    }
    private Node remove_r(String k, Node c) {
        if (c==null) return null; // item not found, nothing to do

        // now we know we have a real node to examine
        int cflag = k.compareTo(c.getValue());

        if (cflag<0) { // k is smaller than node
            c.setLeft(remove_r(k,c.getLeft()));
            return c;
        }
        else
        if (cflag>0) { // k is larger than node
            c.setRight(remove_r(k,c.getRight()));
            return c;
        }
        else //cflag==0
        { // found it... now figure out how to rearrange

            // cases
            if (c.getLeft()==null && c.getRight()==null) { c = null; } // leaf
            else if (c.getLeft()==null && c.getRight()!=null) { c = c.getRight(); } // RC only
            else if (c.getLeft()!=null && c.getRight()==null) { c = c.getLeft(); } // LC only
            else { // 2 children
                Node max = maxCell(c.getLeft());
                c.setValue(max.getValue());
                c.setLeft(remove_r(c.getValue(), c.getLeft()));   // recurse
            }
            return c;
        }

    }

    private Node maxCell(Node c) { // this is used in remove too
        if (c.getRight()==null) return c;
        return maxCell(c.getRight());
    }

    @Override
    public boolean isFull() {
        return isFull_recursive(this.root);
    }
    private boolean isFull_recursive(Node x){
        if(x == null){return true;}
        if(x.getRight() == null && x.getLeft() == null){
            return true;
        }
        if(x.getRight() != null && x.getLeft() != null){
            return isFull_recursive(x.getRight()) && isFull_recursive(x.getLeft());
        }
        return false;
    }
    @Override
    public String findMin() {
        return findMin_recursive(this.root);
    }
    String minValue = "";
    private String findMin_recursive(Node x){
        if(x == null){return "this is an empty tree";}
        minValue = x.getValue();
        if(x.getLeft() != null){
            findMin_recursive(x.getLeft());
        }
        return minValue;
    }

    @Override
    public String findMax() {
        return findMax_recursive(this.root);
    }
    String maxValue = "";
    private String findMax_recursive(Node x){
        if(x == null){return "this is an empty tree";}
        maxValue = x.getValue();
        if(x.getRight() != null){
            findMax_recursive(x.getRight());
        }
        return maxValue;
    }

    @Override
    public boolean contains(String s) {
        return contains_recursive(this.root, s);
    }
    private boolean contains_recursive(Node x, String s){
        if(x == null){return false;}
        int ccomp = s.compareTo(x.getValue());
        if(ccomp<0){
            boolean left_branch = contains_recursive(x.getLeft(),s);
            return left_branch;
        }
        if(ccomp>0){
            boolean right_branch = contains_recursive(x.getRight(), s);
            return right_branch;
        }
        else{
            return true;
        }
    }

    @Override
    public Node get(String s) {
        return get_recursive(this.root, s);
    }
    private Node get_recursive(Node x, String s){
        if(x == null){ return null;}
        //if(x.getValue().equals(s)){return x;}
        int ccomp = s.compareTo(x.getValue());
        if(ccomp<0){
            Node left_branch = get_recursive(x.getLeft(), s);
            return left_branch;
        }
        if(ccomp>0){
            Node right_branch = get_recursive(x.getRight(), s);
            return right_branch;
        }
        else{
            return x;
        }
    }

    @Override
    public int size() {
        return this.size;
    }
}
