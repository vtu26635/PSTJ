package tasks;
import java.util.Scanner;

	public class AddStrings {

	    public static String addNumberStrings(String input1, String input2) {

	        StringBuilder result = new StringBuilder();

	        int i = input1.length() - 1;
	        int j = input2.length() - 1;
	        int carry = 0;

	        while (i >= 0 || j >= 0 || carry > 0) {

	            int sum = carry;

	            if (i >= 0) {
	                sum += input1.charAt(i) - '0';
	                i--;
	            }

	            if (j >= 0) {
	                sum += input2.charAt(j) - '0';
	                j--;
	            }

	            result.append(sum % 10);
	            carry = sum / 10;
	        }

	        return result.reverse().toString();
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter first number: ");
	        String input1 = sc.next();

	        System.out.print("Enter second number: ");
	        String input2 = sc.next();

	        String result = addNumberStrings(input1, input2);
	        System.out.println("Sum = " + result);

	        sc.close();
	    }
	}


