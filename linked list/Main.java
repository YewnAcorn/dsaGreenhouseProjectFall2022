import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {
    public static void main(String[] args) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd hh:mm");
        LinkedList test = new LinkedList();
        for(int i = 0; i <= 5; i++) {
            test.addNode("Snow", "12/04/2022 04:08",true);
        }               
        test.addNode("Snow", "12/04/2022 04:10",true);
        test.addNode("Rain", "12/04/2022 04:15",true);
        test.addNode("Rain", "12/04/2022 04:21",true);
        test.addNode("Snow", "12/04/2022 04:28",true);
        //test.addNode("Rain", "12/04/2022 04:30",true);
        test.display();
        test.searchOldest("Rain");
        test.searchNewest("Snow");
        test.sortedWaterTimes();
    }
}
