package a4;


public class PriorityQueue implements Queue{

    private Prioritized[] heap;
    private int size;
    private static final int arraySize = 10000; // Everything in the array will initially
    // be null. This is ok! Just build out
    // from array[1]. Don't change the value of this variable.

    public PriorityQueue() {
        heap = new Prioritized[arraySize];
        size = 0;
        heap[0] = new Prioritized(Double.NaN, Double.NaN); //0th will be unused for simplicity
                                                            //of child/parent computations
    }

    // fill in the methods below based on the descriptions in the Queue interface. Do NOT change the interface or any
    // of the method signatures
    @Override
    public void enqueue(double value, double priority) {
        recEnqueue(value, priority, heap, this.size + 1);
    }
    private void recEnqueue(double value, double priority, Prioritized[] heap, int index){
        if(index==1){
            Prioritized priObject = new Prioritized(value, priority);
            heap[index] = priObject;
            this.size = this.size + 1;
            return;
        }
        if(priority >= heap[Math.floorDiv(index, 2)].getPriority()) {
            heap[index] = heap[Math.floorDiv(index, 2)];
            recEnqueue(value, priority, heap, Math.floorDiv(index, 2));
            return;
        }
        Prioritized priObject = new Prioritized(value, priority);
        heap[index] = priObject;
        size += 1;
        return;
    }

    @Override
    public double dequeue() {
        Prioritized priObj = heap[1];
        heap[1] = null;
        Prioritized bubbleObj = heap[size];
        heap[size] = null;
        recDequeue(heap, bubbleObj, 1);
        if(size == 0){
            return 0.0;
        }
        size -= 1;
        return priObj.getValue();
    }

    private void recDequeue(Prioritized[] heap, Prioritized lastNode, int index){
        if(size==0){return;}
        if (heap[(index*2)] == null ){
            heap[index] = lastNode;
            return;
        }
        double compPrio;
        int newIndex = index*2;
        if (heap[newIndex + 1] == null){
            compPrio = heap[newIndex].getPriority();
        }
        else if(heap[newIndex].getPriority()>heap[newIndex + 1].getPriority()){
            compPrio = heap[newIndex].getPriority();
        }
        else{
            compPrio = heap[(newIndex)+1].getPriority();
            newIndex += 1;
        }
        if(compPrio>= lastNode.getPriority()){
            heap[index] = heap[newIndex];
            recDequeue(this.heap, lastNode, newIndex);
            return;
        }
        heap[index] = lastNode;
        return ;
    }

    @Override
    public double front() {
        if(size == 0){
            return 0.0;
        }
        return heap[1].getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        if(size==0){return true;}
        return false;
    }

    @Override
    public double[] sort() {
        double[] sortedQueue = new double[size];
        int numIter = size;
        int i = 0;
        while (i < numIter) {
            double newItem = this.dequeue();
            sortedQueue[i] = newItem;
            i++;
        }
        int k = 0;
        while (k < Math.floorDiv(numIter, 2)) {
            double tempVal = sortedQueue[k];
            sortedQueue[k] = sortedQueue[numIter - 1 - k];
            sortedQueue[numIter - 1 - k] = tempVal;
            k++;
        }
        return sortedQueue;
    }


    @Override
    public void build(Prioritized[] elements) {
        int i = 0;
        while(i<elements.length){
            heap[i+1] = elements[i];
            size += 1;
            i++;
        }
        recBuild(heap, Math.floorDiv(size, 2), Math.floorDiv(size, 2));

    }

    private void recBuild(Prioritized[] heap, int index, int parent){
        if(parent==0){return;}
        if (heap[(index*2)] == null ){
            parent -= 1;
            recBuild(heap, parent, parent);
            return;
        }
        double compPrio;
        int newIndex = index*2;
        if (heap[newIndex + 1] == null){
            compPrio = heap[newIndex].getPriority();
        }
        else if(heap[newIndex].getPriority()>heap[newIndex + 1].getPriority()){
            compPrio = heap[newIndex].getPriority();
        }
        else{
            compPrio = heap[(newIndex)+1].getPriority();
            newIndex += 1;
        }
        if(compPrio>= heap[index].getPriority()){
            Prioritized tempObj = new Prioritized(heap[index].getValue(), heap[index].getPriority());
            heap[index] = heap[newIndex];
            heap[newIndex] = tempObj;
            recBuild(this.heap, newIndex, parent);
            return;
        }
        recBuild(this.heap, parent -1, parent -1);
        return ;
    }


    // do not change
    public Prioritized[] getHeap() {
        return heap;
    }
}
