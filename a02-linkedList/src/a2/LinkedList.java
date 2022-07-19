package a2;

public class LinkedList {
    private Node head = null;
    private Node tail = null;
    private int size = 0;


    public void removeAtIndex(int i) {
        validIndex(i);
        Node current = head;
        if(i == 0){
            head = current.getNext();
            size = size - 1;
            return;
        }
        int index = 1;
        while((i)>index){
            current = current.getNext();
            index++;
        }
        current.setNext(current.getNext().getNext());
        size = size - 1;
    }


    public int mean() {
        Node current = head;
        int valuesSum = 0;
        int i = 0;
        while(i<size){
            valuesSum += current.getValue();
            current = current.getNext();
            i++;
        }
        int avg = Math.floorDiv(valuesSum, size);
        return avg;
    }


    public boolean isEqual(LinkedList list2) {
        if(size != list2.size()){
            return false;
        }
        if(this.isEmpty()){
            return false;
        }
        Node currentList1 = head;
        Node currentList2 = list2.getHead();
        int i = 0;
        System.out.println(currentList1.getValue());
        while(i <size){
            if(currentList1.getValue() != currentList2.getValue()){
                return false;
            }
            currentList1 = currentList1.getNext();
            currentList2 = currentList2.getNext();
            i++;
        }
        return true;
    }


    public void removeOdds() {
        Node current = head;
        int i = 0;
        while(i<(size-1)){
            current.setNext(current.getNext().getNext());
            current = current.getNext();
            i += 2;
            size = size - 1;
        }
    }


    public boolean isSymmetrical() {
        int ifront = 0;
        int iback = size - 1;
        while(ifront <= iback){
            if(this.get(ifront) == this.get(iback)){
                ifront++;
                iback = iback - 1;
            }
            else{return false;}
        }
        return true;
    }


    public void multiply(int factor) {
        if(factor == 0){
            this.clear();
        }
        Node current = head;
        while(current != null){
            for(int i = 1; i < factor; i++){
                Node sameNode = new NodeImpl(current.getValue(), current.getNext());
                current.setNext(sameNode);
                current = current.getNext();
            }
            current = current.getNext();
        }
        size = size*factor;
    }

    public void reverse() {
        Node current = head;
        int i = 1;
        int indexCopying = 0;
        while(i<size){
            current = current.getNext();
            int newTailValue = this.get(size-2-indexCopying);
            this.removeAtIndex(size-2-indexCopying);
            while(current.getNext() != null){
                current = current.getNext();
            }
            Node newTail = new NodeImpl(newTailValue, null);
            current.setNext(newTail);
            size++;
            i++;
            indexCopying++;
        }
    }



    public void removeRepeats() {
        Node current = head;
        int i = 0;
        while(current.getNext() != null){
            //System.out.println(current.getValue());
            if(current.getValue() == current.getNext().getValue()){
                //i++;
                this.removeAtIndex(i);
                i = i - 1;
            }
            current = current.getNext();
            i++;
        }
    }


    public boolean containsCycle() {
        Node current = head;
        int i = 0;
        while(i<size){
            current = current.getNext();
            i++;
        }
        if (current.getNext() != null){
            return true;
        }
        return false;
    }


    public void merge(LinkedList list2) {
        if(this.size < list2.size()){
            return;
        }
        Node current2 = list2.getHead();
        int i = 0;
        int insertingIndex = 1;
        while(i < list2.size()){
            this.add(insertingIndex, current2.getValue());
            current2 = current2.getNext();
            i++;
            insertingIndex = insertingIndex + 2;
        }

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /*
    Returns true if the list contains a node whose value matches the element parameter, false otherwise
     */
    public boolean contains(int element) {
        Node current = head;
        while(current != null) {
            if(current.getValue() == element) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /*
    converts the linked list into an array
     */
    public int[] toArray() {
        int[] arr =  new int[size()];
        Node current = head;
        int i = 0;
        if(isEmpty()) {
            return arr;
        }
        while(current != null){
            arr[i] = current.getValue();
            current = current.getNext();
            i++;
        }
        return arr;
    }

    /*
    adds a node to the end of the list
     */
    public void add(int element) {
        Node newNode = new NodeImpl(element, null);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }

    }

    /*
    removes the element from the list
     */
    public boolean remove(int element) {
        Node current = head;
        if(isEmpty()) {
            return false;
        }
        if(current.getValue() == element){
            head = head.getNext();
            size--;
            return true;
        }
        while(current.getNext().getValue() != element) {
            current = current.getNext();
            if(current == null) {
                return false;
            }
        }
        if(current.getNext().getNext() == null) {
            tail = current;
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    /*
        returns the value at the index parameter.
     */
    public int get(int index) {
        validIndex(index);
        Node current = head;
        int i = 0;
        while (i < index) {
            current = current.getNext();
            i++;
        }
        return current.getValue();
    }

    /*
    sets the value of the node at index to the element
     */
    public int set(int index, int element) {
        validIndex(index);
        Node current = head;
        int prevValue = 1;
        int i = 0;
        if(index == 0) {
            prevValue = head.getValue();
            head.setValue(element);
        } else {
            while(current != null) {
                if(i == index) {
                    prevValue = current.getValue();
                    current.setValue(element);
                    return prevValue;
                }
                current = current.getNext();
                i++;
            }
        }

        return prevValue;
    }

    /*
    adds a node at the given index with the given element as its value
     */
    public void add(int index, int element) {
        if(index > size) {
            validIndex(index);
        }
        Node current = head;
        int i = 0;
        if(index == 0) {
            if(isEmpty()) {
                add(element);
                return;
            } else {
                Node newNode = new NodeImpl(element, head);
                head = newNode;
                size++;
                return;
            }

        }  else if(index == size) {
            add(element);
            return;
        }
        while(current != null) {
            if(i == (index - 1)) {
                Node temp = current.getNext();
                Node newNode = new NodeImpl(element, temp);
                current.setNext(newNode);
                size++;
                return;
            } else {
                current = current.getNext();
                i++;
            }
        }
    }

    /*
    returns the index of the given element
     */
    public int indexOf(int element) {
        Node current = head;
        int index = 0;
        while(current != null) {
            if(current.getValue() == element) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    /*
    returns the last index of the element
     */
    public int lastIndexOf(int element) {
        Node current = head;
        int index = -1;
        int i = 0;
        while(current != null) {
            if(current.getValue() == element) {
                index = i;
            }
            i++;
            current = current.getNext();
        }
        return index;
    }

    public void validIndex(int i) {
        if(i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public Node getHead() {
        return head;
    }

    /* prints out list */
    public String toString() {
        String list = "";
        Node current = head;
        while(current != null) {
            if(current.getNext() == null)
                list+= current.getValue();
            else
                list += current.getValue() + " -> ";
            current = current.getNext();
        }
        return list;
    }

}
