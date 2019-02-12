
//Mohamed Elayat et Fatima Mostefai

public class LinkedList {
    public Node head;

    public LinkedList(){
        head = null;
    }

    //  Constructor to create linkedlist with size size
    public LinkedList(int size){
        for(int i=size; i>=0; i--){
            insertFirst(i);
        }
    }

    //  Function to insert at first
    public void insertFirst(int val){
        Node n = new Node(val);
        linkFirst(n);
    }

    //  Function to insert at first
    public void linkFirst(Node n){
        if(head == null){
            n.next = head;
            this.head = n;
        } else {
            n.next = head;
            head.prev = n;
            n.prev = null;
            this.head = n;
        }
    }
    //  Function to unlink a node from the linkedlist
    public void unlinkNode(Node n){
        if(n == head){
            n.next.prev = null;
            head = n.next;
        } else if(n.next == null){
            n.prev.next = null;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
    }


    public void display(){
        Node n = head;
        while(n.next != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println("\n");
    }

    public void write(){
        Node n = head;
        while(n.next != null){
            System.out.write(n.data);
            n = n.next;
        }
    }

}
