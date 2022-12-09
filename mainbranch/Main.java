public class Main {
  public static void main(String[] args){
       
    
    CallAPI.call();

    Parser.read("./output.json");
        //Write_Out to weather_data.txt

    LinkedList(./weather_data.txt);
    shotcaller(./weather_data.txt);
    // will need to instantiate read and write classes
    
    // cron is going to call main
    
    // get the weather info
    // it's going to store the current weather data into output.json, which is a staging file
    // output.json gets overwritten every time we run the script
    
    // shotcaller decides whether to water, writes what we did/didn't do in activity_log.txt
    // should send 0 or 1 output to power to the pins
    

}
