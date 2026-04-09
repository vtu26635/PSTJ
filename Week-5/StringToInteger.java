package tasks;
public class StringToInteger {

    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;

        int i = 0, n = s.length();
        int sign = 1;
        long result = 0;

       
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

     
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');

           
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (sign * result);
    }

    public static void main(String[] args) {
        StringToInteger solution = new StringToInteger();

    
        String test1 = "   -42";
        String test2 = "4193 with words";
        String test3 = "words and 987";
        String test4 = "-91283472332"; // Overflow case

        System.out.println("Test 1: " + solution.myAtoi(test1)); // Output: -42
        System.out.println("Test 2: " + solution.myAtoi(test2)); // Output: 4193
        System.out.println("Test 3: " + solution.myAtoi(test3)); // Output: 0
        System.out.println("Test 4: " + solution.myAtoi(test4)); // Output: -2147483648
    }
}