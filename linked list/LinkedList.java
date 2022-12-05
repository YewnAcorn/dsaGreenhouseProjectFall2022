import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class LinkedList {
    Node head, tail = null;
    int size = 0;

    //addNode() will add a node to the list  
    public void addNode(String new_status, String new_date, boolean new_water) {  
        //Create a new node  
        Node newNode = new Node(new_status, new_date, new_water);  
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
    public void searchNewest(String value) {
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

    // searches queue for least recent node with specified status (Rain, No Rain)
    public void searchOldest(String value) {
        int i = 0;  
        boolean flag = false;  
        // starts search at tail, to search more recent nodes first
        Node current = head;  
          
        //Checks whether the list is empty  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        while(current != null) {  
            //Compare value to be searched with each node in the list  
            if(current.status == value) {  
                flag = true;
                i++;  
                break;  
            }  
            current = current.next;  
            i++;  
        }  
        if(flag)  
             System.out.println("Position " + i + ", " + current.date + ", " + current.status + ", " + current.water);  
        else  
             System.out.println("Node is not present in the list"); 
    }

    public void sortedWaterTimes() {
        ArrayList<Long> returnList = new ArrayList<>();
        Node current = head;
        String lastWater = current.date;
        String waterBeforeThat;
        if(head == null) {  
            System.out.println("List is empty");  
            //return null;  
        }  
        while(current != null) {  
            //Compare value to be searched with each node in the list  
            if(current.water == true) {
                waterBeforeThat = lastWater;  
                lastWater = current.date;
                // to skip over first hit, since both waterBeforeThat and lastWater would be the same date
                if(waterBeforeThat != lastWater) {
                    returnList.add(checkLastWater(waterBeforeThat, lastWater));
                }
            }  
            current = current.next;   
        }
        returnList.sort(null);
        System.out.print(returnList);
        //return returnList;  
    }

    public Long checkLastWater(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm");
        Long difference_In_Time = 0L;
        try {
 
            // parse method is used to parse
            // the text from a string to
            // produce the date
            Date d1 = sdf.parse(date1);
            Date d2 = sdf.parse(date2);
 
            // Calculate time difference
            // in milliseconds
            difference_In_Time = d2.getTime() - d1.getTime();
 
            // Calculate time difference in
            // seconds, minutes, hours, years,
            // and days
            Long difference_In_Seconds = (difference_In_Time / 1000) % 60;
 
            Long difference_In_Minutes = (difference_In_Time / (1000 * 60)) % 60;
 
            Long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;
 
            //Long difference_In_Years = (difference_In_Time / (1000l * 60 * 60 * 24 * 365));
 
            Long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
 
            // Print the date difference in
            // years, in days, in hours, in
            // minutes, and in seconds
 
            System.out.print("Difference " + "between two dates is: ");
 
            System.out.println(
                //difference_In_Years
                //+ " years, "
                + difference_In_Days
                + " days, "
                + difference_In_Hours
                + " hours, "
                + difference_In_Minutes
                + " minutes, "
                + difference_In_Seconds
                + " seconds");
                
        }
        // Catch the Exception
        catch (ParseException e) {
            e.printStackTrace();
        }
        return difference_In_Time;
    }
}
