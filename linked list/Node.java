import java.text.SimpleDateFormat;
import java.util.Date;
public class Node {
    // automatically records date whenever a new node is created
    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd hh:mm");
    public String date = dateFormat.format(currentDate);
    public String status;
    public Node next;
    public Node prev;
    public boolean water;
    Node(String x, boolean z) { status = x; water = z; }
}
