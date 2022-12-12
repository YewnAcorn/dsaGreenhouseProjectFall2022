import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
public class LinkedList {
    Node head, tail = null;
    int size = 0;
    int capacity = 30;

    // addNode() will both begin a list, and add a node to the end of the list
    // Queue, when capacity is reached, will delete head before adding new node to end. 
    public void addNode(String new_weather, String new_date, String new_temp, boolean new_water) {  
        Node newNode = new Node(new_weather, new_date, new_temp, new_water);  
        if(head == null) {  
            head = tail = newNode;  
            head.prev = null;   
            tail.next = null;  
        }  
        else {
            if (size >= capacity) {
                deleteFront();
            }  
            tail.next = newNode;  
            newNode.prev = tail;  
            tail = newNode;  
            tail.next = null;
        }
        size++;  
    }

    // Returns whether linked list is empty(true), or not (false).
    private boolean isEmpty() {
        return (head == null);
    }

    // Removes the head of the list.
    private void deleteFront() {
        if (isEmpty()) {
        System.out.print("UnderFlow\n");
        }
        else {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            else {
                head.prev = null;
            }
            size--;
        }
    }
  
    // Prints out the nodes of the list (if any).
    public void display() {  
        Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");
        }
        else {  
            System.out.println("Nodes of doubly linked list: ");  
            while(current != null) {      
                System.out.println(current.date + ", "
                                    + current.weather + ", "
                                    + current.temp + ", "
                                    + current.water);  
                current = current.next;
            }
        }  
    }

    // Searches queue for the most recent node with specified weather value, then prints the node.
    public void searchNewest(String value) {  
        boolean flag = false;  
        Node current = tail;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        while(current != null) {  
            if(current.weather == value) {  
                flag = true;  
                break;  
            }  
            current = current.prev; 
        }  
        if(flag) {  
             System.out.println("Most recent instance of " + current.weather + ":");
             System.out.println(current.date + ", "
                                + current.temp + ", "
                                + current.water);
        }
        else {
             System.out.println("Node is not in the list");
        }
    }

    // Searches queue for the least recent node with specified weather value, then prints the node.
    public void searchOldest(String value) {
        boolean flag = false;
        Node current = head;   
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        while(current != null) {  
            if(current.weather == value) {  
                flag = true;
                break;  
            }  
            current = current.next;
        }  
        if(flag) {
            System.out.println("Least recent instance of " + current.weather + ":");
            System.out.println(current.date + ", "
                               + current.temp + ", "
                               + current.water);
        }
        else {
             System.out.println("Node is not in the list");
        }
    }
    
    // Searches queue for nodes with a true water value (meaning plants were watered).
    // Then, timeDifference is called, which takes two dates with true water values and
    // finds the difference in time between them. Then, the difference is returned and
    // both stored and sorted in an ArrayList, which is then printed.
    public void sortedWaterTimes() {
        ArrayList<Long> returnList = new ArrayList<>();
        Node current = head;
        String lastWater = current.date;
        String waterBeforeThat;
        if(head == null) {  
            System.out.println("List is empty");   
        }  
        while(current != null) {    
            if(current.water == true) {
                waterBeforeThat = lastWater;  
                lastWater = current.date;
                // To skip over first hit, since both waterBeforeThat and lastWater will be the same date.
                if(waterBeforeThat != lastWater) {
                    returnList.add(checkLastWater(waterBeforeThat, lastWater));
                }
            }  
            current = current.next;   
        }
        returnList.sort(null);
        System.out.print(returnList);
    }

    // Used in sortedWaterTimes to find the difference in time between two dates. 
    private Long checkLastWater(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Long difference_In_Days = 0L;
        try {
            // Parse method is used to parse the text from a string to produce the date.
            Date d1 = sdf.parse(date1);
            Date d2 = sdf.parse(date2);
 
            // Calculate time difference in milliseconds.
            Long difference_In_Time = d2.getTime() - d1.getTime();
            // Convert difference to days.
            difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
            System.out.println("Difference " + "between: " + date1 + " and: "
                             + date2 + " is: " + difference_In_Days + " days");

                
        }
        // Catch the Exception.
        catch (ParseException e) {
            e.printStackTrace();
        }
        return difference_In_Days;
    }
}
