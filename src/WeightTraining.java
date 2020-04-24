public class WeightTraining implements ComplexExercise{
    private String name;
    private int size;
    private Node head, tail;
    public WeightTraining(String name){
        this.name = name;
        this.head = null;
        this.tail = null;
    }
    public WeightTraining(String name, Approach[] approaches){
        this.name = name;
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
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
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
}
