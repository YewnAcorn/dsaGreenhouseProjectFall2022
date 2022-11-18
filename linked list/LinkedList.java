// doubly linked list that allows movement between next and previous node
// TO DO: add search and sort functions, add queue functionality (FIFO, 30 day node limit)
public class LinkedList
{
	public Node head;

	// the first node in the linked list
	public void start(String new_status, String new_date, boolean new_water)
	{
		Node node = new Node(new_status, new_date, new_water);
		node.next = head;
        node.prev = null;
		if(head != null)
		{
			head.prev = node;
		}
        head = node;
	}

    // adds a node to the end (push and start may be optimized into one function??)
    public void push(String new_status, String new_date, boolean new_water) {
        Node node = new Node(new_status, new_date, new_water);
        Node last = head;
        node.next = null;

        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
    }
     
    public void search(String x) {

    }

    public void sort() {
        
    }
}