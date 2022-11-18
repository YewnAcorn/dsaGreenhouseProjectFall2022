public class Node {
    public String status;
	public String date;
    public Node next;
    public Node prev;
    public boolean water;
    Node(String x, String y, boolean z) { status = x; date = y; water = z; }
}
