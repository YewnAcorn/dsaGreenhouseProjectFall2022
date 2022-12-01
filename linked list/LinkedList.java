public class LinkedList {
    Node head, tail = null;
    int size = 0;

    //addNode() will add a node to the list  
    public void addNode(String new_status, boolean new_water) {  
        //Create a new node  
        Node newNode = new Node(new_status, new_water);  
        //If list is empty  
        if(head == null) {  
            //Both head and tail will point to newNode  
            head = tail = newNode;  
            //head's previous will point to null  
            head.prev = null;  
            //tail's next will point to null, as it is the last node of the list  
            tail.next = null;  
        }  
        else {
            // added queue functionality (FIFO), when it reaches specified size, will delete the front node before adding node the end
            if (size >= 5) {
                deleteFront();
            }  
            //newNode will be added after tail such that tail's next will point to newNode  
            tail.next = newNode;  
            //newNode's previous will point to tail  
            newNode.prev = tail;  
            //newNode will become new tail  
            tail = newNode;  
            //As it is last node, tail's next will point to null  
            tail.next = null;  
        }
        size++;  
    }

    public boolean isEmpty() {
        return (head == null);
    }
    
    public void deleteFront() {
        if (isEmpty()) {
        System.out.print("UnderFlow\n");
        }
        else {
            //Node temp = head;
            head = head.next;
     
            // If only one element was present
            if (head == null)
              tail = null;
            else
              head.prev = null;
     
            // Decrements count of elements by 1
            size--;
          }
    }
  
    //display() will print out the nodes of the list  
    public void display() {  
        //Node current will point to head  
        Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        System.out.println("Nodes of doubly linked list: ");  
        while(current != null) {  
            //Prints each node by incrementing the pointer.  
  
            System.out.println(current.date + ", " + current.status + ", " + current.water);  
            current = current.next;  
        }  
    }
    // searches queue for most recent node with specified status (Rain, No Rain)
    public void search(String value) {
        int i = 5;  
        boolean flag = false;  
        // starts search at tail, to search more recent nodes first
        Node current = tail;  
          
        //Checks whether the list is empty  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        while(current != null) {  
            //Compare value to be searched with each node in the list  
            if(current.status == value) {  
                flag = true;  
                break;  
            }  
            current = current.prev;  
            i--;  
        }  
        if(flag)  
             System.out.println("Position " + i + ", " + current.date + ", " + current.status + ", " + current.water);  
        else  
             System.out.println("Node is not present in the list"); 
    }
}
