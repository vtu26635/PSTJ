package tasks;
import java.util.Scanner;


public class TimeConversion {

    
    public static String timeConversion(String s) {
      
        String period = s.substring(8, 10);
        
       
        int hour = Integer.parseInt(s.substring(0, 2));
        
        String minuteSecond = s.substring(2, 8);

        if (period.equalsIgnoreCase("AM")) {
            if (hour == 12) {
                hour = 0;
            
        } else { 
            if (hour != 12) {
                hour += 12;
            }
        }
        return String.format("%02d%s", hour, minuteSecond);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter time (hh:mm:ssAM/PM): ");
        if (scan.hasNextLine()) {
            String input = scan.nextLine();
            String result = timeConversion(input);
            System.out.println("Military Time: " + result);
        }
        
        scan.close();
    }
}

