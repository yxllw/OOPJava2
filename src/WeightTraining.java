public class WeightTraining extends AbstractExercise implements ComplexExercise{
    private int size;
    private Node head, tail;
    public WeightTraining(){
        this.head = null;
        this.tail = null;
    }
    public WeightTraining(String name, Approach[] approaches){
        size = approaches.length;
        head = new Node();
        Node current = head;
        for (Approach approach: approaches) {
            current.next = new Node(approach);
             current = current.next;
        }
        tail = current;
        tail.next = head;
    }
    public WeightTraining(String name, Equipments equipments, Approach[] approaches){
        super(name, equipments);
        size = approaches.length;
        head = new Node();
        Node current = head;
        for (Approach approach: approaches) {
            current.next = new Node(approach);
            current = current.next;
        }
        tail = current;
        tail.next = head;
    }
    public boolean add(Approach approach){
        if(head == null) {
            head = tail = new Node();
            head.next = tail;
        }
        Node current = head.next;
        for(int i = 0; i < size; i++){
            current = current.next;
        }
        return addNode(new Node(approach));
    }
    public Approach remove(){
        Node current = head;
        return removeNode(0).value;
    }
    public Approach approach(){
        return getNode(0).value;
    }
    public boolean add(int index, Approach approach){
        if (index < 0) {
            throw new IndexOutOfBoundsException("index <0");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("index > size");
        }
        Node current = head.next;
        for(int i = 0; i < size; i++){
            current = current.next;
        }
        return addNode(index, new Node(approach));
    }
    public Approach get(int index){
        if (index < 0) {
            throw new IndexOutOfBoundsException("index <0");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("index > size");
        }
        return getNode(index).value;
    }
    public Approach set(int index, Approach approach){
        if (index < 0) {
            throw new IndexOutOfBoundsException("index <0");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("index > size");
        }
        Node current = head.next;
        for(int i = 0; i < size; i++){
            current = current.next;
        }
        return setNode(index, approach);
    }
    public Approach remove(int index){
        if (index < 0) {
            throw new IndexOutOfBoundsException("index <0");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("index > size");
        }
        Node current = head;
        return removeNode(index).value;
    }
    public int size(){
        return size;
    }
    public Approach[] getApproaches(){
        Node current = head.next;
        Approach[] result = new Approach[size];
        for(int i = 0; i < size; i++){
            result[i] = current.value;
            current = current.next;
        }
        return result;
    }
    public double[] approachWeights(){
        Approach[] approaches = getApproaches();
        double[] approachWeights = new double[approaches.length];
        for(int i = 0; i < approaches.length; i++){
            approachWeights[i] = approaches[i].getWeight();
        }
        return approachWeights;
    }
    public int[] approachQuantities(){
        Approach[] approaches = getApproaches();
        int[] approachQuantities = new int[approaches.length];
        for(int i = 0; i < approaches.length; i++){
            approachQuantities[i] = approaches[i].getAttemptsQuantity();
        }
        return approachQuantities;
    }
    public int getDuration(){
        Node current;
        int result = 0;
        for(int i = 0; i < size; i++) {
            current = head.next;
            result += current.value.getDuration();
            current = current.next;
        }
        return result;
    }
    public void setDuration(int duration){}
    public boolean remove(Approach approach){
        Node current = head.next;
        for(int i = 0; i < size; i++){
            if(current.value.equals(approach)){
                removeNode(i);
                return true;
            }
        }
        return false;
    }
    public int indexOf(Approach approach){
        Node current = head.next;
        for(int i = 0; i < size; i++){
            if(current.value.equals(approach)){
                return i;
            }
            current = current.next;
        }
        return -1;
    }
    public int lastIndexOf(Approach approach){
        int index = -1;
        Node current = head.next;
        for(int i = 0; i < size; i++){
            if(current.value.equals(approach)){
                index = i;
            }
            current = current.next;
        }
        return index;
    }
    private boolean addNode(Node node){
        tail.next = node;
        tail = tail.next;
        tail.next = head;
        size++;
        return true;
    }
    private boolean addNode(int index, Node node){
        if (index < 0) {
            throw new IndexOutOfBoundsException("index <0");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("index > size");
        }
        Node current = head.next;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        size++;
        return true;
    }
    private Node getNode(int index){
        if (index < 0) {
            throw new IndexOutOfBoundsException("index <0");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("index > size");
        }
        Node current = head.next;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }
    private Node removeNode(int index){
        if (index < 0) {
            throw new IndexOutOfBoundsException("index <0");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("index > size");
        }
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        size--;
        return current;
    }
    private Approach setNode(int index, Approach approach){
        if (index < 0) {
            throw new IndexOutOfBoundsException("index <0");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("index > size");
        }
        Node current = head.next;
        for(int i = 0; i <= index; i++){
            current = current.next;
        }
        Approach buff = current.value;
        current.value = approach;
        return buff;
    }
    public class Node{
        Node next;
        Approach value;
        Node() {}
        Node(Approach value){
            this.value = value;
        }
    }
    @Override
    public String toString(){
        Node current;
        StringBuilder str = new StringBuilder(super.toString() + ". Approaches\n");
        if (size != 0) {
            current = head.next;
            for (int i = 0; i < size; ++i) {
                str.append(current.value.toString()).append("\n");
                current = current.next;
            }
        }
        return str.toString();
    }
    @Override
    public int hashCode(){
        Node current;
        int hash = super.hashCode() * 71;
        if(size != 0){
            current = head.next;
            for(int i = 0; i < size; i++){
                hash *= current.value.hashCode();
                current = current.next;
            }
        }
        return hash;
    }
    @Override
    public boolean equals(Object object){
        WeightTraining wt = (WeightTraining) object;
        return size == wt.size && head == wt.head && tail == wt.tail;
    }
}
