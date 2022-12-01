//import java.text.SimpleDateFormat;
//import java.util.Date;
public class Main {
    public static void main(String[] args) {
        //Date currentDate = new Date();
        //SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd hh:mm");
        LinkedList test = new LinkedList();               
        for(int i = 0; i <= 5; i++) {
            test.addNode("Rain", true);
        }
        test.display();
        for(int i = 0; i <= 5; i++) {
            test.addNode("No Rain", true);
        }
        test.display();
        test.addNode("Snow", true);
        test.display();
        test.addNode("Rain", true);
        test.display();
        test.search("No Rain");
    }
}
