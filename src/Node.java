
//Mohamed Elayat et Fatima Mostefai

public class Node {

    public int data;
    public Node next;
    public Node prev;

    public Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public Node(int data, Node next, Node prev){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

}
